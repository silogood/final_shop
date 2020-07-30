package com.silogood.shop.admin.admin_acc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;


public class Admin_Acc extends AppCompatActivity {
    private Button AdminAccInputBtn;
    private Button AdminAccChangeBtn;
    private Button AdminAccPrintAllBtn;
    private String TAG = "ADMIN_ACC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acc);
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