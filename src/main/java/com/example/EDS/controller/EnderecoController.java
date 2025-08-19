package com.example.EDS.controller;

import com.example.EDS.entity.Endereco;
import com.example.EDS.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/Endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;


    @PostMapping
    public ResponseEntity<String> inserirEndereco(@RequestBody Endereco endereco) {
        try {
            enderecoService.inserirEndereco(endereco);
            return ResponseEntity.status(HttpStatus.CREATED).body("Endereço criado com sucesso");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao criar o endereço");

        }
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getEndereco() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getEndereco());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterEnderecoById(@PathVariable(value = "id") Integer id) {
        try {
            Endereco endereco = enderecoService.getEnderecoById(id);
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado endereço");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEndereco(@PathVariable(value = "id") Integer id) {
        try {
            enderecoService.deleteEndereco(id);
            return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível deletar o endereço");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEndereco(@PathVariable Integer id, @RequestBody Endereco enderecoDetalhes) {

        Endereco updateEndereco = enderecoService.updateEndereco(id, enderecoDetalhes);

        if (updateEndereco != null) {
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("message", "Endereco atualizado com sucesso!");
            successResponse.put("endereco", updateEndereco);
            successResponse.put("status", HttpStatus.OK.value());

            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Endereco com ID " + id + " não encontrado para atualização");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}








