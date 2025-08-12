package com.example.EDS.controller;


import com.example.EDS.entity.Cargo;
import com.example.EDS.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.obterCargos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterCargosById(@PathVariable(value = "id") Integer ID) {
        try {
            Cargo cargo = cargoService.obterCargosByID(ID);
            return ResponseEntity.status(HttpStatus.OK).body(cargo);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCargo(@PathVariable(value = "id") Integer ID) {
        try {
            cargoService.deletarCargo(ID);
            return ResponseEntity.status(HttpStatus.OK).body("Cargo deletado com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar o cargo");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCargo(@PathVariable Integer id, @RequestBody Cargo cargoDetails) {
        if (cargoDetails.getCdCargo() != null && !cargoDetails.getCdCargo().equals(id)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "O ID no corpo da requisição não coincide com o ID da URL.");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        Cargo updateCargo = cargoService.updateCargo(id, cargoDetails);

        if (updateCargo != null) {

            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("message", "Cargo atualizado com sucesso!");
            successResponse.put("cargo", updateCargo);
            successResponse.put("status", HttpStatus.OK.value());

            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Cargo com ID " + id + " não encontrado para atualização.");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
