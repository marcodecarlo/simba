package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.entity.Pagine;

public interface PagineService {

    public Pagine findPagina(int idpagina);

    public void eliminaPagina(Pagine pagina);

    public void aggiungiPagina(Pagine pagina);
}
