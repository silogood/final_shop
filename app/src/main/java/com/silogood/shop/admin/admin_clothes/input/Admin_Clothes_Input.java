package com.silogood.shop.admin.admin_clothes.input;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.admin.admin_acc.input.Admin_Acc_Input;

public class Admin_Clothes_Input extends AppCompatActivity {
    private Button AdminClothesInputProductBtn;
    private Button AdminClothesInputLabelBtn;
    private Button AdminClothesInputeBackBtn;
    private String TAG = "ADMIN_CLOTHES_INPUT ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_clothes_input);
        init_view();
    }

    private void init_view() {
        AdminClothesInputProductBtn = (Button) findViewById(R.id.admin_clothes_input_product_btn);
        AdminClothesInputProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Clothes_Input.this , Admin_Clothes_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminClothesInputLabelBtn = (Button) findViewById(R.id.admin_clothes_input_label_btn);
        AdminClothesInputLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Clothes_Input.this , Admin_Clothes_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminClothesInputeBackBtn = (Button) findViewById(R.id.admin_clothes_input_back_btn);
        AdminClothesInputeBackBtn.setOnClickListener(new View.OnClickListener() {
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