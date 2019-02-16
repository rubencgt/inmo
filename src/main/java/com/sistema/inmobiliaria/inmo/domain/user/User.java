package com.sistema.inmobiliaria.inmo.domain.user;

import com.sistema.inmobiliaria.inmo.domain.advertisement.Advertisement;
import com.sistema.inmobiliaria.inmo.domain.common.VersionedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "USER_SEQ_ID", allocationSize = 100)
public class User extends VersionedEntity<Long> {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<Advertisement> advertisements;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "USER_ID")
    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }
}
