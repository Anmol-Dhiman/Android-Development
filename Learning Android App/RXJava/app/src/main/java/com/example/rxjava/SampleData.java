package com.example.rxjava;

import java.util.ArrayList;

public class SampleData {

    public static ArrayList<DataModel> callData() {

        ArrayList<DataModel> temp = new ArrayList<>();
        temp.add(new DataModel("milk",true,2));
        temp.add(new DataModel("cake",false,1));
        temp.add(new DataModel("water",true,4));
        temp.add(new DataModel("tea",false,5));
        temp.add(new DataModel("coffee",false,3));


        return temp;


    }
}
