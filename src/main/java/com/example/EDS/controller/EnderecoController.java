package com.example.EDS.controller;

import com.example.EDS.entity.Endereco;
import com.example.EDS.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/Endereco/")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;



    @PostMapping
    public ResponseEntity<String> inserirEndereco(@RequestBody  Endereco endereco) {
        try {
            enderecoService.inserirEndereco(endereco);
            return ResponseEntity.status(HttpStatus.CREATED).body("Endereço criado com sucesso");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao criar o endereço");

        }
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getEndereco() {
        return ResponseEntity.status(HttpStatus.FOUND).body(enderecoService.getEndereco());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterEnderecoById(@PathVariable (value = "id") Integer id) {
        try {
            Endereco endereco = enderecoService.getEnderecoById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(endereco);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado endereço");
        }
    }





}
