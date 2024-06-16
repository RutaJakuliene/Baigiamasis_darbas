package org.example.controller;
import org.example.dto.ApmokejimasDto;
import org.example.service.ApmokejimasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/apmokejimai")
public class ApmokejimasController {
    @Autowired
    private ApmokejimasService apmokejimasService;
    @PostMapping
    public ResponseEntity<ApmokejimasDto> createApmokejimas(@RequestBody ApmokejimasDto apmokejimasDto) {
        return ResponseEntity.ok(apmokejimasService.createApmokejimas(apmokejimasDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApmokejimasDto> updateApmokejimas(@PathVariable Long id, @RequestBody ApmokejimasDto apmokejimasDto) {
        return ResponseEntity.ok(apmokejimasService.updateApmokejimas(id, apmokejimasDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApmokejimas(@PathVariable Long id) {
        apmokejimasService.deleteApmokejimas(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApmokejimasDto> getApmokejimasById(@PathVariable Long id) {
        return ResponseEntity.ok(apmokejimasService.getApmokejimasById(id));
    }
    @GetMapping
    public ResponseEntity<List<ApmokejimasDto>> getAllApmokejimai() {
        return ResponseEntity.ok(apmokejimasService.getAllApmokejimas());
    }
}
