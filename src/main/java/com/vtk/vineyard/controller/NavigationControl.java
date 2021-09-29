package com.vtk.vineyard.controller;

import com.vtk.vineyard.model.Culture;
import com.vtk.vineyard.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NavigationControl {

    @Autowired
    public CultureService cultService;

    @GetMapping("/index")
    public String getIndex(Model model) {
        List<Culture> cultureList = cultService.listAll();
        model.addAttribute("cultureList",cultureList);
        return "index";
    }

    @GetMapping("/basics/terminology")
    public String getTerminology(Model model) {

        return "/basics/terminology";
    }

    @GetMapping("/basics/useful_tips")
    public String getUsefulTips(Model model) {

        return "/basics/useful_tips";
    }

    @GetMapping("/basics/common_mistakes")
    public String getCommonMistakes(Model model) {

        return "/basics/common_mistakes";
    }

    @GetMapping("/basics/pests")
    public String getPests(Model model) {

        return "/basics/pests";
    }

    @GetMapping("/basics/illnesses")
    public String getIllnesses(Model model) {

        return "/basics/illnesses";
    }


    @GetMapping("/login")
    public String getLogin(Model model) {

        return "login";
    }
}
