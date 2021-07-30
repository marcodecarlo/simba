package com.rafiki.webapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "PAGINERECORD")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class PagineRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPAGINARECORD")
    private int idpaginarecord;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "VALORE")
    private String valore;

    @Column(name = "NUMERO")
    private int numero;

    @Column(name = "LINGUA")
    private String lingua;

    //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "IDPAGINA", referencedColumnName = "idpagina")
    @JsonBackReference
    private Pagine pagina;

    //  @NotNull(message = "{NotNull.Articoli.sito.Validation}")
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATO")
    private Date creato;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFICATO")
    private Date modificato;

    @Override
    public String toString() {
        return "PagineRecord{" +
            "idPagineRecord=" + idpaginarecord +
            ", nome=" + nome +
            ", valore=" + valore +
            ", numero=" + numero +
            ", lingua=" + lingua +
            ", pagina=" + pagina.getIdpagina() +
            ", data creazione=" + creato +
            ", data ultima modificato=" + modificato +
            '}';
    }
}
