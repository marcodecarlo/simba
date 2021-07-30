package com.rafiki.webapp.repository;

import com.rafiki.webapp.entity.Articoli;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticoliRepository extends PagingAndSortingRepository<Articoli, String> {

    Articoli findByIdarticolo(@Param("idarticolo") int idarticolo);

    @Query(value = "SELECT * FROM ARTICOLI WHERE IDSITO = :idsito", nativeQuery = true)
    List<Articoli> findAllByArticoli(@Param("idsito") int idsito);

    @Query(value = "SELECT * FROM ARTICOLI INNER JOIN PAGINE USING(IDARTICOLO) WHERE IDARTICOLO = :idarticolo", nativeQuery = true)
    List<Articoli> findByPagine(@Param("idarticolo") int idarticolo);

    @Query(value = "SELECT * FROM ARTICOLI INNER JOIN ARTICOlI_CATEGORIE USING(IDARTICOLO) INNER JOIN CATEGORIE USING(IDCATEGORIA) WHERE IDCATEGORIA = :idcategoria", nativeQuery = true)
    List<Articoli> findArticoliByCategoria(@Param("idcategoria") int idcategoria);


}
