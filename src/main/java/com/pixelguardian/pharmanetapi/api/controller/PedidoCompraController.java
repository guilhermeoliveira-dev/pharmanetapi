package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.PedidoCompraDTO;
import com.pixelguardian.pharmanetapi.model.entity.Endereco;
import com.pixelguardian.pharmanetapi.model.entity.PedidoCompra;
import com.pixelguardian.pharmanetapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class PedidoCompraController {

    private final EnderecoService enderecoService;

    public PedidoCompra converter(PedidoCompraDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        PedidoCompra pedidoCompra = modelMapper.map(dto, PedidoCompra.class);
        if (dto.getIdEndereco() != null) {
            Optional<Endereco> endereco = enderecoService.getEnderecoById(dto.getIdEndereco());
            if (endereco.isPresent()) {
                pedidoCompra.setEndereco(endereco.get());
            } else {
                pedidoCompra.setEndereco(null);
            }
        }
        return pedidoCompra;
    }
}
