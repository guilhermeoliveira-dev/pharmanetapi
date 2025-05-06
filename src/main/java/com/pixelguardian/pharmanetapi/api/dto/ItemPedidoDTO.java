package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private Long id;
    private Integer quantidade;
    private Float precoUnitario;

    private Long idEstoque;
//    private Integer quantidadeEstoque;
//    //TODO: talvez isso de quantidadeEstoque dê problema
//    private Long idProduto;
//    private Long idFornecedor;
//    private Long idFarmacia;

    private Long idPedidoCompra;
//    private String codigo;
//    private String dataCriacao;
//    private String status;
//    private Float valorTotal;
//    private String tipoEntrega;
//    private String statusEntrega;
//    private String dataEntrega;
//    private Long idEndereco;

    private Long idReceita;
//    private String medico;
//    private String dataEmissao;
//    private String validade;
//    private String itemPrescrito;
//    private Boolean aprovado;
//    private Long idfuncionario;

    public static PedidoCompraDTO create(ItemPedido itemPedido) {
        ModelMapper modelMapper = new ModelMapper();
        PedidoCompraDTO dto = modelMapper.map(itemPedido, PedidoCompraDTO.class);
        return dto;
    }
}
