package com.blue.yw.model;

import java.util.List;

public class NominationResponse {
    private List<NominationVO> nominationVOList;

    public List<NominationVO> getNominationVOList() {
        return nominationVOList;
    }

    public void setNominationVOList(List<NominationVO> nominationVOList) {
        this.nominationVOList = nominationVOList;
    }
}
