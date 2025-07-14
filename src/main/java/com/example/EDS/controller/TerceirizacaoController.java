package com.example.EDS.controller;

import com.example.EDS.entity.Terceirizacao;
import com.example.EDS.service.TerceirizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Terceirizacao")
public class TerceirizacaoController {


    @Autowired
    TerceirizacaoService terceirizacaoService;

    /*PRECISO TESTAR ESSE MÉTODO AINDA*/
    @PostMapping
    public ResponseEntity<String> inserirTerceirizacao(@RequestBody Terceirizacao terceirizacao) {
        try {
            terceirizacaoService.inserirTerceirizacao(terceirizacao);
            return ResponseEntity.status(HttpStatus.CREATED).body("Terceirização criada com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao cria a Terceirização");
        }
    }


}
