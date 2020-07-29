package com.silogood.shop.admin.admin_acc.input;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.admin.admin_acc.change.Admin_Acc_Change;

public class Admin_Acc_Input extends AppCompatActivity {
    private Button AdminAccInputProductBtn;
    private Button AdminAccInputLabelBtn;
    private Button AdminAccInputBackBtn;
    private String TAG = "ADMIN_ACC_INPUT ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acc_input);
        init_view();
    }

    private void init_view() {
        AdminAccInputProductBtn = (Button) findViewById(R.id.admin_acc_input_product_btn);
        AdminAccInputProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Acc_Input.this , Admin_Acc_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminAccInputLabelBtn = (Button) findViewById(R.id.admin_acc_input_label_btn);
        AdminAccInputLabelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"USER ACC CLICK");

                Intent intent = new Intent(Admin_Acc_Input.this , Admin_Acc_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminAccInputBackBtn = (Button) findViewById(R.id.admin_acc_input_back_btn);
        AdminAccInputBackBtn.setOnClickListener(new View.OnClickListener() {
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