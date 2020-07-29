package com.silogood.shop.user.user_shoes.serch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_clothes.serch.User_Clothes_Serch;

public class User_Shoes_Serch extends AppCompatActivity {
    private Button UserShoesSerchProductBtn;
    private Button UserShoesSerchLabelBtn;
    private String TAG = "User_Shoes_Serch ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_shoes_serch);
        init_view();
    }

    private void init_view() {
        UserShoesSerchProductBtn = (Button) findViewById(R.id.user_shoes_serch_product_btn);
        UserShoesSerchProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Shoes_Serch.this , User_Shoes_Serch.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserShoesSerchLabelBtn = (Button) findViewById(R.id.user_shoes_serch_label_btn);
        UserShoesSerchLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Shoes_Serch.this , User_Shoes_Serch.class);
                startActivity(intent);

                //TODO goto mainactivity
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