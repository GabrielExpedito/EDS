package com.example.EDS.controller;


import com.example.EDS.entity.Cargo;
import com.example.EDS.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao inserir o Cargo");

       }


    }




}
