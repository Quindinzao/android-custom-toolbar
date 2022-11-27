package com.quindinzao.productcontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> productList;
    private OnClick onClick;

    public ProductAdapter(List<Product> productList, OnClick onClick) {
        this.productList = productList;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.txtProductName.setText(product.getName());
        holder.txtInventory.setText("Inventory: " + String.valueOf(product.getInventory()));
        holder.txtPrice.setText("R$" + String.valueOf(product.getPrice()));
        holder.itemView.setOnClickListener(v -> onClick.onCLickListener(product));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public interface OnClick {
        void onCLickListener(Product product);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductName, txtInventory, txtPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtInventory = itemView.findViewById(R.id.txtInventory);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}
