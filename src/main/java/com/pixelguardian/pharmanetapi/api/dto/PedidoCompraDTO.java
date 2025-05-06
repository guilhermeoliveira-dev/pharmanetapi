package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.PedidoCompra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoCompraDTO {

    private String codigo;
    private String dataCriacao;
    private String status;
    private Float valorTotal;
    private String tipoEntrega;
    private String statusEntrega;
    private String dataEntrega;

    private Long idEndereco;

    public static PedidoCompraDTO create(PedidoCompra pedidoCompra) {
        ModelMapper modelMapper = new ModelMapper();
        PedidoCompraDTO dto = modelMapper.map(pedidoCompra, PedidoCompraDTO.class);
        return dto;
    }
}