package com.example.EDS.controller;

import com.example.EDS.entity.Funcionario;
import com.example.EDS.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios/")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<?> inserirFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novo = funcionarioService.inserirFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Inserido com sucesso");
    }

    @GetMapping
    public List<Funcionario> getFuncionarios() {
        return funcionarioService.obterFuncionario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFuncionarioById(@PathVariable Integer id) {
        try {
            Funcionario funcionario = funcionarioService.obterFuncionarioByID(id);
            return ResponseEntity.ok(funcionario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFuncionario(@PathVariable Integer id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.ok("Funcionário deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
        try {
            Funcionario atualizado = funcionarioService.updateFuncionario(id, funcionario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
