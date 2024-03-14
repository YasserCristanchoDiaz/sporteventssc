package com.sporteventssc.sporteventssc.services;

import com.sporteventssc.sporteventssc.entities.Participant;
import com.sporteventssc.sporteventssc.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public Participant findById(String id){
        Optional<Participant> optional = participantRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }


}
