package com.example.einkaufsliste4.controller;

import android.content.Context;

import com.example.einkaufsliste4.model.MyModel;

import java.util.ArrayList;

public class MyController {

    private static MyController instance;
    private final MyModel model;

    public static MyController getInstance(Context context){
        if (instance == null){
            instance = new MyController(context);
        }
        return instance;
    }

    public MyController(Context context){

        model = new MyModel(context);

        // initialize with some demo data, it empty
        if (model.getItemCount() == 0) {

            // data to populate the RecyclerView with
            ArrayList<String> itemNames = new ArrayList<>();
            itemNames.add("Bananen");
            itemNames.add("Mehl");
            itemNames.add("Spezi");
            itemNames.add("Nudeln");
            itemNames.add("Äpfel");

            model.setItems(itemNames);
        }
    }

    public MyModel getModel(){
        return model;
    }

}
