package com.silogood.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.admin.admin_acc.Admin_Acc;
import com.silogood.shop.admin.admin_clothes.Admin_Clothes;
import com.silogood.shop.admin.admin_shoes.Admin_Shoes;

public class ItemViewByAdmin extends AppCompatActivity {

    private Button AdminClothesBtn;
    private Button AdminShoesBtn;
    private Button AdminAccBtn;
    private Button AdminInventoryAllPrintBtn;
    private Button AdminBackBtn;
    private Button AdminExitBtn;
    private String TAG = "ITEMVIEWBYADMIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_item_view);
        init_view();
    }

    private void init_view()
    {
        AdminClothesBtn = (Button) findViewById(R.id.admin_clothes_btn);
        AdminClothesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"CLOTHES CLICK");

                Intent intent = new Intent(ItemViewByAdmin.this , Admin_Clothes.class);
                startActivity(intent);

                //TODO goto mainactivity
                // finish();

            }
        });

        AdminShoesBtn = (Button) findViewById(R.id.admin_shoes_btn);
        AdminShoesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"SHOES CLICK");

                Intent intent = new Intent(ItemViewByAdmin.this , Admin_Shoes.class);
                startActivity(intent);

                //TODO goto mainactivity
                // finish();
            }
        });

        AdminAccBtn = (Button) findViewById(R.id.admin_acc_btn);
        AdminAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ACC CLICK");

                Intent intent = new Intent(ItemViewByAdmin.this , Admin_Acc.class);
                startActivity(intent);

                //TODO goto mainactivity
                // finish();
            }
        });

        AdminInventoryAllPrintBtn = (Button) findViewById(R.id.admin_inventory_all_btn);
        AdminInventoryAllPrintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"SHOES CLICK");

                Intent intent = new Intent(ItemViewByAdmin.this , ItemViewByAdmin.class);
                startActivity(intent);

                //TODO goto mainactivity
                // finish();
            }
        });

        AdminBackBtn = (Button) findViewById(R.id.admin_back_btn);
        AdminBackBtn.setOnClickListener(new View.OnClickListener() {
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
