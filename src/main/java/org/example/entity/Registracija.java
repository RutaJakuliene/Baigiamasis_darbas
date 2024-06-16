package org.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registracija")
public class Registracija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registreacijos_data")
    private LocalDateTime registreacijosData;

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

    public LocalDateTime getRegistreacijosData() {
        return registreacijosData;
    }

    public void setRegistreacijosData(LocalDateTime registreacijosData) {
        this.registreacijosData = registreacijosData;
    }

    public Asmuo getAsmuo() {
        return asmuo;
    }

    public void setAsmuo(Asmuo asmuo) {
        this.asmuo = asmuo;
    }
}
