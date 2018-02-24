package com.blue.yw.model;

import java.util.List;

public class VoteResponse {
    private List<VoteEntity> voteList;
    private String voteState;

    public List<VoteEntity> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<VoteEntity> voteList) {
        this.voteList = voteList;
    }

    public String getVoteState() {
        return voteState;
    }

    public void setVoteState(String voteState) {
        this.voteState = voteState;
    }
}
