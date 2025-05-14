package com.pixelguardian.pharmanetapi.service;

import com.pixelguardian.pharmanetapi.model.entity.Fornecedor;
import com.pixelguardian.pharmanetapi.model.repository.FornecedorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FornecedorService {

    private FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository){
        this.repository = repository;
    }

    public List<Fornecedor> getFornecedores(){
        return repository.findAll();
    }

    public Optional<Fornecedor> getFornecedorById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Fornecedor salvar(Fornecedor fornecedor){
        validar(fornecedor);
        return repository.save(fornecedor);
    }

    @Transactional
    public void excluir(Fornecedor fornecedor){
        Objects.requireNonNull(fornecedor.getId());
        repository.delete(fornecedor);
    }
    public void validar(Fornecedor fornecedor){
        if(fornecedor.getNome() == null || fornecedor.getNome().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Nome inválido");
        }
        if(fornecedor.getCnpj() == null || fornecedor.getCnpj().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("CNPJ inválido");
        }
        if(fornecedor.getEmail() == null || fornecedor.getEmail().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("E-mail inválido");
        }
        if(fornecedor.getTelefone() == null || fornecedor.getTelefone().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Telefone inválido");
        }
        if(fornecedor.getEndereco() == null || fornecedor.getEndereco().getId() == null){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Fonecedor inválido");
        }
    }
}
