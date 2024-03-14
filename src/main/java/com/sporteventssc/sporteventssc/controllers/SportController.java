package com.sporteventssc.sporteventssc.controllers;

import com.sporteventssc.sporteventssc.entities.Sport;
import com.sporteventssc.sporteventssc.response.ResponseHandler;
import com.sporteventssc.sporteventssc.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Sport> result = sportService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            Sport result = sportService.findById(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Sport sport) {
        try {
            Sport result = sportService.save(sport);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
