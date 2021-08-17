package com.rafiki.webapp.repository;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.entity.Pagine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagineRepository extends PagingAndSortingRepository<Pagine, String> {

    Pagine findByIdpagina(@Param("idpagina") int idpagina);

}
