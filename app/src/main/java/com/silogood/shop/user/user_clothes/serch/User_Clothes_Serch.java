package com.silogood.shop.user.user_clothes.serch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_acc.serch.User_Acc_Serch;

public class User_Clothes_Serch extends AppCompatActivity {
    private Button UserClothesSerchProductBtn;
    private Button UserClothesSerchLabelBtn;
    private String TAG = "User_Clothes_Serch ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_clothes_serch);
        init_view();
    }

    private void init_view() {
        UserClothesSerchProductBtn = (Button) findViewById(R.id.user_clothes_serch_product_btn);
        UserClothesSerchProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Clothes_Serch.this , User_Clothes_Serch.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserClothesSerchLabelBtn = (Button) findViewById(R.id.user_clothes_serch_label_btn);
        UserClothesSerchLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Clothes_Serch.this , User_Clothes_Serch.class);
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