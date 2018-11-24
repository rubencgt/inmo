package com.sistema.inmobiliaria.inmo.domain;

import com.sistema.inmobiliaria.inmo.domain.common.AuditedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends AuditedEntity<String> {

    @Id
    private long id;

    private String firstName;

    private String lastName;
}
