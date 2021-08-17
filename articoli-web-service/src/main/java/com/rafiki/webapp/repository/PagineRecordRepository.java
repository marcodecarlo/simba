package com.rafiki.webapp.repository;

import com.rafiki.webapp.entity.PagineRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagineRecordRepository extends PagingAndSortingRepository<PagineRecord, String> {

    PagineRecord findByIdpaginarecord(@Param("idpaginarecord") int idpaginarecord);

    @Query(value = "SELECT * FROM PAGINE INNER JOIN PAGINERECORD USING(IDPAGINA) WHERE IDPAGINA = :idpagina", nativeQuery = true)
    List<PagineRecord> findAllPagineRecords(@Param("idpagina") int idpagina);
}
