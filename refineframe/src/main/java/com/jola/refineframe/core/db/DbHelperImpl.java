package com.jola.refineframe.core.db;


import com.jola.refineframe.core.dao.HistoryData;

import java.util.List;

import javax.inject.Inject;

public class DbHelperImpl implements DbHelper {

    @Inject
    public DbHelperImpl() {
    }

    @Override
    public List<HistoryData> addHistoryData(String data) {
        return null;
    }

    @Override
    public void clearHistoryData() {

    }

    @Override
    public List<HistoryData> loadAllHistoryData() {
        return null;
    }
}
