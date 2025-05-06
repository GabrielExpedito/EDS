package com.example.EDS.service;

import com.example.EDS.entity.Cargo;
import com.example.EDS.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {


    @Autowired
    CargoRepository cargoRepository;


    public void inserirCargo(Cargo cargo) throws Exception {
        cargoRepository.save(cargo);
    }


}
