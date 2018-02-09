package com.blue.yw.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "yw", catalog = "")
public class UserEntity {
    private int userId;
    private String userName;
    private String userPassword;
    private Timestamp createDate;
    private Timestamp lastLoginDate;
    private String createIp;

    @Id
    @Column(name = "USER_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "USER_PASSWORD", nullable = true, length = 255)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
    @Column(name = "LAST_LOGIN_DATE", nullable = true)
    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Basic
    @Column(name = "CREATE_IP", nullable = true, length = 255)
    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(lastLoginDate, that.lastLoginDate) &&
                Objects.equals(createIp, that.createIp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userName, userPassword, createDate, lastLoginDate, createIp);
    }
}
