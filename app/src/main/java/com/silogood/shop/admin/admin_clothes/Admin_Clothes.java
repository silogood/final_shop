package com.silogood.shop.admin.admin_clothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.admin.admin_clothes.change.Admin_Clothes_Change;
import com.silogood.shop.admin.admin_clothes.input.Admin_Clothes_Input;
import com.silogood.shop.admin.admin_clothes.print.Admin_Clothes_Print;

public class Admin_Clothes extends AppCompatActivity {
    private Button AdminClothesInputBtn;
    private Button AdminClothesChangeBtn;
    private Button AdminClothesPrintAllBtn;
    private String TAG = "ADMIN_CLOTHES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_clothes);
        init_view();
    }

    private void init_view() {

        AdminClothesInputBtn = (Button) findViewById(R.id.admin_clothes_inventory_input_btn);
        AdminClothesInputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN CLOTHES CLICK");

                Intent intent = new Intent(Admin_Clothes.this , Admin_Clothes_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminClothesChangeBtn = (Button) findViewById(R.id.admin_clothes_inventory_change_btn);
        AdminClothesChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN CLOTHES CLICK");

                Intent intent = new Intent(Admin_Clothes.this , Admin_Clothes_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminClothesPrintAllBtn = (Button) findViewById(R.id.admin_clothes_inventory_print);
        AdminClothesPrintAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN CLOTHES CLICK");

                Intent intent = new Intent(Admin_Clothes.this , Admin_Clothes_Print.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        }); // Admn_Clothes


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