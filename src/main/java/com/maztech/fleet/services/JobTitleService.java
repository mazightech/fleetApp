package com.maztech.fleet.services;

import com.maztech.fleet.entities.JobTitle;
import com.maztech.fleet.repos.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleService {
    @Autowired
    JobTitleRepository jobTitleRepository;

    //return list of jobTitle
    public List<JobTitle> getJobTitles() {
        return jobTitleRepository.findAll();
    }

    //Save new jobTitle
    public void saveJobTitle(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    public JobTitle findJobTitleById(int id){
        return jobTitleRepository.findById(id).get();
    }


    public void deleteJobTitle(int id) {
        jobTitleRepository.deleteById(id);
    }
}
