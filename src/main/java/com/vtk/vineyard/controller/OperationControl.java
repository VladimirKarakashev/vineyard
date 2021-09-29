package com.vtk.vineyard.controller;

import com.vtk.vineyard.model.Operation;
import com.vtk.vineyard.repositoy.OperationRepo;
import com.vtk.vineyard.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class OperationControl {

    @Autowired
    private OperationService opServ;

    @Autowired
    private OperationRepo opRepo;

    @RequestMapping("/operations")
    public String getOperations(Model model, @Param("key") String key) {

    //table data gathering
        List<Operation> listOperations = opServ.listAll(key);
        Float opsTotalCosts = opRepo.findAllByCost(key);
        Float opsTimeSpent = opRepo.findAllByDuration(key);
        Integer opsCount = opRepo.findAllById(key);

    //start of data generation for bar-chart

        //store listOperations as map with operation names and SUM total time values
        Map<String, Integer> listOpsNameTime = listOperations
                .stream()
                .collect(Collectors
                .groupingBy(Operation::getName,
                Collectors.summingInt(Operation::getDuration)));

        //store listOperations as map with operation names and SUM total cost values
        Map<String, Double> listOpsNameCosts = listOperations
                .stream()
                .collect(Collectors
                .groupingBy(Operation::getName,
                Collectors.summingDouble(Operation::getCost)));

        //list of operations' names with duplicates by keyword
        List<String> opsNamesList = opRepo.findAll(key)
                .stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());

        //count operations in opsNamesList and store number of entries for each name
        Map<String, Long> listOpsNameCount = opsNamesList
                .stream()
                .collect(Collectors
                .toMap(Function.identity(), v -> 1L, Long::sum));

        //split map listOpsNameTime into
            // keys() list
            List<String> mapListOpsName = new ArrayList<String>
                    (listOpsNameTime.keySet());
            // values() list
            List<Integer> mapListOpsTime = new ArrayList<Integer>
                    (listOpsNameTime.values());

        //split values(listOpsNameCount) list
        List<Long> listCountOps = new ArrayList<Long>
                (listOpsNameCount.values());

        //split values(listOpsNameCosts) list
        List<Double> listCountCosts = new ArrayList<Double>
                (listOpsNameCosts.values());
    //end of data generation for bar-chart

        // Lists used for reference
        List<Float> opsIndividualCost = opRepo.findAll(key)
                .stream()
                .map(x -> x.getCost())
                .collect(Collectors.toList());

        List<Integer> opsIndTimeSpent = opRepo.findAll(key)
                .stream()
                .map(x -> x.getDuration())
                .collect(Collectors.toList());

        //table stats model attributes
        model.addAttribute("listOperations", listOperations);
        model.addAttribute("opsTotalCosts", opsTotalCosts);
        model.addAttribute("opsTimeSpent", opsTimeSpent);
        model.addAttribute("opsCount", opsCount);
        model.addAttribute("key", key);

        //chart stats model attributes as reference
        model.addAttribute("opsNames", opsNamesList);
        model.addAttribute("opCost", opsIndividualCost);
        model.addAttribute("opTime", opsIndTimeSpent);

        //Time bar-chart model attributes
        model.addAttribute("mapListOpsName", mapListOpsName);
        model.addAttribute("mapListOpsTime", mapListOpsTime);
        model.addAttribute("listCountOps", listCountOps);
        model.addAttribute("listCountCosts", listCountCosts);

        //console message used for comparison between front end and backend information when displayed
        System.out.println("A total of " + opsCount + " operations selected" + '\n'
                            + "at total cost of " + opsTotalCosts + '\n'
                            + "and total time spent " + opsTimeSpent
        );

        return "operations";
    }

    @RequestMapping("/new_operation")
    public String newOperationForm(Model model) {
        Operation operation = new Operation();
        model.addAttribute("operation", operation);
        return "new_operation";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("operation") Operation operation) {
        opServ.save(operation);
        return "redirect:/operations";
    }

    @RequestMapping("/edit_operation/{id}")
    public ModelAndView editOperationForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_operation");
        Operation operation = opServ.get(id);
        mav.addObject("operation", operation);
        return mav;
    }

    @RequestMapping("/delete_operation/{id}")
    public String deleteOperation(@PathVariable(name = "id") Long id){
        opServ.delete(id);
        return "redirect:/operations";
    }


}
