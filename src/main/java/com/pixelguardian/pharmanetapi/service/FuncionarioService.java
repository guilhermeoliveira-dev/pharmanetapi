package com.pixelguardian.pharmanetapi.service;

import com.pixelguardian.pharmanetapi.model.entity.Funcionario;
import com.pixelguardian.pharmanetapi.model.repository.FuncionarioRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Funcionario salvar(Funcionario funcionario){
        validar(funcionario);
        return repository.save(funcionario);
    }

    @Transactional
    public void excluir(Funcionario funcionario){
        Objects.requireNonNull(funcionario.getId());
        repository.delete(funcionario);
    }
    public void validar(Funcionario funcionario){
        if(funcionario.getSalario() == null || funcionario.getSalario() == 0){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Salário inválido");
        }
        if(funcionario.getExpediente() == null || funcionario.getExpediente().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Expediente inválido");
        }
        if(funcionario.getCargo() == null || funcionario.getCargo().getId() == null){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Cargo inválido");
        }
        if(funcionario.getFarmacia() == null || funcionario.getFarmacia().getId() == null){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Farmácia inválida");
        }
    }
}
