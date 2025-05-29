package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.PagamentoDTO;
import com.pixelguardian.pharmanetapi.api.dto.PedidoCompraDTO;
import com.pixelguardian.pharmanetapi.model.entity.Pagamento;
import com.pixelguardian.pharmanetapi.model.entity.PedidoCompra;
import com.pixelguardian.pharmanetapi.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/pagamentos")
@RequiredArgsConstructor
@CrossOrigin
public class PagamentoController {

    private final PagamentoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Pagamento> pagamentos = service.getPagamentos();
        return ResponseEntity.ok(pagamentos.stream().map(PagamentoDTO::create).collect(Collectors.toList()));
    }

    public Pagamento converter(PagamentoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Pagamento.class);
    }
}
