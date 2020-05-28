package com.qa.cineverse.controller;

import com.qa.cineverse.domain.Customers;
import com.qa.cineverse.domain.Screenings;
import com.qa.cineverse.dto.CustomersDTO;
import com.qa.cineverse.dto.ScreeningsDTO;
import com.qa.cineverse.service.ScreeningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ScreeningsController {

    private final ScreeningsService service;

    @Autowired
    public ScreeningsController(ScreeningsService service) {
        this.service = service;
    }

    @GetMapping("/getAllScreenings")
    public ResponseEntity<List<ScreeningsDTO>> getAllScreenings(){
        return ResponseEntity.ok(this.service.readScreenings ());
    }

    @PostMapping("/createScreening")
    public ResponseEntity<ScreeningsDTO> createScreening(@RequestBody Screenings screenings){
        return new ResponseEntity<>(this.service.createScreening (screenings), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteScreening/{id}")
    public ResponseEntity<?> deleteScreening(@PathVariable Long id){
        return this.service.deleteScreening (id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getScreeningById/{id}")
    public ResponseEntity<ScreeningsDTO> getScreeningById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findScreeningsById (id));
    }

    @PutMapping("/updateScreening/{id}")
    public ResponseEntity<ScreeningsDTO> updateScreening(@PathVariable Long id, @RequestBody Screenings screening){
        return ResponseEntity.ok(this.service.updateScreening (id, screening));
    }

    @PatchMapping("/addCustomerToScreening/{id}")
    public ResponseEntity<ScreeningsDTO> addCustomerToScreening(@PathVariable Long id, @RequestBody Customers customer){
        return new ResponseEntity<>(this.service.addCustomerToScreening (id, customer), HttpStatus.ACCEPTED);
    }
}
