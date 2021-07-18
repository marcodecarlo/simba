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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "CATEGORIE")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCATEGORIA")
    private int idcatogoria;

    @Column(name = "ABBREVIAZIONE")
    private String abbreviazione;
//forse JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "categorie", orphanRemoval = true)
    @JsonManagedReference
    private Set<CategorieRecord> categorieRecord = new HashSet<CategorieRecord>();

    @ManyToMany(mappedBy = "articoli")
    @JsonBackReference
    private List<Articoli> articoli = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "categorie", orphanRemoval = true)
    @JsonIgnore
    private Set<Categorie> categories = new HashSet<Categorie>();

    //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "IDSOTTOCATEGORIA", referencedColumnName = "idsottocategoria")
    @JsonBackReference
    private Categorie sottocategoria;

    //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATO")
    private Date creato;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFICATO")
    private Date modificato;


    @Override
    public String toString() {
        return "Categorie{" +
            "idcatogoria=" + idcatogoria +
            ", abbreviazione=" + abbreviazione +
            ", size_articoli=" + articoli.size() +
            ", size_categorieRecord=" + categorieRecord.size() +
            ", size_categories=" + categories.size() +
            ", sottocategoria=" + sottocategoria.getIdcatogoria() +
            ", data creazione=" + creato +
            ", data ultima modificato=" + modificato +
            '}';
    }

}
