package com.example.einkaufsliste4.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ShoppingItem {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "item_name")
    public String itemName;

    @ColumnInfo(name = "in_cart")
    public boolean inCart;

    @ColumnInfo(name = "position")
    public int position;

    public ShoppingItem(){}

    public ShoppingItem(String name, int position){
        this.id = position;
        this.itemName = name;
        this.position = position;
    }

}
