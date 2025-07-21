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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true)
    private Integer id;

    @JsonProperty("rua")
    @Column(name = "rua", nullable = false, length = 100)
    private String rua;

    @JsonProperty("cep")
    @Column(name = "cep", nullable = false, length = 100)
    private String cep;

    @JsonProperty("bairro")
    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    @JsonProperty("nr")
    @Column(name = "nr", nullable = false, length = 100)
    private Integer nr;

}
