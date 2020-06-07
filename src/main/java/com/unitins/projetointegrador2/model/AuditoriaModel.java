package com.unitins.projetointegrador2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"datacadastro", "dataalteracao"},
        allowGetters = true
)
@Getter
@Setter
public abstract class AuditoriaModel implements Serializable {

    @Column(name = "datacadastro", updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacadastro;

    @Column(name = "dataalteracao")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataalteracao;

}
