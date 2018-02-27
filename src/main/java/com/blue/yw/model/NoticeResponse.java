package com.blue.yw.model;

import java.util.List;

public class NoticeResponse {
    private List<SysConfigEntity> sysConfigEntityList;

    public List<SysConfigEntity> getSysConfigEntityList() {
        return sysConfigEntityList;
    }

    public void setSysConfigEntityList(List<SysConfigEntity> sysConfigEntityList) {
        this.sysConfigEntityList = sysConfigEntityList;
    }
}
