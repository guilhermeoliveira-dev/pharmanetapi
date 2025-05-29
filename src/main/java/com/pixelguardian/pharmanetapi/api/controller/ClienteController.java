package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.ClienteDTO;
import com.pixelguardian.pharmanetapi.model.entity.Cliente;
import com.pixelguardian.pharmanetapi.model.entity.Endereco;
import com.pixelguardian.pharmanetapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
@CrossOrigin
public class ClienteController {

    private final EnderecoService enderecoService;

    public Cliente converter(ClienteDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        if (dto.getIdEndereco() != null) {
            Optional<Endereco> endereco = enderecoService.getEnderecoById((dto.getIdEndereco()));
            if (endereco.isPresent()) {
                cliente.setEndereco(endereco.get());
            } else {
                cliente.setEndereco(null);
            }
        }
        return cliente;
    }
}
