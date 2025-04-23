package com.pixelguardian.pharmanetapi.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Entity

public class Cliente extends Usuario{

    private Float fidelidadePontos;
}
