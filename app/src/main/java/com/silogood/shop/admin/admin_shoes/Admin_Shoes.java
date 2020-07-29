package com.silogood.shop.admin.admin_shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.admin.admin_shoes.change.Admin_Shoes_Change;
import com.silogood.shop.admin.admin_shoes.input.Admin_Shoes_Input;
import com.silogood.shop.admin.admin_shoes.print.Admin_Shoes_Print;

public class Admin_Shoes extends AppCompatActivity {
    private Button AdminShoesInputBtn;
    private Button AdminShoesChangeBtn;
    private Button AdminShoesPrintAllBtn;
    private String TAG = "ADMIN SHOES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_shoes);
        init_view();
    }

    private void init_view() {

        AdminShoesInputBtn = (Button) findViewById(R.id.admin_shoes_inventory_input_btn);
        AdminShoesInputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN SHOES CLICK");

                Intent intent = new Intent(Admin_Shoes.this , Admin_Shoes_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminShoesChangeBtn = (Button) findViewById(R.id.admin_shoes_inventory_change_btn);
        AdminShoesChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN SHOES CLICK");

                Intent intent = new Intent(Admin_Shoes.this , Admin_Shoes_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminShoesPrintAllBtn = (Button) findViewById(R.id.admin_shoes_inventory_print);
        AdminShoesPrintAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN CLOTHES CLICK");

                Intent intent = new Intent(Admin_Shoes.this , Admin_Shoes_Print.class);
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