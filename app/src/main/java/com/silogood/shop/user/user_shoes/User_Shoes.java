package com.silogood.shop.user.user_shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_clothes.User_Clothes;


public class User_Shoes extends AppCompatActivity {
    private Button UserShoesSerchBtn;
    private Button UserShoesOrderBtn;
    private String TAG = "User_Shoes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_shoes);
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
