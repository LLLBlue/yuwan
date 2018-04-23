package com.blue.yw.model;

import java.util.List;

/**
 * SysConfigResponse
 *
 * @author Nozomi
 * @date 4/23/2018
 */
public class SysConfigResponse {
    private List<SysConfigEntity> configEntityList;

    public List<SysConfigEntity> getConfigEntityList() {
        return configEntityList;
    }

    public void setConfigEntityList(List<SysConfigEntity> configEntityList) {
        this.configEntityList = configEntityList;
    }
}
