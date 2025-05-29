package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.FarmaciaDTO;
import com.pixelguardian.pharmanetapi.model.entity.Endereco;
import com.pixelguardian.pharmanetapi.model.entity.Farmacia;
import com.pixelguardian.pharmanetapi.service.EnderecoService;
import com.pixelguardian.pharmanetapi.service.FarmaciaService;
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
@RequestMapping("/api/v1/farmacias")
@RequiredArgsConstructor
@CrossOrigin
public class FarmaciaController {

    private final FarmaciaService service;
    private final EnderecoService enderecoService;

    @GetMapping()
    public ResponseEntity get() {
        List<Farmacia> farmacias = service.getFarmacias();
        return ResponseEntity.ok(farmacias.stream().map(FarmaciaDTO::create).collect(Collectors.toList()));
    }

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
