package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.FarmaciaDTO;
import com.pixelguardian.pharmanetapi.model.entity.Endereco;
import com.pixelguardian.pharmanetapi.model.entity.Farmacia;
import com.pixelguardian.pharmanetapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class FarmaciaController {

    private final EnderecoService enderecoService;

    public Farmacia converter(FarmaciaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Farmacia farmacia = modelMapper.map(dto, Farmacia.class);
        if (dto.getIdEndereco() != null) {
            Optional<Endereco> endereco = enderecoService.getEnderecoById((dto.getIdEndereco()));
            if (endereco.isPresent()) {
                farmacia.setEndereco(endereco.get());
            } else {
                farmacia.setEndereco(null);
            }
        }
        return farmacia;
    }
}
