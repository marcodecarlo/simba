package com.rafiki.webapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "PAGINE")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Pagine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPAGINA")
    private int idpagina;

    @Column(name = "NUMERO")
    private int numero;

    //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "IDARTICOLO", referencedColumnName = "idarticolo")
    @JsonBackReference
    private Articoli articolo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pagina", orphanRemoval = true)
    @JsonManagedReference
    private Set<PagineRecord> pagineRecord = new HashSet<PagineRecord>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "PAGINE_IMMAGINI",
        joinColumns = @JoinColumn(name = "IDPAGINA"),
        inverseJoinColumns = @JoinColumn(name = "IDIMMAGINE")
    )
    @JsonIgnore
    private List<Immagini> immagini = new ArrayList<>();

    //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATO")
    private Date creato;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFICATO")
    private Date modificato;


    @Override
    public String toString() {
        return "Pagine{" +
            "idPagina=" + idpagina +
            ", numero=" + numero +
            ", idArticoli=" + articolo.getIdarticolo() +
            ", size_pagineRecord=" + pagineRecord.size() +
            ", size_immagini=" + immagini.size() +
            ", data creazione=" + creato +
            ", data ultima modificato=" + modificato +
            '}';
    }
}
