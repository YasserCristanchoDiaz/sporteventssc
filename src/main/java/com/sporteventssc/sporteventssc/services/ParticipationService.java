package com.sporteventssc.sporteventssc.services;

import com.sporteventssc.sporteventssc.entities.Event;
import com.sporteventssc.sporteventssc.entities.Participant;
import com.sporteventssc.sporteventssc.entities.Participation;
import com.sporteventssc.sporteventssc.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService {

    @Autowired
    private ParticipationRepository participationRepository;

    public List<Participation> findAll() {
        return participationRepository.findAll();
    }

    public Participation findById(Integer id){
        Optional<Participation> optional = participationRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Participation save(Participation participation, Event event, Participant participant) {
        participation.setEvent(event);
        participation.setParticipant(participant);
        return participationRepository.save(participation);
    }
}
