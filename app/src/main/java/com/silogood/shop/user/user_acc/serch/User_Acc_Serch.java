package com.silogood.shop.user.user_acc.serch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_acc.User_Acc;

public class User_Acc_Serch extends AppCompatActivity {
    private Button UserAccSerchProductBtn;
    private Button UserAccSerchLabelBtn;
    private String TAG = "User_Acc_Serch ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_acc_serch);
        init_view();
    }

    private void init_view() {
        UserAccSerchProductBtn = (Button) findViewById(R.id.user_acc_serch_product_btn);
        UserAccSerchProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Acc_Serch.this , User_Acc_Serch.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        UserAccSerchLabelBtn = (Button) findViewById(R.id.user_acc_serch_label_btn);
        UserAccSerchLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(User_Acc_Serch.this , User_Acc_Serch.class);
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