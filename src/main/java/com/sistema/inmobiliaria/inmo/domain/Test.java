package com.sistema.inmobiliaria.inmo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
public class Test {

    @Id
    private long id;

    private String name;
    
}
