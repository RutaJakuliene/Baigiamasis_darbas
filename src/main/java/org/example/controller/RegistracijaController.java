package org.example.controller;

import org.example.dto.RegistracijaDto;
import org.example.service.RegistracijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registracija")
public class RegistracijaController {

    private final RegistracijaService registracijaService;

    @Autowired
    public RegistracijaController(RegistracijaService registracijaService) {
        this.registracijaService = registracijaService;
    }

    @GetMapping
    public ResponseEntity<List<RegistracijaDto>> gautiVisasRegistracijas() {
        List<RegistracijaDto> registracijos = registracijaService.gautiVisasRegistracijas();
        return ResponseEntity.ok(registracijos);
    }

    @PostMapping
    public ResponseEntity<RegistracijaDto> sukurtiRegistracija(@RequestBody RegistracijaDto registracijaDto) {
        RegistracijaDto naujaRegistracija = registracijaService.sukurtiRegistracija(registracijaDto);
        return new ResponseEntity<>(naujaRegistracija, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistracijaDto> gautiRegistracijaPagalId(@PathVariable Long id) {
        RegistracijaDto registracija = registracijaService.gautiRegistracijaPagalId(id);
        return ResponseEntity.ok(registracija);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistracijaDto> atnaujintiRegistracija(@PathVariable Long id, @RequestBody RegistracijaDto registracijaDto) {
        RegistracijaDto atnaujintaRegistracija = registracijaService.atnaujintiRegistracija(id, registracijaDto);
        return ResponseEntity.ok(atnaujintaRegistracija);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> istrintiRegistracija(@PathVariable Long id) {
        registracijaService.istrintiRegistracija(id);
        return ResponseEntity.noContent().build();
    }
}
