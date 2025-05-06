package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.Venda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {

    private Long id;
    private String dataVenda;

    private Long idPagamento;

    private Long idPedidoCompra;

    public static VendaDTO create(Venda venda) {
        ModelMapper modelMapper = new ModelMapper();
        VendaDTO dto = modelMapper.map(venda, VendaDTO.class);
        return dto;
    }
}