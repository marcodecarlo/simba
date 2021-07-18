package com.rafiki.webapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "IMMAGINI")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Immagini implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDIMMAGINE")
    private int idimmagine;

    @Column(name = "TESTO")
    private String testo;

    @Column(name = "IMMAGINE")
    private String immagine;

    @ManyToMany(mappedBy = "immagini")
    @JsonBackReference
    private List<Pagine> pagine = new ArrayList<>();

    //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATO")
    private Date creato;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFICATO")
    private Date modificato;

    @Override
    public String toString() {
        return "Immagini{" +
            "idimmagine=" + idimmagine +
            ", testo=" + testo +
            ", immagine=" + immagine +
            ", size_pagine=" + pagine.size() +
            ", data creazione=" + creato +
            ", data ultima modificato=" + modificato +
            '}';
    }
}
