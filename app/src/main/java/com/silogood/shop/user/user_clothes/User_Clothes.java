package com.silogood.shop.user.user_clothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.ItemViewByUser;
import com.silogood.shop.R;
import com.silogood.shop.user.user_acc.User_Acc;
import com.silogood.shop.user.user_acc.serch.User_Acc_Serch;
import com.silogood.shop.user.user_clothes.order.User_Clothes_Order;
import com.silogood.shop.user.user_clothes.serch.User_Clothes_Serch;

public class User_Clothes extends AppCompatActivity {
    private Button UserClothesSerchBtn;
    private Button UserClothesOrderBtn;
    private String TAG = "User_Clothes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_clothes);

        ////
        init_view();
    }

    private void init_view() {
        UserClothesOrderBtn = (Button) findViewById(R.id.user_clothes_order_btn);
        UserClothesOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER CLOTHES CLICK");

                Intent intent = new Intent(User_Clothes.this , User_Clothes_Order.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserClothesSerchBtn = (Button) findViewById(R.id.user_clothes_serch_btn);
        UserClothesSerchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Clothes.this , User_Clothes_Serch.class);
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
