package com.example.retrofit_hack;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

//@SerializedName("checkpoint" ) var checkpoint : ArrayList<ArrayList<Double>> = arrayListOf(),
//@SerializedName("_id"        ) var Id         : String?                      = null,
//@SerializedName("firstName"  ) var firstName  : String?                      = null,
//@SerializedName("lastName"   ) var lastName   : String?                      = null,
//@SerializedName("Id"         ) var Id         : String?                      = null,
//@SerializedName("password"   ) var password   : String?                      = null,
//@SerializedName("__v"        )

public class Checkpoints {
    @SerializedName("checkpoint")
    private ArrayList<ArrayList<Double>> checkpoint;
    @SerializedName("_id")
    private String _id;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("Id")
    private String Id;
    @SerializedName("password")
    private String password;
    @SerializedName("__v")
    private int __v;

    public ArrayList<ArrayList<Double>> getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(ArrayList<ArrayList<Double>> checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}

