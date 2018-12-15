package com.sistema.inmobiliaria.inmo.domain;

import com.sistema.inmobiliaria.inmo.domain.common.VersionedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "PERSON_SEQ_ID", allocationSize = 100)
public class Person extends VersionedEntity<Long> {


    public Person() {
    }

    private String email;

    private String firstName;

    private String lastName;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
