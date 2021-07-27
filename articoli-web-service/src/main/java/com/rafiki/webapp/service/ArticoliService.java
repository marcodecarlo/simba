package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Articoli;

import java.util.List;

public interface ArticoliService {

    public List<Articoli> selTutti();

    public Articoli cercaArticolo(int idarticolo);

    public List<Articoli> cercaArticoli(int idsito);

    public List<Articoli> cercaArticoliDaCategoria(int idcategoria);

    public void eliminaArticolo(Articoli articolo);

    public void aggiungiArticolo(Articoli articolo);
}
