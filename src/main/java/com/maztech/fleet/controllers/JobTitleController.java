package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.JobTitle;
import com.maztech.fleet.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobTitleController {

    @Autowired
    JobTitleService jobTitleService;

    //return list of jobTitles
    @GetMapping("/jobtitle")
    public String getJobTitles(Model model){
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();

        model.addAttribute("jobTitles",jobTitleList);

        return "jobTitle";
    }

    //Save new jobTitle
    @PostMapping("/jobTitles/addNew")
    public String addJobTitle(JobTitle jobTitle) {
        jobTitleService.saveJobTitle(jobTitle);

        return "redirect:/jobtitle";
    }

    @GetMapping("jobTitles/find")
    @ResponseBody
    public JobTitle findJobTitleById(@RequestParam("id") int id){

        return jobTitleService.findJobTitleById(id);
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateJobTitle(JobTitle jobTitle) {
        jobTitleService.saveJobTitle(jobTitle);

        return "redirect:/jobtitle";
    }

    @RequestMapping(value = "/jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteJobTitle(int id) {
        jobTitleService.deleteJobTitle(id);

        return "redirect:/jobtitle";
    }
    
}
