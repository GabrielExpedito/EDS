package com.example.EDS.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID gerado automaticamente
    @Column(name = "cdcargo", unique = true, nullable = false)
    private Integer cdCargo;

    @JsonProperty("nmCargo")
    @Column(name = "nmcargo", nullable = false, length = 100)
    private String nmCargo;

    @JsonProperty("dtCriacao")
    @Column(name = "dt_Criacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // Garante o tipo correto
    private Date dtCriacao;

    @Column(name = "salario", nullable = false, precision = 13, scale = 2)
    private BigDecimal salario;
}
