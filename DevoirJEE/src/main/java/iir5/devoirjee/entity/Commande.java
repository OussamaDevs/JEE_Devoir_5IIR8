package iir5.devoirjee.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private Double montant;

    public String getDescription() {
        return description;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public LocalDate getDate() {
        return date;
    }
    public Double getMontant() {
        return montant;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }
    

}
