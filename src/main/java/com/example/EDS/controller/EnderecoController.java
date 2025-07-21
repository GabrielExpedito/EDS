package com.example.EDS.controller;

import com.example.EDS.entity.Endereco;
import com.example.EDS.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/Endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;


    /*PRECISO TESTAR AINDA ESSE MÉTODO*/
    @PostMapping
    public ResponseEntity<String> inserirEndereco(@RequestBody  Endereco endereco) {
        try {
            enderecoService.inserirEndereco(endereco);
            return ResponseEntity.status(HttpStatus.CREATED).body("Endereço criado com sucesso");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao criar o endereço");

        }


    }


}
