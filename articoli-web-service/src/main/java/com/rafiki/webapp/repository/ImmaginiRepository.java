package com.rafiki.webapp.repository;

import com.rafiki.webapp.entity.Immagini;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ImmaginiRepository extends PagingAndSortingRepository<Immagini, String> {

    Immagini findByIdimmagine(@Param("idimmagine") int idimmagine);

}
