package com.silogood.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.user.user_acc.User_Acc;
import com.silogood.shop.user.user_clothes.User_Clothes;
import com.silogood.shop.user.user_shoes.User_Shoes;

public class ItemViewByUser extends AppCompatActivity {

    private Button UserClothesBtn;
    private Button UserShoesBtn;
    private Button UserAccBtn;
    private String TAG = "ItemViewByUser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_item_view);
        init_view();
    }

    private void init_view()
    {
        UserClothesBtn = (Button) findViewById(R.id.user_clothes_btn);
        UserClothesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"CLOTHES CLICK");

                Intent intent = new Intent(ItemViewByUser.this , User_Clothes.class);
                startActivity(intent);

                //TODO goto mainactivity
                // finish();

            }
        });

        UserShoesBtn = (Button) findViewById(R.id.user_shoes_btn);
        UserShoesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"SHOES CLICK");

                Intent intent = new Intent(ItemViewByUser.this , User_Shoes.class);
                startActivity(intent);

                //TODO goto mainactivity
                // finish();
            }
        });

        UserAccBtn = (Button) findViewById(R.id.user_acc_btn);
        UserAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ACC CLICK");

                Intent intent = new Intent(ItemViewByUser.this , User_Acc.class);
                startActivity(intent);

                //TODO goto mainactivity
                // finish();
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
