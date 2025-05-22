package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.ItemPedidoDTO;
import com.pixelguardian.pharmanetapi.model.entity.*;
import com.pixelguardian.pharmanetapi.service.EstoqueService;
import com.pixelguardian.pharmanetapi.service.PedidoCompraService;
import com.pixelguardian.pharmanetapi.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class ItemPedidoController {
    private final EstoqueService estoqueService;
    private final PedidoCompraService pedidoCompraService;
    private final ReceitaService receitaService;

    public ItemPedido converter(ItemPedidoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ItemPedido itemPedido = modelMapper.map(dto, ItemPedido.class);
        if (dto.getIdEstoque() != null) {
            Optional<Estoque> estoque = estoqueService.getEstoqueById((dto.getIdEstoque()));
            if (estoque.isPresent()) {
                itemPedido.setEstoque(estoque.get());
            } else {
                itemPedido.setEstoque(null);
            }
        }
        if (dto.getIdPedidoCompra() != null) {
            Optional<PedidoCompra> pedidoCompra = pedidoCompraService.getPedidoCompraById((dto.getIdPedidoCompra()));
            if (pedidoCompra.isPresent()) {
                itemPedido.setPedidoCompra(pedidoCompra.get());
            } else {
                itemPedido.setPedidoCompra(null);
            }
        }
        if (dto.getIdReceita() != null) {
            Optional<Receita> receita = receitaService.getReceitaById((dto.getIdReceita()));
            if (receita.isPresent()) {
                itemPedido.setReceita(receita.get());
            } else {
                itemPedido.setReceita(null);
            }
        }
        return itemPedido;
    }
}
