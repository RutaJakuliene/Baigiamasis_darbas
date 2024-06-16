package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asmuo")
public class Asmuo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vardas", length = 50)
    private String vardas;

    @Column(name = "pavarde", length = 50)
    private String pavarde;

    @Column(name = "gimimo_data")
    private LocalDate gimimoData;

    @Column(name = "adresas", length = 255)
    private String adresas;

    @Column(name = "el_pastas", length = 100)
    private String elPastas;

    @Column(name = "telefonas", length = 20)
    private String telefonas;

    public Asmuo(String vardas, String pavarde, LocalDate gimimoData, String adresas, String elPastas, String telefonas) {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public LocalDate getGimimoData() {
        return gimimoData;
    }

    public void setGimimoData(LocalDate gimimoData) {
        this.gimimoData = gimimoData;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public String getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(String telefonas) {
        this.telefonas = telefonas;
    }
}
