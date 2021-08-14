package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.entity.Siti;
import com.rafiki.webapp.repository.SitiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional( readOnly = true)
public class SitiServiceImpl implements SitiService{
    @Autowired
    SitiRepository sitiRepository;

    @Override
    public List<Siti> selTutti() {
        return (List<Siti>) sitiRepository.findAll();
    }

    @Override
    @Transactional
    public void aggiungiSito(Siti sito) {
        sitiRepository.save(sito);
    }

    @Override
    public Siti cercaSito(int idsito) {
        return sitiRepository.findByIdsito(idsito);
    }

    @Override
    public List<Articoli> cercaArticoli(int idsito) {
        return sitiRepository.findSitoByArticoli(idsito);
    }
}
