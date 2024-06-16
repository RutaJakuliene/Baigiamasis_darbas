package org.example.dto;

import java.time.LocalDateTime;

public class RegistracijaDto {

    private Long id;
    private LocalDateTime registracijosData;
    private Long asmuoId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRegistracijosData() {
        return registracijosData;
    }

    public void setRegistracijosData(LocalDateTime registracijosData) {
        this.registracijosData = registracijosData;
    }

    public Long getAsmuoId() {
        return asmuoId;
    }

    public void setAsmuoId(Long asmuoId) {
        this.asmuoId = asmuoId;
    }
}
