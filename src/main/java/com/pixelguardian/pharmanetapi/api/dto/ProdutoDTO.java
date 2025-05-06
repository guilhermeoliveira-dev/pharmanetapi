package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Float preco;
    //private NaoSei imagem;
    private Boolean requerLote;
    private Float peso;
    private Boolean generico;

    private Long idTarja;

    private Long idCategoria;

    public static ProdutoDTO create(Produto produto) {
        ModelMapper modelMapper = new ModelMapper();
        ProdutoDTO dto = modelMapper.map(produto, ProdutoDTO.class);
        return dto;
    }
}