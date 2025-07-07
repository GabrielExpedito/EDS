package com.example.EDS.service;

import com.example.EDS.entity.Cargo;
import com.example.EDS.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {


    @Autowired
    CargoRepository cargoRepository;


    public void inserirCargo(Cargo cargo) throws Exception {
        cargoRepository.save(cargo);
    }

    public List<Cargo> obterCargos() {
        return  cargoRepository.findAll();
    }

    public Cargo obterCargosByID(Integer ID) {
        Optional<Cargo> cargo = cargoRepository.findById(ID);
        if (cargo.isEmpty()) {
            throw new RuntimeException("Não encontrado");
        }
        return cargo.get();
    }

    public void deletarCargo(Integer ID) {
        cargoRepository.deleteById(ID);
    }


}
