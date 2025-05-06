package com.pixelguardian.pharmanetapi.api.dto;

import com.pixelguardian.pharmanetapi.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private String dataAdmissao;
    //private NaoSei imagemPerfil;

    private Long idEndereco;

    public static UsuarioDTO create(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
        return dto;
    }
}