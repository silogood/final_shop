package com.silogood.shop.user.user_acc.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_acc.serch.User_Acc_Serch;

public class User_Acc_Order extends AppCompatActivity {
    private Button UserAccOrderProductBtn;
    private Button UserAccOrderLabelBtn;
    private String TAG = "User_Acc_Order ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_acc_order);
        init_view();
    }

    private void init_view() {
        UserAccOrderProductBtn = (Button) findViewById(R.id.user_acc_order_product_btn);
        UserAccOrderProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Acc_Order.this , User_Acc_Order.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserAccOrderLabelBtn = (Button) findViewById(R.id.user_acc_order_label_btn);
        UserAccOrderLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Acc_Order.this , User_Acc_Order.class);
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
