package com.example.apptest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerOrSaloon extends AppCompatActivity {
    private Button btn_owner, btn_customer;

    public void init() {

        btn_owner = (Button) findViewById(R.id.ownerButton);
        btn_customer = (Button) findViewById(R.id.customerButton);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_or_saloon);
        init();

        btn_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOwnerMenuScreen();
            }
        });

        btn_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomerMenuScreen();
            }
        });






    }

    public void openOwnerMenuScreen() {
        Intent intent = new Intent(this, OwnerMenu.class);
        startActivity(intent);
    }

    public void openCustomerMenuScreen() {
        Intent intent = new Intent(this, CustomerMenu.class);
        startActivity(intent);
    }
}