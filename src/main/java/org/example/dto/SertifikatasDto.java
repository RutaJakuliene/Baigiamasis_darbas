package org.example.dto;

import java.time.LocalDate;

public class SertifikatasDto {

    private Long id;
    private String pavadinimas;
    private LocalDate sertifikavimoData;
    private LocalDate galiojimoData;
    private Long asmuoId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public LocalDate getSertifikavimoData() {
        return sertifikavimoData;
    }

    public void setSertifikavimoData(LocalDate sertifikavimoData) {
        this.sertifikavimoData = sertifikavimoData;
    }

    public LocalDate getGaliojimoData() {
        return galiojimoData;
    }

    public void setGaliojimoData(LocalDate galiojimoData) {
        this.galiojimoData = galiojimoData;
    }

    public Long getAsmuoId() {
        return asmuoId;
    }

    public void setAsmuoId(Long asmuoId) {
        this.asmuoId = asmuoId;
    }
}
