package com.example.EDS.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("cdTerceirizacao")
    @Column (name = "cdterceirizacao", unique = true)
    private Integer cdTerceirizacao;

    @JsonProperty("nmEmpresa")
    @Column(name = "nmempresa", nullable = false, length = 100)
    private String nmEmpresa;

    @JsonProperty("nmContrato")
    @Column(name = "nmcontrato", nullable = false, length = 100)
    private Double nmContrato;


}
