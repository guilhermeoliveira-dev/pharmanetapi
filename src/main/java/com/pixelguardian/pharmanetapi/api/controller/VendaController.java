package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.VendaDTO;
import com.pixelguardian.pharmanetapi.model.entity.Endereco;
import com.pixelguardian.pharmanetapi.model.entity.Pagamento;
import com.pixelguardian.pharmanetapi.model.entity.PedidoCompra;
import com.pixelguardian.pharmanetapi.model.entity.Venda;
import com.pixelguardian.pharmanetapi.service.EnderecoService;
import com.pixelguardian.pharmanetapi.service.PagamentoService;
import com.pixelguardian.pharmanetapi.service.PedidoCompraService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class VendaController {
    private final PagamentoService pagamentoService;
    private final PedidoCompraService pedidoCompraService;
    private final EnderecoService enderecoService;

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
