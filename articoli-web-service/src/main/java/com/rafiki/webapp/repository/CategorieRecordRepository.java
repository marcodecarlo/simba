package com.rafiki.webapp.repository;

import com.rafiki.webapp.entity.CategorieRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRecordRepository extends PagingAndSortingRepository<CategorieRecord, String> {

    CategorieRecord findByIdcategoriarecord(@Param("idcategoriarecord") int idcategoriarecord);

    @Query(value = "SELECT * FROM CATEGORIE INNER JOIN CATEGORIERECORD USING(IDCATEGORIA) WHERE IDCATEGORIA = :idcategoria", nativeQuery = true)
    List<CategorieRecord> findAllCategorieRecords(@Param("idcategoria") int idcategoria);

}
