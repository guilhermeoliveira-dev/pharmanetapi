package com.pixelguardian.pharmanetapi.service;

import com.pixelguardian.pharmanetapi.model.entity.Estoque;
import com.pixelguardian.pharmanetapi.model.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EstoqueService {

    private EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository){
        this.repository = repository;
    }

    public List<Estoque> getEstoques(){
        return repository.findAll();
    }

    public Optional<Estoque> getEstoqueById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Estoque salvar(Estoque estoque){
        validar(estoque);
        return repository.save(estoque);
    }

    @Transactional
    public void excluir(Estoque estoque){
        Objects.requireNonNull(estoque.getId());
        repository.delete(estoque);
    }
    public void validar(Estoque estoque){
        if(estoque.getQuantidade() == null || estoque.getQuantidade() == 0){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Quantidade inválida");
        }
        if(estoque.getProduto() == null || estoque.getProduto().getId() == null){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Produto inválida");
        }
        if(estoque.getFornecedor() == null || estoque.getFornecedor().getId() == null){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Fornecedor inválida");
        }
        if(estoque.getFarmacia() == null || estoque.getFarmacia().getId() == null){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Farmacia inválida");
        }
    }
}
