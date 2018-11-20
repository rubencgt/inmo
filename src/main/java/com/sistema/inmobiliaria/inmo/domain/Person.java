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
public class Person {

    @Id
    private long id;

    private String firstName;

    private String lastName;
}
