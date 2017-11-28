package com.eliamyro.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Elias Myronidis on 28/11/17.
 * LinkedIn: https://www.linkedin.com/in/eliasmyronidis/
 */

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<Product> getAll();


    @Query("SELECT * FROM product WHERE name LIKE :name LIMIT 1")
    Product findByname(String name);


    @Insert
    void insertAll(List<Product> products);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
