package com.silogood.shop.user.user_shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_clothes.User_Clothes;
import com.silogood.shop.user.user_clothes.serch.User_Clothes_Serch;
import com.silogood.shop.user.user_shoes.order.User_Shoes_Order;
import com.silogood.shop.user.user_shoes.serch.User_Shoes_Serch;

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
        UserShoesOrderBtn = (Button) findViewById(R.id.user_shoes_order_btn);
        UserShoesOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER SHOES CLICK");

                Intent intent = new Intent(User_Shoes.this , User_Shoes_Order.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserShoesSerchBtn = (Button) findViewById(R.id.user_shoes_serch_btn);
        UserShoesSerchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Shoes.this , User_Shoes_Serch.class);
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
