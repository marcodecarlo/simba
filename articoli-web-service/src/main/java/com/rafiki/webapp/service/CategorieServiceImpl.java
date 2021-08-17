package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Categorie;
import com.rafiki.webapp.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional( readOnly = true)
public class CategorieServiceImpl implements CategorieService{
    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie cercaCategoria(int idcategoria) {
        return categorieRepository.findByIdcategoria(idcategoria);
    }

    @Override
    @Transactional
    public void eliminaCategoria(Categorie categoria) {
        categorieRepository.delete(categoria);
    }

    @Override
    @Transactional
    public void aggiungiCategoria(Categorie categoria) {
        categorieRepository.save(categoria);
    }
}
