package com.maztech.fleet.services;

import com.maztech.fleet.entities.State;
import com.maztech.fleet.repos.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    //return list of countries
    public List<State> getStates() {
        return stateRepository.findAll();
    }

    //Save new state
    public void saveState(State state){
        stateRepository.save(state);
    }

    public State findStateById(int id){
        return stateRepository.findById(id).get();
    }


    public void deleteState(int id) {
        stateRepository.deleteById(id);
    }
    
}
