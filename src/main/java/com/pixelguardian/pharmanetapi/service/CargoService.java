package com.pixelguardian.pharmanetapi.service;

import com.pixelguardian.pharmanetapi.model.entity.Cargo;
import com.pixelguardian.pharmanetapi.model.entity.Funcionario;
import com.pixelguardian.pharmanetapi.model.repository.CargoRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CargoService {

    private CargoRepository repository;

    public CargoService(CargoRepository repository){
        this.repository = repository;
    }

    public List<Cargo> getCargos(){
        return repository.findAll();
    }

    public Optional<Cargo> getCargoById(Long id){
        return repository.findById(id);
    }

//    TODO: Buscar cargo por funcionário
//    public List<Cargo> getCargoByFuncionario(Optional<Funcionario>funcionario){
//        return repository.findByFuncionario(funcionario);
//    }
//}

    @Transactional
    public Cargo salvar(Cargo cargo){
        validar(cargo);
        return repository.save((cargo);
    }

    @Transactional
    public void excluir(Cargo cargo){
        Objects.requireNonNull(cargo.getId());
        repository.delete(cargo);
    }
    public void validar(Cargo cargo){
        if(cargo.getNome() == null || cargo.getNome().trim().equals("")){
//            TODO: Fazer Exception
//            throw new RegraNegocioException("Nome inválido");
        }
    }
}

