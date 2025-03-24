package com.example.EDS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Terceirizacao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "CdTerceirizacao", unique = true)
    private Integer CdTerceirizacao;
    private String NmEmpresa;
    private Double NmContrato;


}
