package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.Immagini;

public interface ImmaginiService {

    public Immagini cercaImmagine(int idimmagine);

    public void eliminaImmagine(Immagini immagine);

    public void aggiungiImmagine(Immagini immagine);
}
