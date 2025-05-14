package com.pixelguardian.pharmanetapi.service;

import com.pixelguardian.pharmanetapi.model.entity.Farmacia;
import com.pixelguardian.pharmanetapi.model.repository.FarmaciaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FarmaciaService {

    private FarmaciaRepository repository;

    public FarmaciaService(FarmaciaRepository repository){
        this.repository = repository;
    }

    public List<Farmacia> getFarmacias(){
        return repository.findAll();
    }

    public Optional<Farmacia> getFarmaciaById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Farmacia salvar(Farmacia farmacia){
        validar(farmacia);
        return repository.save(farmacia);
    }

    @Transactional
    public void excluir(Farmacia farmacia){
        Objects.requireNonNull(farmacia.getId());
        repository.delete(farmacia);
    }
    public void validar(Farmacia farmacia){
        if(farmacia.getCnpj() == null || farmacia.getCnpj().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("CNPJ inválido");
        }
        if(farmacia.getNome() == null || farmacia.getNome().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Nome inválido");
        }
        if(farmacia.getEmail() == null || farmacia.getEmail().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("E-mail inválido");
        }
        if(farmacia.getTelefone() == null || farmacia.getTelefone().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Telefone inválido");
        }
    }
}
