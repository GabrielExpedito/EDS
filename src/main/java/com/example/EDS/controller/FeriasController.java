package com.example.EDS.controller;

import com.example.EDS.entity.Ferias;
import com.example.EDS.service.FeriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ferias")
public class FeriasController {


    @Autowired
    FeriasService feriasService;

    public FeriasController(FeriasService feriasService) {
        this.feriasService = feriasService;
    }

    @GetMapping("/futuras")
    public List<Ferias> listarFeriasFuturas() {
        return feriasService.listarFeriasFuturas();
    }

    @GetMapping("/periodo")
    public List<Ferias> listarFeriasPorPeriodo(@RequestParam String inicio, @RequestParam String fim) {
        return feriasService.listarFeriasNoPeriodo(LocalDate.parse(inicio), LocalDate.parse(fim));
    }

    @GetMapping("/funcionario/{nre}")
    public List<Ferias> listarFeriasFuncionario(@PathVariable Integer nre) {
        return feriasService.listarFeriasFuncionario(nre);
    }


}
