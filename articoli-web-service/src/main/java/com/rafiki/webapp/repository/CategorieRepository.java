package com.rafiki.webapp.repository;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.entity.Categorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends PagingAndSortingRepository<Categorie, String> {

    Categorie findByIdcategoria(@Param("idcategoria") int idcategoria);


}
