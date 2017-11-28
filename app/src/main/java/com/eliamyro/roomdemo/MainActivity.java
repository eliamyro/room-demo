package com.eliamyro.roomdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView productsRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsRv = (RecyclerView) findViewById(R.id.products_rv);

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Product> products = RoomApp.get().getDatabase().productDao().getAll();

                if (products.isEmpty()){
                    retrieveProducts();
                } else {
                    populateProducts(products);
                }
            }
        }).start();
    }

    private void retrieveProducts(){
        List<Product> list = new ArrayList<>();

        for (int i=0; i<100000; i++){
            Product product = new Product();
            product.setName(getString(R.string.name_format, String.valueOf(i)));
            product.setImageUrl("http://lorempixel.com/500/500/technics/" + i);
            list.add(product);

            Log.d("TAG", product.getName());
        }

        // Insert list to database
        RoomApp.get().getDatabase().productDao().insertAll(list);

        populateProducts(list);
    }

    private void populateProducts(final List<Product> products){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                productsRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                productsRv.setAdapter(new ProductAdapter(products));
            }
        });
    }
}
