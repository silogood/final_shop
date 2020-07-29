package com.silogood.shop.admin.admin_acc.change;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.user.user_acc.order.User_Acc_Order;

public class Admin_Acc_Change extends AppCompatActivity {
    private Button AdminAccChangeProductBtn;
    private Button AdminAccChangeLabelBtn;
    private Button AdminAccChangeBackBtn;
    private String TAG = "ADMIN_ACC_CHANGE ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acc_change);
        init_view();
    }

    private void init_view() {
        AdminAccChangeProductBtn = (Button) findViewById(R.id.admin_acc_change_product_btn);
        AdminAccChangeProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Acc_Change.this , Admin_Acc_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminAccChangeLabelBtn = (Button) findViewById(R.id.admin_acc_change_label_btn);
        AdminAccChangeLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Acc_Change.this , Admin_Acc_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminAccChangeBackBtn = (Button) findViewById(R.id.admin_acc_change_back_btn);
        AdminAccChangeBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"BACK CLICK");

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