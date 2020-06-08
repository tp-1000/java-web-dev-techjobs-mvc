package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

public class TechJobsController {


    private static HashMap<String, String> columnChoices = new HashMap<>();

    private static Map<String,String> actionChoices = new HashMap<>();
    public TechJobsController() {
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");
        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("positionType", "Position Type");
        columnChoices.put("coreCompetency", "Skill");
    }

    @ModelAttribute("actions")
    public static Map<String, String> getActionChoices() {
        return actionChoices;
    }

    @ModelAttribute("column")
    public static HashMap<String, String> getColumnChoices() {
        return columnChoices;
    }
}
