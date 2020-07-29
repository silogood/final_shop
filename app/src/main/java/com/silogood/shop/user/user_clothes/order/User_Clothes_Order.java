package com.silogood.shop.user.user_clothes.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_acc.order.User_Acc_Order;

public class User_Clothes_Order extends AppCompatActivity {
    private Button UserClothesOrderProductBtn;
    private Button UserClothesOrderLabelBtn;
    private String TAG = "User_Clothes_Order ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_clothes_order);
        init_view();
    }

    private void init_view() {
        UserClothesOrderProductBtn = (Button) findViewById(R.id.user_clothes_order_product_btn);
        UserClothesOrderProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Clothes_Order.this , User_Clothes_Order.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserClothesOrderLabelBtn = (Button) findViewById(R.id.user_clothes_order_product_btn);
        UserClothesOrderLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Clothes_Order.this , User_Clothes_Order.class);
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