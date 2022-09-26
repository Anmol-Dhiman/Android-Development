package com.example.chats.Adapters;

public class User {

    String profliePic, userName, lastMessage, phoneNumber,userId,about;

    public User(String profliePic, String userName, String lastMessage, String phoneNumber, String userId, String about) {
        this.profliePic = profliePic;
        this.userName = userName;
        this.lastMessage = lastMessage;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.about = about;
    }

    public String getProfliePic() {
        return profliePic;
    }

    public void setProfliePic(String profliePic) {
        this.profliePic = profliePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
