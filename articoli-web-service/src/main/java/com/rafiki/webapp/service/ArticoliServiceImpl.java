package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.repository.ArticoliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional( readOnly = true)
public class ArticoliServiceImpl implements ArticoliService{
    @Autowired
    ArticoliRepository articoliRepository;

    @Override
    public List<Articoli> selTutti() {
        return (List<Articoli>) articoliRepository.findAll();
    }

    @Override
    public Articoli cercaArticolo(int idarticolo) {
        return articoliRepository.findByArticolo(idarticolo);
    }

    @Override
    public List<Articoli> cercaArticoli(int idsito) {
        return articoliRepository.findByArticoli(idsito);
    }

    @Override
    public List<Articoli> cercaArticoliDaCategoria(int idcategoria) {
        return articoliRepository.findArticoliByCategoria(idcategoria);
    }

    @Override
    @Transactional
    public void eliminaArticolo(Articoli articolo) {
        articoliRepository.delete(articolo);
    }

    @Override
    @Transactional
    public void aggiungiArticolo(Articoli articolo) {
        articoliRepository.save(articolo);
    }
}
