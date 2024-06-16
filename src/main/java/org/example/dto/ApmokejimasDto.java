package org.example.dto;
import java.math.BigDecimal;
public class ApmokejimasDto {
    private Long id;
    private BigDecimal suma;
    private String mokejimoBudas;
    private Long asmuoId;
    private Long kursaiId;
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
    public Long getAsmuoId() {
        return asmuoId;
    }
    public void setAsmuoId(Long asmuoId) {
        this.asmuoId = asmuoId;
    }
    public Long getKursaiId() {
        return kursaiId;
    }
    public void setKursaiId(Long kursaiId) {
        this.kursaiId = kursaiId;
    }
    public BigDecimal getData() {
        return null;
    }
}
