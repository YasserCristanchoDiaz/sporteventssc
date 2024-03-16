package com.sporteventssc.sporteventssc.controllers;

import com.sporteventssc.sporteventssc.entities.Event;
import com.sporteventssc.sporteventssc.entities.Sport;
import com.sporteventssc.sporteventssc.response.ResponseHandler;
import com.sporteventssc.sporteventssc.services.EventService;
import com.sporteventssc.sporteventssc.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private SportService sportService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Event> result = eventService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            Event result = eventService.findById(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/{idSport}")
    public ResponseEntity<Object> save(@RequestBody Event event, @PathVariable Integer idSport) {
        try {
            Sport sport = sportService.findById(idSport);
            if (sport != null) {
                Event result = eventService.save(event, sport);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
            }
            return ResponseHandler.generateResponse("Sport Not Found", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
