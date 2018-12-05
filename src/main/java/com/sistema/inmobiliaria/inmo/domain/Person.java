package com.sistema.inmobiliaria.inmo.domain;

import com.sistema.inmobiliaria.inmo.core.IdGenerator;
import com.sistema.inmobiliaria.inmo.domain.common.AuditedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Person extends AuditedEntity<String> {


    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.id = IdGenerator.getLongId();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    private long id;

    private String firstName;

    private String lastName;
}
