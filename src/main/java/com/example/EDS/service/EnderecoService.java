package com.example.EDS.service;

import com.example.EDS.entity.Endereco;
import com.example.EDS.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {


    @Autowired
    EnderecoRepository enderecoRepository;


    public void inserirEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public List<Endereco> getEndereco() {
        return enderecoRepository.findAll();
    }

    public Object getEnderecoById(Integer id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isEmpty()) {
            throw new RuntimeException("Endereco não encontrado");
        }
        return endereco.get();
    }


}
