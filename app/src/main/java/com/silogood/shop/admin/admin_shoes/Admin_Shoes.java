package com.silogood.shop.admin.admin_shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;

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