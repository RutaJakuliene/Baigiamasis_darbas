package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kursai")
public class Kursai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pavadinimas", length = 100)
    private String pavadinimas;

    @Column(name = "pradzios_data")
    private LocalDate pradziosData;

    @Column(name = "pabaigos_data")
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
