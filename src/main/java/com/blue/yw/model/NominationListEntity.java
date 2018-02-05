package com.blue.yw.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "nomination_list", schema = "yw")
public class NominationListEntity {
    private int nominationId;
    private String shortName;
    private String userName;
    private String userIp;
    private Timestamp createDate;
    private String state;

    @Id
    @Column(name = "NOMINATION_ID", nullable = false)
    public int getNominationId() {
        return nominationId;
    }

    public void setNominationId(int nominationId) {
        this.nominationId = nominationId;
    }

    @Basic
    @Column(name = "SHORT_NAME", nullable = true, length = 255)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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
        NominationListEntity that = (NominationListEntity) o;
        return nominationId == that.nominationId &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userIp, that.userIp) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nominationId, shortName, userName, userIp, createDate, state);
    }
}
