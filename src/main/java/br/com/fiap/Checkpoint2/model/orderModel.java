package br.com.fiap.Checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class orderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Preenchimento do nome é obrigatório!")
    private String clientName;
    private LocalDate orderDate;

    @DecimalMin(value = "0.0", message = "Valor não pode ser negativo")
    @Positive
    private BigDecimal totalValue;

    @PrePersist
    public void prePersist(){
        if(orderDate == null){
            orderDate = LocalDate.now();
        }
    }
}
