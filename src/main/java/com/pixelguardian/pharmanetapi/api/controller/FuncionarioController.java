package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.FarmaciaDTO;
import com.pixelguardian.pharmanetapi.api.dto.FuncionarioDTO;
import com.pixelguardian.pharmanetapi.model.entity.Cargo;
import com.pixelguardian.pharmanetapi.model.entity.Endereco;
import com.pixelguardian.pharmanetapi.model.entity.Funcionario;
import com.pixelguardian.pharmanetapi.model.entity.Farmacia;
import com.pixelguardian.pharmanetapi.service.CargoService;
import com.pixelguardian.pharmanetapi.service.EnderecoService;
import com.pixelguardian.pharmanetapi.service.FarmaciaService;
import com.pixelguardian.pharmanetapi.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/funcionarios")
@RequiredArgsConstructor
@CrossOrigin
public class FuncionarioController {

    private final FuncionarioService service;
    private final EnderecoService enderecoService;
    private final CargoService cargoService;
    private final FarmaciaService farmaciaService;

    @GetMapping()
    public ResponseEntity get() {
        List<Funcionario> funcionarios = service.getFuncionarios();
        return ResponseEntity.ok(funcionarios.stream().map(FuncionarioDTO::create).collect(Collectors.toList()));
    }

    public Funcionario converter(FuncionarioDTO dto) {
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
        if (dto.getIdFarmacia() != null) {
            Optional<Farmacia> farmacia = farmaciaService.getFarmaciaById(dto.getIdFarmacia());
            if (farmacia.isPresent()) {
                funcionario.setFarmacia(farmacia.get());
            } else {
                funcionario.setCargo(null);
            }
        }
        return funcionario;
    }
}
