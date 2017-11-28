package com.eliamyro.roomdemo;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Elias Myronidis on 28/11/17.
 * LinkedIn: https://www.linkedin.com/in/eliasmyronidis/
 */

public class RoomApp extends Application {

    private MyDatabase database;
    private static final String DATABASE_NAME = "products_db";
    public static RoomApp INSTANCE;

    public static RoomApp get(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, DATABASE_NAME)
                .build();

        INSTANCE = this;
    }

    public MyDatabase getDatabase(){
        return database;
    }
}
