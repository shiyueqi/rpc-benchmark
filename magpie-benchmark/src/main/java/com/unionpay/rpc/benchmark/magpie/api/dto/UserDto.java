package com.unionpay.rpc.benchmark.magpie.api.dto;

import java.io.Serializable;

/**
 * date: 2016/10/20 10:19.
 * author: Yueqi Shi
 */
public class UserDto implements Serializable{

    public UserDto() {
    }

    public UserDto(long userId, String userName, String phone, String email, String address
            , int age, int gender, int userStatus, long createdAt, long lastModified) {
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.userStatus = userStatus;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    private long userId = 0L;

    private String userName = "";

    private String phone = "";

    private String email = "";

    private String address = "";

    private int age = 0;

    private int gender = 0;

    private int userStatus = 0;

    private long createdAt = 0L;

    private long lastModified = 0L;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", userStatus=" + userStatus +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                '}';
    }
}
