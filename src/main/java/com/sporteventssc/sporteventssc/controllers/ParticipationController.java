package com.sporteventssc.sporteventssc.controllers;

import com.sporteventssc.sporteventssc.entities.Participation;
import com.sporteventssc.sporteventssc.response.ResponseHandler;
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
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            Participation result = participationService.findById(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Participation participation) {
        try {
            Participation result = participationService.save(participation);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
