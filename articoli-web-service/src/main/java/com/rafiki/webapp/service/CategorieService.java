package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.entity.Categorie;

public interface CategorieService{

    public Categorie cercaCategoria(int idcategoria);

    public void eliminaCategoria(Categorie categoria);

    public void aggiungiCategoria(Categorie categoria);
}
