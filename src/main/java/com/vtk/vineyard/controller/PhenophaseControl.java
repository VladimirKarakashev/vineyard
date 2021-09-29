package com.vtk.vineyard.controller;

import com.vtk.vineyard.model.Phenophase;
import com.vtk.vineyard.service.PhenophaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PhenophaseControl {

    @Autowired
    public PhenophaseService phService;

    @RequestMapping(value = "/phenophase")
    public String getPhenophase(Model model) {
        // String key = CalendarGenerator.generateMothName(); used for testing
        List<Phenophase> phenophaseList = phService.findAll();
        model.addAttribute("phenophaseList", phenophaseList);
        return "phenophase";
    }

}
