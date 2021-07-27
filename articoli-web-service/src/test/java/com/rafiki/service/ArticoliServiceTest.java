package com.rafiki.service;

import com.rafiki.Application;
import com.rafiki.webapp.entity.Articoli;
import static org.assertj.core.api.Assertions.assertThat;
import com.rafiki.webapp.entity.Categorie;
import com.rafiki.webapp.entity.Pagine;
import com.rafiki.webapp.entity.Siti;
import com.rafiki.webapp.service.ArticoliService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class ArticoliServiceTest {
    @Autowired
    private ArticoliService articoliService;

    private Articoli createArticolo(){
        Articoli articolo = new Articoli();
        Siti sito = new Siti();
        Categorie categorie = new Categorie();
        List<Categorie> list_categorie = new ArrayList<>();
        Set<Articoli> list_articoli = new HashSet<>();
        Set<Pagine> list_pagine = new HashSet<>();

        sito.setAbilitato(true);
        sito.setCreato(new Date());
        sito.setIdsito(0);
        sito.setNome("Home");
        sito.setPath("/home");

        categorie.setAbbreviazione("moda");
        categorie.setCreato(new Date());
        list_categorie.add(categorie);

        articolo.setIdarticolo(0);
        articolo.setSito(sito);
        articolo.setCategorie(list_categorie);
        articolo.setCreato(new Date());
        articolo.setImmagine("/prova");

        list_articoli.add(articolo);



        Pagine pagina = new Pagine();

        pagina.setIdpagina(0);
        pagina.setArticolo(articolo);
        pagina.setCreato(new Date());
        pagina.setNumero(0);

        list_pagine.add(pagina)
        articolo.setPagine(list_pagine);
        sito.setArticoli(list_articoli);

        return articolo;
    }

    @Test
    public void TestaggiungiArticolo(){
        Articoli articolo = this.createArticolo();

        articoliService.aggiungiArticolo(articolo);
    }

   @Test
    public void TestselTutti(  ){
       assertThat(articoliService.selTutti()).extracting(Articoli::getIdarticolo)
           .containsOnly(0);
    }

}
