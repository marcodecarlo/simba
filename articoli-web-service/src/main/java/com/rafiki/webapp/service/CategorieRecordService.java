package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.CategorieRecord;

import java.util.List;

public interface CategorieRecordService {

    public CategorieRecord findCategoriaRecord(int idcategoriarecord);

    public List<CategorieRecord> findAllCategorieRecords(int idcategoria);

    public void eliminaCategoriaRecord(CategorieRecord categorierecord);

    public void aggiungiCategoriaRecord(CategorieRecord categorierecord);

}
