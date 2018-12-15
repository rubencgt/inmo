package com.sistema.inmobiliaria.inmo.domain.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.StringJoiner;

@MappedSuperclass
public abstract class VersionedEntity<PK extends Serializable> extends AuditedEntity<String> {

    protected PK id;

    protected Long version;

    @Id
    @GeneratedValue(generator = "ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    @Version
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VersionedEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("version=" + version)
                .toString();
    }
}