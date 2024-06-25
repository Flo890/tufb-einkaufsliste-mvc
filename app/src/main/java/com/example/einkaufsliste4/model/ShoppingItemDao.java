package com.example.einkaufsliste4.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShoppingItemDao {

    @Query("SELECT * FROM shoppingitem")
    List<ShoppingItem> getAll();

    @Query("SELECT * FROM shoppingitem WHERE id IN (:itemIds)")
    List<ShoppingItem> loadAllByIds(int[] itemIds);

    @Query("SELECT * FROM shoppingitem WHERE item_name LIKE :itemName LIMIT 1")
    ShoppingItem findByName(String itemName);

    @Query("SELECT * FROM shoppingitem WHERE position = :position")
    ShoppingItem findByPosition(int position);

    @Insert
    void insertOne(ShoppingItem item);

    @Delete
    void delete(ShoppingItem user);

}
