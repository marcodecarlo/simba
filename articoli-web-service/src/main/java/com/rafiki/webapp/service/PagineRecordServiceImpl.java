package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.PagineRecord;
import com.rafiki.webapp.repository.PagineRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional( readOnly = true)
public class PagineRecordServiceImpl implements PagineRecordService{
    @Autowired
    PagineRecordRepository pagineRecordRepository;
    @Override
    public PagineRecord findPaginaRecord(int idpaginarecord) {
        return pagineRecordRepository.findByIdpaginarecord(idpaginarecord);
    }

    @Override
    public List<PagineRecord> findAllPagineRecords(int idpagina) {
        return pagineRecordRepository.findAllPagineRecords(idpagina);
    }

    @Override
    public void eliminaPaginaRecord(PagineRecord paginarecord) {
        pagineRecordRepository.delete(paginarecord);
    }

    @Override
    public void aggiungiPaginaRecord(PagineRecord paginarecord) {
        pagineRecordRepository.delete(paginarecord);
    }
}
