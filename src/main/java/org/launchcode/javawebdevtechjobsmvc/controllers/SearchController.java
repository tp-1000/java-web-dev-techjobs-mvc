package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController{

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", getColumnChoices());
        return "search";
    }

    @PostMapping("/results")
    public String processSearchRequest(Model model, @RequestParam String searchTerm, @RequestParam String searchType){
        ArrayList<Job> jobs;
        model.addAttribute("columns", getColumnChoices());

        if(searchType.equals("all")){
            if(searchTerm.equals("") || searchTerm.toLowerCase().equals("all")){
                jobs = JobData.findAll();
            }
            else {
                jobs = JobData.findByValue(searchTerm);
            }
            model.addAttribute("jobs", jobs);
            return "search";
        }

        JobData.findByValue(searchTerm);
        jobs = JobData.findByColumnAndValue(searchType,searchTerm);
        model.addAttribute("jobs", jobs);
        return "search";
    }
}
