package com.example.einkaufsliste4.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

public class MyModel {

    private final SharedPreferences sharedPreferences;
    private List<String> mData;

    public MyModel(Context context){
        this.sharedPreferences=context.getSharedPreferences(
                "Einkaufslisten-Prefs-1",
                Context.MODE_PRIVATE
        );
    }

    public String getUsername(){
        return sharedPreferences.getString("username",null);
    }

    public void saveUsername(String newUsername){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",newUsername);
        editor.apply();
    }

    public int getItemCount(){
        return mData.size();
    }

    public void setItems(List<String> items){
        this.mData = items;
    }

    public String getItemAt(int position){
        return mData.get(position);
    }

}
