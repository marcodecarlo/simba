package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.CategorieRecord;
import com.rafiki.webapp.repository.CategorieRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional( readOnly = true)
public class CategorieRecordServiceImpl implements CategorieRecordService {
    @Autowired
    CategorieRecordRepository categorieRecordRepository;

    @Override
    public CategorieRecord findCategoriaRecord(int idcategoriarecord) {
        return categorieRecordRepository.findByIdcategoriarecord(idcategoriarecord);
    }

    @Override
    public List<CategorieRecord> findAllCategorieRecords(int idcategoria) {
        return categorieRecordRepository.findAllCategorieRecords(idcategoria);
    }

    @Override
    @Transactional
    public void eliminaCategoriaRecord(CategorieRecord categorierecord) {
        categorieRecordRepository.delete(categorierecord);
    }

    @Override
    @Transactional
    public void aggiungiCategoriaRecord(CategorieRecord categorierecord) {
        categorieRecordRepository.save(categorierecord);
    }
}
