package com.br.Space_Exploration.infra.adapters.input.controllers;

import com.br.Space_Exploration.App.ports.input.SpacecraftService;
import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.infra.adapters.input.mapper.SpacecraftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/spacecraft")
public class SpacecraftController {

    private SpacecraftService service;

    public SpacecraftController(SpacecraftService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createSpacecraft(@RequestBody SpacecraftRegisterDto registerDto){
        try{
            return ResponseEntity.status(201).body(service.createSpacecraft(registerDto));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpacecraftResponseDto> updateSpacecraft(@PathVariable int id, @RequestBody SpacecraftRegisterDto registerDto) {
        try {
            SpacecraftResponseDto updatedSpacecraft = service.updateSpacecraft(id, registerDto);
            return ResponseEntity.ok(updatedSpacecraft);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
}
