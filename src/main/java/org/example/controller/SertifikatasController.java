package org.example.controller;

import org.example.dto.SertifikatasDto;
import org.example.service.SertifikatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sertifikatai")
public class SertifikatasController {

    private final SertifikatasService sertifikatasService;

    @Autowired
    public SertifikatasController(SertifikatasService sertifikatasService) {
        this.sertifikatasService = sertifikatasService;
    }

    @GetMapping
    public ResponseEntity<List<SertifikatasDto>> gautiVisusSertifikatus() {
        List<SertifikatasDto> sertifikatai = sertifikatasService.gautiVisusSertifikatus();
        return ResponseEntity.ok(sertifikatai);
    }

    @PostMapping
    public ResponseEntity<SertifikatasDto> sukurtiSertifikata(@RequestBody SertifikatasDto sertifikatasDto) {
        SertifikatasDto naujasSertifikatas = sertifikatasService.sukurtiSertifikata(sertifikatasDto);
        return new ResponseEntity<>(naujasSertifikatas, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SertifikatasDto> gautiSertifikataPagalId(@PathVariable Long id) {
        SertifikatasDto sertifikatas = sertifikatasService.gautiSertifikataPagalId(id);
        return ResponseEntity.ok(sertifikatas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SertifikatasDto> atnaujintiSertifikata(@PathVariable Long id, @RequestBody SertifikatasDto sertifikatasDto) {
        SertifikatasDto atnaujintasSertifikatas = sertifikatasService.atnaujintiSertifikata(id, sertifikatasDto);
        return ResponseEntity.ok(atnaujintasSertifikatas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> istrintiSertifikata(@PathVariable Long id) {
        sertifikatasService.istrintiSertifikata(id);
        return ResponseEntity.noContent().build();
    }
}
