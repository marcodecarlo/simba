package com.rafiki.webapp.repository;

import com.rafiki.webapp.entity.Articoli;
import com.rafiki.webapp.entity.Siti;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SitiRepository extends PagingAndSortingRepository<Siti, String> {

    Siti findByIdsito(@Param("idsito") int idsito);

    @Query(value = "SELECT * FROM SITI INNER JOIN ARTICOLI USING(IDSITO) WHERE IDSITO = :idsito", nativeQuery = true)
    List<Articoli> findSitoByArticoli(@Param("idsito") int idsito);


}
