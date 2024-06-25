package com.example.einkaufsliste4.model;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import java.util.List;

public class MyModel {

    private final SharedPreferences sharedPreferences;
    private AppDatabase db;

    public MyModel(Context context){
        this.sharedPreferences=context.getSharedPreferences(
                "Einkaufslisten-Prefs-1",
                Context.MODE_PRIVATE
        );

        db = Room.databaseBuilder(context,
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .build();

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
        return db.shoppingItemDao().getAll().size();
    }

    public void setItems(List<String> items){
        ShoppingItemDao shoppingItemDao = db.shoppingItemDao();

        for(int i = 0; i<items.size(); i++){
            shoppingItemDao.insertOne(new ShoppingItem(items.get(i),i));
        }
    }

    public String getItemAt(int position){
        ShoppingItemDao shoppingItemDao = db.shoppingItemDao();
        ShoppingItem shoppingItem = shoppingItemDao.findByPosition(position);

        return shoppingItem.itemName;
    }

}
