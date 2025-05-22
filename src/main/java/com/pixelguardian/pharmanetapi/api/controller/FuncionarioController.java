package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.FuncionarioDTO;
import com.pixelguardian.pharmanetapi.model.entity.Cargo;
import com.pixelguardian.pharmanetapi.model.entity.Endereco;
import com.pixelguardian.pharmanetapi.model.entity.Funcionario;
import com.pixelguardian.pharmanetapi.model.entity.Farmacia;
import com.pixelguardian.pharmanetapi.service.CargoService;
import com.pixelguardian.pharmanetapi.service.EnderecoService;
import com.pixelguardian.pharmanetapi.service.FarmaciaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class FuncionarioController {
    
    private EnderecoService enderecoService;
    private CargoService cargoService;
    private FarmaciaService farmaciaService;

    public Funcionario converter(FuncionarioDTO dto){

        ModelMapper modelMapper = new ModelMapper();
        
        Funcionario funcionario = modelMapper.map(dto, Funcionario.class);

        if (dto.getIdEndereco() != null) {
            Optional<Endereco> endereco = enderecoService.getEnderecoById((dto.getIdEndereco()));
            if (endereco.isPresent()) {
                funcionario.setEndereco(endereco.get());
            } else {
                funcionario.setEndereco(null);
            }
        }

        if (dto.getIdCargo() != null) {

            Optional<Cargo> cargo = cargoService.getCargoById(dto.getIdCargo());
            if (cargo.isPresent()) {
                funcionario.setCargo(cargo.get());
            } else {
                funcionario.setCargo(null);
            }
        }

        if (dto.getIdFarmacia() != null){
            Optional<Farmacia> farmacia = farmaciaService.getFarmaciaById(dto.getIdFarmacia());
            if (farmacia.isPresent()){
                funcionario.setFarmacia(farmacia.get());
            } else{
                funcionario.setCargo(null);
            }
        }
        
        return funcionario;

    }


}
