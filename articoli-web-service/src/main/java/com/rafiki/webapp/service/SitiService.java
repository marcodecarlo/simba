package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.entity.Siti;

import java.util.List;

public interface SitiService {

    public List<Siti> selTutti();

    public Siti cercaSito(int idsito);

    public List<Articoli> cercaArticoli(int idsito);

}
