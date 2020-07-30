package com.silogood.shop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.silogood.shop.databasemanager.AccNote;
import com.silogood.shop.databasemanager.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private Button userBtn;
    private Button adminBtn;
    private ActionBar mActionbar;

    private String TAG = "MainActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;

        init_view();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        //insert test
 /*       databaseHelper.setInsertNote("clothes","지방시 후드", "1", 10);
        databaseHelper.setInsertNote("clothes","버버리 후드", "2", 40);
        databaseHelper.setInsertNote("clothes","코트 1", "3", 19);
        databaseHelper.setInsertNote("clothes","코트 2", "4", 11);
        databaseHelper.setInsertNote("clothes","코트 3", "5", 75);
        databaseHelper.setInsertNote("clothes","발망 티 ", "6", 35);
        databaseHelper.setInsertNote("shoes","구찌 스니커즈", "7", 62);
        databaseHelper.setInsertNote("shoes","커먼 프로젝트 스니커즈", "8", 25);
        databaseHelper.setInsertNote("acc","스냅 백", "9", 24);
        databaseHelper.setInsertNote("acc","크로스 백", "10", 32);
*/
        //get db
       /* databaseHelper.getAccNode(1);
        databaseHelper.getClothesNote(0);
        databaseHelper.getShoesNote(1);*/

        //update..

        //delete..



    }


    private void init_view()
    {
        userBtn = (Button) findViewById(R.id.user_btn);
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG,"USER CLICK");

                Intent intent = new Intent(MainActivity.this , ItemViewByUser.class);
                startActivity(intent);

               //TODO goto mainactivity
                // finish();

            }
        });
        adminBtn = (Button) findViewById(R.id.admin_btn);
        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG,"ADMIN CLICK");

                Intent intent = new Intent(MainActivity.this , ItemViewByAdmin.class);
                startActivity(intent);

                //TODO goto mainactivity
                // finish();
            }
        });


        mActionbar = getSupportActionBar();
        mActionbar.setTitle(R.string.app_label);



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
