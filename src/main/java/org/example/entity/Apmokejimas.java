package org.example.entity;
import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "apmokejimas")
public class Apmokejimas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "suma", precision = 10, scale = 2)
    private BigDecimal suma;
    @Column(name = "mokejimo_budas", length = 45)
    private String mokejimoBudas;
    @ManyToOne
    @JoinColumn(name = "asmuo_id")
    private Asmuo asmuo;
    @ManyToOne
    @JoinColumn(name = "kursai_id")
    private Kursai kursai;
    public Apmokejimas(BigDecimal suma, String mokejimoBudas, int asmuoId, int kursaiId) {
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getSuma() {
        return suma;
    }
    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }
    public String getMokejimoBudas() {
        return mokejimoBudas;
    }
    public void setMokejimoBudas(String mokejimoBudas) {
        this.mokejimoBudas = mokejimoBudas;
    }
    public Asmuo getAsmuo() {
        return asmuo;
    }
    public void setAsmuo(Asmuo asmuo) {
        this.asmuo = asmuo;
    }
    public Kursai getKursai() {
        return kursai;
    }
    public void setKursai(Kursai kursai) {
        this.kursai = kursai;
    }
}

