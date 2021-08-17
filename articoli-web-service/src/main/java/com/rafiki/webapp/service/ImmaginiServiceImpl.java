package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Immagini;
import com.rafiki.webapp.repository.ImmaginiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional( readOnly = true)
public class ImmaginiServiceImpl implements ImmaginiService{
    @Autowired
    ImmaginiRepository immaginiRepository;

    @Override
    public Immagini cercaImmagine(int idimmagine) {
        return immaginiRepository.findByIdimmagine(idimmagine);
    }

    @Override
    @Transactional
    public void eliminaImmagine(Immagini immagine) {
        immaginiRepository.delete(immagine);
    }

    @Override
    @Transactional
    public void aggiungiImmagine(Immagini immagine) {
        immaginiRepository.save(immagine);
    }
}
