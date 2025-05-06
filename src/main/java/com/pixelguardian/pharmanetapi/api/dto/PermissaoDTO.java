package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.Permissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissaoDTO {

    private Long id;
    private String nome;

    private Long idCargo;

    public static PermissaoDTO create(Permissao permissao) {
        ModelMapper modelMapper = new ModelMapper();
        PermissaoDTO dto = modelMapper.map(permissao, PermissaoDTO.class);
        return dto;
    }
}