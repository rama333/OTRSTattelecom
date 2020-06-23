package com.example.otrstattelecom.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable {
    @SerializedName("Success")
    String Success;
    @SerializedName("ErrorMessage")
    String ErrorMessage;
    @SerializedName("Data")
    Data data;


    public class Data
    {


    }


}
