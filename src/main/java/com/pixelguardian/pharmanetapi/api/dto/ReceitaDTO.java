package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.Receita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaDTO {

    private Long id;
    private String medico;
    private String dataEmissao;
    private String validade;
    private String itemPrescrito;
    private Boolean aprovado;

    private Long idFuncionario;

    public static ReceitaDTO create(Receita receita) {
        ModelMapper modelMapper = new ModelMapper();
        ReceitaDTO dto = modelMapper.map(receita, ReceitaDTO.class);
        return dto;
    }
}