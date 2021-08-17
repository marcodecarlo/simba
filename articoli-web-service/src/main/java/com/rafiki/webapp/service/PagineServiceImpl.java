package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.entity.Pagine;
import com.rafiki.webapp.repository.PagineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional( readOnly = true)
public class PagineServiceImpl implements PagineService{
    @Autowired
    PagineRepository pagineRepository;

    @Override
    public Pagine findPagina(int idpagina) {
        return pagineRepository.findByIdpagina(idpagina);
    }

    @Override
    @Transactional
    public void eliminaPagina(Pagine pagine) {
        pagineRepository.delete(pagine);
    }

    @Override
    @Transactional
    public void aggiungiPagina(Pagine pagine) {
        pagineRepository.save(pagine);
    }
}
