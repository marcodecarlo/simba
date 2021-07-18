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
@Table( name = "ARTICOLI")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Articoli implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDARTICOLO")
    private int idarticolo;

    @Column(name = "IMMAGINE")
    private String immagine;

  //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "IDSITO", referencedColumnName = "idsito")
    @JsonBackReference
    private Siti sito;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pagine", orphanRemoval = true)
    @JsonManagedReference
    private Set<Pagine> pagine = new HashSet<Pagine>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "ARTICOLI_CATEGORIE",
        joinColumns = @JoinColumn(name = "IDARTICOLI"),
        inverseJoinColumns = @JoinColumn(name = "IDCATEGORIE")
    )
    @JsonIgnore
    private List<Categorie> categorie = new ArrayList<>();

  //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATO")
    private Date creato;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFICATO")
    private Date modificato;


    @Override
    public String toString() {
        return "Articoli{" +
            "idArticolo=" + idarticolo +
            ", immagine=" + immagine +
            ", idSito=" + sito.getIdsito() +
            ", size_categorie=" + categorie.size() +
            ", size_pagine=" + pagine.size() +
            ", data creazione=" + creato +
            ", data ultima modificato=" + modificato +
            '}';
    }
}
