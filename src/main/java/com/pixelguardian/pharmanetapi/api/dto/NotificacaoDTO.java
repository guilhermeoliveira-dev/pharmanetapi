package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.Notificacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoDTO {

    private Long id;
    private String mensagem;
    private String dataEnvio;
    private String tipoNotificacao;

    private Long idUsuario;

    public static NotificacaoDTO create(Notificacao notificacao) {
        ModelMapper modelMapper = new ModelMapper();
        NotificacaoDTO dto = modelMapper.map(notificacao, NotificacaoDTO.class);
        return dto;
    }
}