package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.Tarja;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarjaDTO {

    private Long id;
    private String nome;
    private String cor;
    private Boolean requerReceita;
    private Boolean retemReceita;

    public static TarjaDTO create(Tarja tarja) {
        ModelMapper modelMapper = new ModelMapper();
        TarjaDTO dto = modelMapper.map(tarja, TarjaDTO.class);
        return dto;
    }
}