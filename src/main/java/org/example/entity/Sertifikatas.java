package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sertifikatas")
public class Sertifikatas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pavadinimas", length = 100)
    private String pavadinimas;

    @Column(name = "sertifikavimo_data")
    private LocalDate sertifikavimoData;

    @Column(name = "galiojimo_data")
    private LocalDate galiojimoData;

    @ManyToOne
    @JoinColumn(name = "asmuo_id")
    private Asmuo asmuo;

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

    public Asmuo getAsmuo() {
        return asmuo;
    }

    public void setAsmuo(Asmuo asmuo) {
        this.asmuo = asmuo;
    }
}
