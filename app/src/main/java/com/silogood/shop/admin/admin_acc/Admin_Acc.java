package com.silogood.shop.admin.admin_acc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.R;
import com.silogood.shop.admin.admin_acc.change.Admin_Acc_Change;
import com.silogood.shop.admin.admin_acc.input.Admin_Acc_Input;
import com.silogood.shop.admin.admin_acc.print.Admin_Acc_Print;

public class Admin_Acc extends AppCompatActivity {
    private Button AdminAccInputBtn;
    private Button AdminAccChangeBtn;
    private Button AdminAccPrintAllBtn;
    private String TAG = "ADMIN_ACC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acc);
        init_view();

    }

    private void init_view() {
        AdminAccInputBtn = (Button) findViewById(R.id.admin_acc_inventory_input_btn);
        AdminAccInputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN ACC CLICK");

                Intent intent = new Intent(Admin_Acc.this , Admin_Acc_Input.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminAccChangeBtn = (Button) findViewById(R.id.admin_acc_inventory_change_btn);
        AdminAccChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN ACC CLICK");

                Intent intent = new Intent(Admin_Acc.this , Admin_Acc_Change.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        });

        AdminAccPrintAllBtn = (Button) findViewById(R.id.admin_acc_inventory_print);
        AdminAccPrintAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ADMIN CLOTHES CLICK");

                Intent intent = new Intent(Admin_Acc.this , Admin_Acc_Print.class);
                startActivity(intent);

                //TODO goto mainactivity
                finish();

            }
        }); // Admn_Acc
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