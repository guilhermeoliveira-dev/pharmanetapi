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
    private String uf;
    private String cidade;
    private String cep;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;

    public static UsuarioDTO create(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
        dto.logradouro = usuario.getEndereco().getLogradouro();
        dto.numero = usuario.getEndereco().getNumero();
        dto.complemento = usuario.getEndereco().getComplemento();
        dto.bairro = usuario.getEndereco().getBairro();
        dto.cidade = usuario.getEndereco().getCidade();
        dto.uf = usuario.getEndereco().getUf();
        dto.cep = usuario.getEndereco().getCep();
        return dto;
    }
}