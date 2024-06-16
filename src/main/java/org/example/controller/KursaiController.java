package org.example.controller;

import org.example.dto.KursaiDto;
import org.example.service.KursaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kursai")
public class KursaiController {

    private final KursaiService kursaiService;

    @Autowired
    public KursaiController(KursaiService kursaiService) {
        this.kursaiService = kursaiService;
    }

    @GetMapping
    public ResponseEntity<List<KursaiDto>> gautiVisusKursus() {
        List<KursaiDto> kursai = kursaiService.gautiVisusKursus();
        return ResponseEntity.ok(kursai);
    }

    @PostMapping
    public ResponseEntity<KursaiDto> sukurtiKursa(@RequestBody KursaiDto kursaiDto) {
        KursaiDto naujasKursas = kursaiService.sukurtiKursa(kursaiDto);
        return new ResponseEntity<>(naujasKursas, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KursaiDto> gautiKursaPagalId(@PathVariable Long id) {
        KursaiDto kursas = kursaiService.gautiKursaPagalId(id);
        return ResponseEntity.ok(kursas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KursaiDto> atnaujintiKursa(@PathVariable Long id, @RequestBody KursaiDto kursaiDto) {
        KursaiDto atnaujintasKursas = kursaiService.atnaujintiKursa(id, kursaiDto);
        return ResponseEntity.ok(atnaujintasKursas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> istrintiKursa(@PathVariable Long id) {
        kursaiService.istrintiKursa(id);
        return ResponseEntity.noContent().build();
    }
}
