package com.example.EDS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nre", unique = true)
    private Integer nre;

    private String nome;
    private String CPF;
    private LocalDate Dt_admissao;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private Cargo cargo;

    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal salario;

    private String email;

    @ManyToOne
    @JoinColumn(name = "id_end")
    private Endereco endereco;

    private String flTerceiro;

    @ManyToOne
    @JoinColumn(name = "CdTerceirizacao", nullable = false)
    private Terceirizacao terceirizacao;

}
