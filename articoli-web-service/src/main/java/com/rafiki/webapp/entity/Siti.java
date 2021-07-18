package com.rafiki.webapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "SITI")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Siti implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSITO")
    private int idsito;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PATH")
    private String path;

    @Column(name = "ABILITATO")
    private Boolean abilitato;

    //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATO")
    private Date creato;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFICATO")
    private Date modificato;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sito", orphanRemoval = true)
    @JsonManagedReference
    private Set<Articoli> articoli = new HashSet<Articoli>();

    @Override
    public String toString() {
        return "Siti{" +
            "idSito=" + idsito +
            ", nome=" + nome +
            ", path=" + path +
            ", abilitato=" + abilitato +
            ", size_articoli=" + articoli.size() +
            ", data creazione=" + creato +
            ", data ultima modificato=" + modificato +
            '}';
    }
}
