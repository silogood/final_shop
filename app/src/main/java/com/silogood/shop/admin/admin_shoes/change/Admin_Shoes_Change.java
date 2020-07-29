package com.silogood.shop.admin.admin_shoes.change;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.admin.admin_clothes.change.Admin_Clothes_Change;

public class Admin_Shoes_Change extends AppCompatActivity {
    private Button AdminShoesChangeProductBtn;
    private Button AdminShoesChangeLabelBtn;
    private Button AdminShoesChangeBackBtn;
    private String TAG = "ADMIN_SHOES_CHANGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_shoes_change);
        init_view();
    }

    private void init_view() {
        AdminShoesChangeProductBtn = (Button) findViewById(R.id.admin_shoes_change_product_btn);
        AdminShoesChangeProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Shoes_Change.this , Admin_Shoes_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminShoesChangeLabelBtn = (Button) findViewById(R.id.admin_shoes_change_label_btn);
        AdminShoesChangeLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Shoes_Change.this , Admin_Shoes_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminShoesChangeBackBtn = (Button) findViewById(R.id.admin_shoes_change_back_btn);
        AdminShoesChangeBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"BACK CLICK");

                finish();
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}