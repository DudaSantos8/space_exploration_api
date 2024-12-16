package com.br.Space_Exploration.infra.adapters.input.controllers;

import com.br.Space_Exploration.App.ports.input.SpacecraftService;
import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/spacecraft")
public class SpacecraftController {

    private SpacecraftService service;

    public SpacecraftController(SpacecraftService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpacecraftStatus(@PathVariable int id){
        try{
            return ResponseEntity.status(201).body(service.getSpacecraftStatus(id));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> createSpacecraft(@RequestBody @Valid SpacecraftRegisterDto registerDto){
        try{
            return ResponseEntity.status(201).body(service.createSpacecraft(registerDto));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateSpacecraft(@PathVariable int id, @RequestBody SpacecraftRegisterDto registerDto) {
        try {
            SpacecraftResponseDto updatedSpacecraft = service.updateSpacecraft(id, registerDto);
            return ResponseEntity.ok(updatedSpacecraft);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpacecraft(@PathVariable int id) {
        try {
            service.deleteSpacecraft(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping("/{idShip}/{namePlanet}/travel")
    public ResponseEntity<?> doingTravel(@PathVariable int idShip, @PathVariable String namePlanet){
        try {
            SpacecraftResponseDto responseDto = service.getSpacecraftStatus(idShip);
            return ResponseEntity.status(200).body(service.doTravel(namePlanet, responseDto));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping("/{idShip}/planet")
    public ResponseEntity<?> getPlanetInformation(@PathVariable int idShip){
        try {
            SpacecraftResponseDto responseDto = service.getSpacecraftStatus(idShip);
            return ResponseEntity.status(200).body(service.planetInformation(responseDto));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
}
