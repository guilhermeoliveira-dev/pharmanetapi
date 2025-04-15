package com.pixelguardian.pharmanetapi.model.entity;

import java.util.Date;

public abstract class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private Date dataAdmissao;
    //private NaoSei imagemPerfil;

    private Endereco endereco;

}
