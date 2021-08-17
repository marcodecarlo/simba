package com.rafiki.webapp.service;

import com.rafiki.webapp.entity.PagineRecord;

import java.util.List;

public interface PagineRecordService {

    public PagineRecord findPaginaRecord(int idpaginarecord);

    public List<PagineRecord> findAllPagineRecords(int idpagina);

    public void eliminaPaginaRecord(PagineRecord paginarecord);

    public void aggiungiPaginaRecord(PagineRecord paginarecord);
}
