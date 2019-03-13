package com.jola.refineframe.core.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;



@Entity
public class HistoryData {

    @Id(autoincrement = true)
    private Long id;

    private long date;

    private String data;


}
