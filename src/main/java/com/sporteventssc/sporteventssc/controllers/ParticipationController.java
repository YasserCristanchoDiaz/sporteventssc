package com.sporteventssc.sporteventssc.controllers;

import com.sporteventssc.sporteventssc.entities.Event;
import com.sporteventssc.sporteventssc.entities.Participant;
import com.sporteventssc.sporteventssc.entities.Participation;
import com.sporteventssc.sporteventssc.response.ResponseHandler;
import com.sporteventssc.sporteventssc.services.EventService;
import com.sporteventssc.sporteventssc.services.ParticipantService;
import com.sporteventssc.sporteventssc.services.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participation")
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @Autowired
    private EventService eventService;

    @Autowired
    private ParticipantService participantService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Participation> result = participationService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            Participation result = participationService.findById(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/{idEvent}-{idParticipant}")
    public ResponseEntity<Object> save(@RequestBody Participation participation,
                                       @PathVariable Integer idEvent, @PathVariable Integer idParticipant) {
        try {
            Event event = eventService.findById(idEvent);
            Participant participant = participantService.findById(idParticipant);
            if (event != null && participant != null) {
                Participation result = participationService.save(participation, event, participant);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
            }
            return ResponseHandler.generateResponse("Event or Participant Not Found", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Participation result = participationService.delete(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
