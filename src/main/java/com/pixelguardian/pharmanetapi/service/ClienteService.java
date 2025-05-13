package com.pixelguardian.pharmanetapi.service;

import com.pixelguardian.pharmanetapi.model.entity.Cliente;
import com.pixelguardian.pharmanetapi.model.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;

    private ClienteService(ClienteRepository repository){this.repository = repository;}

    public List<Cliente> getClientes(){return repository.findAll();}

    public Optional<Cliente> getClientebyId(Long id){return repository.findById(id);}

    @Transactional
    public Cliente salvar(Cliente cliente){
        validar(cliente);
        return repository.save(cliente);
    }

    @Transactional
    public void excluir(Cliente cliente){
        Objects.requireNonNull(cliente.getId());
        repository.delete(cliente);
    }
    public void validar(Cliente cliente){
        if(cliente.getFidelidadePontos() == null || cliente.getFidelidadePontos() == 0){
//            TODO: Fazer Exception e reavaliar método
//            throw new RegraNegocioException("Pontos de fidalidade inválidos");
        }
    }
}
