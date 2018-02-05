package com.blue.yw.model;

import java.util.List;

public class NominationResponse {
    private List<NominationListEntity> nominationList;

    public List<NominationListEntity> getNominationList() {
        return nominationList;
    }

    public void setNominationList(List<NominationListEntity> nominationList) {
        this.nominationList = nominationList;
    }
}
