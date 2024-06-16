package org.example.dto;

import java.time.LocalDate;

public class KursaiDto {

    private Long id;
    private String pavadinimas;
    private LocalDate pradziosData;
    private LocalDate pabaigosData;

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

    public LocalDate getPradziosData() {
        return pradziosData;
    }

    public void setPradziosData(LocalDate pradziosData) {
        this.pradziosData = pradziosData;
    }

    public LocalDate getPabaigosData() {
        return pabaigosData;
    }

    public void setPabaigosData(LocalDate pabaigosData) {
        this.pabaigosData = pabaigosData;
    }
}
