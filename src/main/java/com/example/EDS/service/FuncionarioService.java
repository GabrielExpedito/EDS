package com.example.EDS.service;

import com.example.EDS.entity.Cargo;
import com.example.EDS.entity.Endereco;
import com.example.EDS.entity.Funcionario;
import com.example.EDS.entity.Terceirizacao;
import com.example.EDS.repository.CargoRepository;
import com.example.EDS.repository.EnderecoRepository;
import com.example.EDS.repository.FuncionarioRepository;
import com.example.EDS.repository.TerceirizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    TerceirizacaoRepository terceirizacaoRepository;


    public Funcionario inserirFuncionario(Funcionario funcionario){
        if (funcionario.getCargo() != null && funcionario.getCargo().getCdCargo() != null) {
            Cargo cargo = cargoRepository.findById(funcionario.getCargo().getCdCargo()).orElseThrow(() -> new RuntimeException("Cargo não encontrado"));
            funcionario.setCargo(cargo);

            if(funcionario.getSalario()==null) {
                funcionario.setSalario(cargo.getSalario());
            }
        }

        if (funcionario.getEndereco() != null && funcionario.getEndereco().getId() != null) {
            Endereco endereco = enderecoRepository.findById(funcionario.getEndereco().getId())
                    .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
            funcionario.setEndereco(endereco);
        }

        if (funcionario.getTerceirizacao() != null && funcionario.getTerceirizacao().getCdTerceirizacao() != null) {
            Terceirizacao terceirizacao = terceirizacaoRepository.findById(funcionario.getTerceirizacao().getCdTerceirizacao())
                    .orElseThrow(() -> new RuntimeException("Terceirização não encontrada"));
            funcionario.setTerceirizacao(terceirizacao);
        }

        return funcionarioRepository.save(funcionario);

    }

    public List<Funcionario> obterFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Funcionario obterFuncionarioByID(Integer id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isEmpty()) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        return funcionario.get();
    }

    public void deletarFuncionario(Integer id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario updateFuncionario(Integer id, Funcionario funcionarioDetalhes) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isPresent()) {
            Funcionario funcionarioExistente = funcionarioOptional.get();

            funcionarioExistente.setNome(funcionarioDetalhes.getNome());
            funcionarioExistente.setCpf(funcionarioDetalhes.getCpf());
            funcionarioExistente.setDtAdmissao(funcionarioDetalhes.getDtAdmissao());
            funcionarioExistente.setCargo(funcionarioDetalhes.getCargo());
            funcionarioExistente.setSalario(funcionarioDetalhes.getSalario());
            funcionarioExistente.setEmail(funcionarioDetalhes.getEmail());
            funcionarioExistente.setEndereco(funcionarioDetalhes.getEndereco());
            funcionarioExistente.setTerceirizacao(funcionarioDetalhes.getTerceirizacao());

            return funcionarioRepository.save(funcionarioExistente);
        } else {
            throw new RuntimeException("Funcionário não encontrado");
        }
    }

}
