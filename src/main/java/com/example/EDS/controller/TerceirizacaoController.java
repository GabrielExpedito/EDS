package com.example.EDS.controller;

import com.example.EDS.entity.Terceirizacao;
import com.example.EDS.service.TerceirizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Terceirizacao")
public class TerceirizacaoController {


    @Autowired
    TerceirizacaoService terceirizacaoService;

    @PostMapping
    public ResponseEntity<String> inserirTerceirizacao(@RequestBody Terceirizacao terceirizacao) {
        try {
            terceirizacaoService.inserirTerceirizacao(terceirizacao);
            return ResponseEntity.status(HttpStatus.CREATED).body("Terceirização criada com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao cria a Terceirização");
        }
    }

    @GetMapping
    public ResponseEntity<List<Terceirizacao>> obterTerceirizacao() {
        return ResponseEntity.status(HttpStatus.FOUND).body(terceirizacaoService.obterTerceirizacao());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterTerceirizacaoById(@PathVariable(value = "id") Integer id) {
        try {
            Terceirizacao terceirizacao = terceirizacaoService.obterTerceirizacaoByID(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(terceirizacao);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado a terceirizacao");
        }

    }


}
