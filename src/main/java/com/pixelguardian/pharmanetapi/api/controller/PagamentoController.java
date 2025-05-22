package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.PagamentoDTO;
import com.pixelguardian.pharmanetapi.model.entity.Pagamento;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class PagamentoController {
    public Pagamento converter(PagamentoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        //    TODO: Aponta redundâncoia em pagamento
        return pagamento;
    }
}
