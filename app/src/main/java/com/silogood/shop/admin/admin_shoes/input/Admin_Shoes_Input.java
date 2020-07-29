package com.silogood.shop.admin.admin_shoes.input;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.admin.admin_clothes.input.Admin_Clothes_Input;

public class Admin_Shoes_Input extends AppCompatActivity {
    private Button AdminShoesInputProductBtn;
    private Button AdminShoesInputLabelBtn;
    private Button AdminShoesInputBackBtn;
    private String TAG = "ADMIN_SHOES_INPUT ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_shoes_input);
        init_view();
    }

    private void init_view() {
        AdminShoesInputProductBtn = (Button) findViewById(R.id.admin_shoes_input_product_btn);
        AdminShoesInputProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Shoes_Input.this , Admin_Shoes_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminShoesInputLabelBtn = (Button) findViewById(R.id.admin_shoes_input_label_btn);
        AdminShoesInputLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Shoes_Input.this , Admin_Shoes_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminShoesInputBackBtn = (Button) findViewById(R.id.admin_shoes_input_back_btn);
        AdminShoesInputBackBtn.setOnClickListener(new View.OnClickListener() {
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