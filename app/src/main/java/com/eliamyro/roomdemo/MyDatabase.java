package com.eliamyro.roomdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Elias Myronidis on 28/11/17.
 * LinkedIn: https://www.linkedin.com/in/eliasmyronidis/
 */

@Database(entities = {Product.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase{

    public abstract ProductDao productDao();
}
