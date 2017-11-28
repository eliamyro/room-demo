package com.eliamyro.roomdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Elias Myronidis on 28/11/17.
 * LinkedIn: https://www.linkedin.com/in/eliasmyronidis/
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<Product> products;

    public ProductAdapter(List<Product> products){
        this.products = products;
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        holder.nameTv.setText(products.get(position).getName());
        holder.imageTv.setText(products.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {

        private TextView nameTv;
        private TextView imageTv;

        public ProductHolder(View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.name_tv);
            imageTv = itemView.findViewById(R.id.image_tv);
        }
    }
}
