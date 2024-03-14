package com.sporteventssc.sporteventssc.services;

import com.sporteventssc.sporteventssc.entities.Sport;
import com.sporteventssc.sporteventssc.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

    public Sport findById(String id){
        Optional<Sport> optional = sportRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Sport save(Sport sport) {
        return sportRepository.save(sport);
    }
}
