package com.sistema.inmobiliaria.inmo.domain.user;

import com.sistema.inmobiliaria.inmo.domain.common.VersionedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "USER_SEQ_ID", allocationSize = 100)
public class User extends VersionedEntity<Long> {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
