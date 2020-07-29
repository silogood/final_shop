package com.silogood.shop.admin.admin_clothes.change;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.admin.admin_acc.change.Admin_Acc_Change;

public class Admin_Clothes_Change extends AppCompatActivity {
    private Button AdminClothesChangeProductBtn;
    private Button AdminClothesChangeLabelBtn;
    private Button AdminClothesChangeBackBtn;
    private String TAG = "ADMIN_CLOTHES_CHANGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_clothes_change);
        init_view();
    }

    private void init_view() {
        AdminClothesChangeProductBtn = (Button) findViewById(R.id.admin_clothes_change_product_btn);
        AdminClothesChangeProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Clothes_Change.this , Admin_Clothes_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminClothesChangeLabelBtn = (Button) findViewById(R.id.admin_clothes_change_label_btn);
        AdminClothesChangeLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Clothes_Change.this , Admin_Clothes_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminClothesChangeBackBtn = (Button) findViewById(R.id.admin_clothes_change_back_btn);
        AdminClothesChangeBackBtn.setOnClickListener(new View.OnClickListener() {
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
