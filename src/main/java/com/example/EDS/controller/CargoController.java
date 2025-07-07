package com.example.EDS.controller;


import com.example.EDS.entity.Cargo;
import com.example.EDS.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cargo")
public class CargoController {

    @Autowired
    CargoService cargoService;

    @PostMapping
    public ResponseEntity<String> inserirCargo(@RequestBody Cargo cargo) {
        try {
            cargoService.inserirCargo(cargo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cargo inserido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao inserir o Cargo");

        }
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> obterCargos() {
        return ResponseEntity.status(HttpStatus.FOUND).body(cargoService.obterCargos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterCargosById(@PathVariable(value = "id") Integer ID) {
        try {
            Cargo cargo = cargoService.obterCargosByID(ID);
            return ResponseEntity.status(HttpStatus.FOUND).body(cargo);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
        }

    }
}
