package org.example.controller;

import org.example.dto.AsmuoDto;
import org.example.service.AsmuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asmuo")
public class AsmuoController {

    private final AsmuoService asmuoService;

    @Autowired
    public AsmuoController(AsmuoService asmuoService) {
        this.asmuoService = asmuoService;
    }

    @GetMapping
    public List<AsmuoDto> gautiVisusAsmenis() {
        return asmuoService.gautiVisusAsmenis();
    }

    @GetMapping("/{id}")
    public AsmuoDto gautiAsmeniPagalId(@PathVariable Long id) {
        return asmuoService.gautiAsmeniPagalId(id);
    }

    @PostMapping
    public AsmuoDto sukurtiAsmeni(@RequestBody AsmuoDto asmuoDto) {
        return asmuoService.sukurtiAsmeni(asmuoDto);
    }

    @PutMapping("/{id}")
    public AsmuoDto atnaujintiAsmeni(@PathVariable Long id, @RequestBody AsmuoDto asmuoDto) {
        return asmuoService.atnaujintiAsmeni(id, asmuoDto);
    }

    @DeleteMapping("/{id}")
    public void istrintiAsmeni(@PathVariable Long id) {
        asmuoService.istrintiAsmeni(id);
    }
}
