package com.quindinzao.productcontrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.tsuryo.swipeablerv.SwipeLeftRightCallback;
import com.tsuryo.swipeablerv.SwipeableRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.OnClick {

    private final List<Product> productList = new ArrayList<>();
    private SwipeableRecyclerView rvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(Color.parseColor("#FFFBF3"));

        rvProduct = findViewById(R.id.rvProducts);

        loadList();
        configRecyclerView();
    }

    private void configRecyclerView() {
        rvProduct.setLayoutManager(new LinearLayoutManager(this));
        rvProduct.setHasFixedSize(true);
        ProductAdapter productAdapter = new ProductAdapter(productList, this);
        rvProduct.setAdapter(productAdapter);

        rvProduct.setListener(new SwipeLeftRightCallback.Listener() {
            @Override
            public void onSwipedLeft(int position) {
                productList.remove(position);
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onSwipedRight(int position) {
                productList.remove(position);
                productAdapter.notifyDataSetChanged();
            }
        });
    }

    private void loadList() {
        Product product1 = new Product();
        product1.setName("Macbook 2022 - M1 - 16 GB RAM");
        product1.setInventory(45);
        product1.setPrice(2600.00);

        Product product2 = new Product();
        product2.setName("Caixa de Som C3 Tech");
        product2.setInventory(15);
        product2.setPrice(149.99);

        Product product3 = new Product();
        product3.setName("Microfone Blue yeti");
        product3.setInventory(38);
        product3.setPrice(1699.99);

        Product product4 = new Product();
        product4.setName("Gabinete NZXT H440");
        product4.setInventory(15);
        product4.setPrice(979.99);

        Product product5 = new Product();
        product5.setName("Placa Mãe Asus");
        product5.setInventory(60);
        product5.setPrice(1199.99);

        Product product6 = new Product();
        product6.setName("Memória Corsair 16GB");
        product6.setInventory(44);
        product6.setPrice(599.99);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
    }

    @Override
    public void onCLickListener(Product product) {
        Toast.makeText(this, product.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idMenu = item.getItemId();

        if (idMenu == R.id.menu_about) {
            Toast.makeText(this, R.string.about, Toast.LENGTH_SHORT).show();
        } else if (idMenu == R.id.menu_add) {
            Toast.makeText(this, R.string.add, Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}