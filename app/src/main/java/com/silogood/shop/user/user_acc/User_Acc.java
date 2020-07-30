package com.silogood.shop.user.user_acc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;

import com.silogood.shop.user.user_shoes.User_Shoes;

public class User_Acc extends AppCompatActivity {
    private Button UserAccSerchBtn;
    private Button UserAccOrderBtn;
    private String TAG = "User_Acc ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_acc);
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
