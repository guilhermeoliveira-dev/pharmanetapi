package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.CategoriaDTO;
import com.pixelguardian.pharmanetapi.api.dto.VendaDTO;
import com.pixelguardian.pharmanetapi.model.entity.*;
import com.pixelguardian.pharmanetapi.service.EnderecoService;
import com.pixelguardian.pharmanetapi.service.PagamentoService;
import com.pixelguardian.pharmanetapi.service.PedidoCompraService;
import com.pixelguardian.pharmanetapi.service.VendaService;
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
@RequestMapping("/api/v1/vendas")
@RequiredArgsConstructor
@CrossOrigin
public class VendaController {

    private final VendaService service;
    private final PagamentoService pagamentoService;
    private final PedidoCompraService pedidoCompraService;
    private final EnderecoService enderecoService;

    @GetMapping()
    public ResponseEntity get() {
        List<Venda> vendas = service.getVendas();
        return ResponseEntity.ok(vendas.stream().map(VendaDTO::create).collect(Collectors.toList()));
    }

    public Venda converter(VendaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Venda venda = modelMapper.map(dto, Venda.class);
        if (dto.getIdPagamento() != null) {
            Optional<Pagamento> pagamento = pagamentoService.getPagamentoById(dto.getIdPagamento());
            if (pagamento.isPresent()) {
                venda.setPagamento(pagamento.get());
            } else {
                venda.setPagamento(null);
            }
        }
        if (dto.getIdPedidoCompra() != null) {
            Optional<PedidoCompra> pedidoCompra = pedidoCompraService.getPedidoCompraById(dto.getIdPedidoCompra());
            if (pedidoCompra.isPresent()) {
                venda.setPedidoCompra(pedidoCompra.get());
            } else {
                venda.setPedidoCompra(null);
            }
        }
        return venda;
    }
}

//public Aluno converter(AlunoDTO dto) {
//    ModelMapper modelMapper = new ModelMapper();
//    Aluno aluno = modelMapper.map(dto, Aluno.class);
//
//    // esse atributo foi passado direto
//    Endereco endereco = modelMapper.map(dto, Endereco.class);
//    aluno.setEndereco(endereco);
//
//    // esse atributo foi verificado com if e os caramba, provavelmente pq ele precisa de leitura no banco de dados
//    if (dto.getIdCurso() != null) {
//        Optional<Curso> curso = cursoService.getCursoById(dto.getIdCurso());
//        if (!curso.isPresent()) {
//            aluno.setCurso(null);
//        } else {
//            aluno.setCurso(curso.get());
//        }
//    }
//    return aluno;
//}
