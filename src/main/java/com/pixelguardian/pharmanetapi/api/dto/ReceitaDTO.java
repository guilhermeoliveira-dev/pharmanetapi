package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.Cargo;
import com.pixelguardian.pharmanetapi.model.entity.Farmacia;
import com.pixelguardian.pharmanetapi.model.entity.Receita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.ManyToOne;

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
    private Float salario;
    private String expediente;
    private Cargo cargo;
    private Farmacia farmacia;

    public static ReceitaDTO create(Receita receita) {
        ModelMapper modelMapper = new ModelMapper();
        ReceitaDTO dto = modelMapper.map(receita, ReceitaDTO.class);
        dto.idFuncionario = receita.getFuncionario().getId();
        dto.salario = receita.getFuncionario().getSalario();
        dto.expediente = receita.getFuncionario().getExpediente();
        dto.cargo = receita.getFuncionario().getCargo();
        dto.farmacia = receita.getFuncionario().getFarmacia();
        return dto;
    }
}