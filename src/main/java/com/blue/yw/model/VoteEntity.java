package com.blue.yw.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vote", schema = "yw", catalog = "")
public class VoteEntity {
    private int voteId;
    private Integer nominationId;
    private String userIp;
    private Timestamp createDate;
    private String state;
    private String userName;
    private Integer userId;

    @Id
    @Column(name = "VOTE_ID", nullable = false)
    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    @Basic
    @Column(name = "NOMINATION_ID", nullable = true)
    public Integer getNominationId() {
        return nominationId;
    }

    public void setNominationId(Integer nominationId) {
        this.nominationId = nominationId;
    }

    @Basic
    @Column(name = "USER_IP", nullable = true, length = 255)
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Basic
    @Column(name = "CREATE_DATE", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "STATE", nullable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteEntity that = (VoteEntity) o;
        return voteId == that.voteId &&
                Objects.equals(nominationId, that.nominationId) &&
                Objects.equals(userIp, that.userIp) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(voteId, nominationId, userIp, createDate, state);
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_ID", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
