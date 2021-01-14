package com.example.apptest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OwnerMenu extends AppCompatActivity {
    private Button btn_mySaloon, btn_Owner_Appointments, btn_ownerPrices;


    public void init(){
        btn_mySaloon = (Button) findViewById(R.id.btnMySaloon);
        btn_Owner_Appointments = (Button) findViewById(R.id.btnOwnerAppointments);
        btn_ownerPrices = (Button) findViewById(R.id.ownerPrices);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_menu);
        init();

        btn_mySaloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_ownerSaloonActivity();
            }
        });

        btn_Owner_Appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_ownerAppointmentsActivity();
            }
        });

        btn_ownerPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_ownerPricesActivity();
            }
        });


    }

    public void open_ownerSaloonActivity(){
        Intent intent = new Intent(this, ownerSaloon.class);
        startActivity(intent);
    }
    public void open_ownerAppointmentsActivity(){
        Intent intent = new Intent(this, OwnerAppoitnments.class);
        startActivity(intent);
    }

    public void open_ownerPricesActivity(){
    Intent intent = new Intent(this, ownerPrices.class);
    startActivity(intent);
    }

}