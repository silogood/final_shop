package com.silogood.shop.user.user_shoes.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_clothes.order.User_Clothes_Order;

public class User_Shoes_Order extends AppCompatActivity {
    private Button UserShoesOrderProductBtn;
    private Button UserShoesOrderLabelBtn;
    private String TAG = "User_Shoes_Order ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_shoes_order);
        init_view();
    }

    private void init_view() {
        UserShoesOrderProductBtn = (Button) findViewById(R.id.user_shoes_order_product_btn);
        UserShoesOrderProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Shoes_Order.this , User_Shoes_Order.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserShoesOrderLabelBtn = (Button) findViewById(R.id.user_shoes_order_label_btn);
        UserShoesOrderLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Shoes_Order.this , User_Shoes_Order.class);
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