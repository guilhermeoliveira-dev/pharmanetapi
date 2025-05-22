package com.pixelguardian.pharmanetapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Usuario{

    private Float salario;
    private String expediente;

    @ManyToOne
    private Cargo cargo;

    @ManyToOne
    private Farmacia farmacia;
}
