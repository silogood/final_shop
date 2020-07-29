package com.silogood.shop.user.user_acc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_acc.order.User_Acc_Order;
import com.silogood.shop.user.user_acc.serch.User_Acc_Serch;
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
        UserAccOrderBtn = (Button) findViewById(R.id.user_acc_order_btn);
        UserAccOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Acc.this , User_Acc_Order.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserAccSerchBtn = (Button) findViewById(R.id.user_acc_serch_btn);
        UserAccSerchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Acc.this , User_Acc_Serch.class);
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
