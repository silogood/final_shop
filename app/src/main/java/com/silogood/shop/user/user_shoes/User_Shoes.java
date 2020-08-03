package com.silogood.shop.user.user_shoes;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.silogood.shop.R;
import com.silogood.shop.databasemanager.ShoesNote;
import com.silogood.shop.databasemanager.Shoes_NotesAdapter;
import com.silogood.shop.databasemanager.DatabaseHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User_Shoes extends AppCompatActivity {
    
    private String TAG = "USER SHOES";

    private EditText mBqtEditText ;
    private Button mPurchaceBtn;
    private Button mHistoryBtn;
    private ListView mListView;
    private DatabaseHelper mDatabaseHelper;
    private ShoesNote selected_item;

    private ArrayList<ShoesNote> mShoes_list;

    private ArrayList<ShoesNote> mPurchaed_list;

    private Shoes_NotesAdapter mShoes_NotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_shoes);

        mDatabaseHelper= new DatabaseHelper(this);
        mShoes_list = new ArrayList<ShoesNote>();
        mPurchaed_list = new ArrayList<ShoesNote>();
        ////
        init_view();
    }

    private void init_view() {



        mShoes_NotesAdapter = new Shoes_NotesAdapter(this,R.layout.custom_listview_item, mShoes_list);


        mPurchaceBtn = (Button)findViewById(R.id.user_shoes_purchace_btn);
        mPurchaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int parse = Integer.parseInt(mBqtEditText.getText().toString());
                long now = System.currentTimeMillis();
                Date mDate = new Date(now);

                if (selected_item != null) {
                    if (selected_item.getBqt() - parse < 0) {
                        Toast.makeText(User_Shoes.this, "남은 수량이 모자랍니다! ", Toast.LENGTH_SHORT).show();
                    } else {
                        ShoesNote cn = new ShoesNote(selected_item.getName(), selected_item.getCode(), selected_item.getBqt() - parse, mDate.toString());
                        mDatabaseHelper.updateShoesNoteBycode(cn);

                        renew_list();
                        mShoes_NotesAdapter.notifyDataSetChanged();

                        // add purchaced list
                        ShoesNote purchaced_cn = new ShoesNote(selected_item.getName(), selected_item.getCode(), parse, mDate.toString());
                        mPurchaed_list.add(purchaced_cn);
                    }
                }
            }
        });

        mHistoryBtn = (Button)findViewById(R.id.user_shoes_go_history_btn);
        mHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPurchaed_list.size() != 0) {
                    Intent intent = new Intent(User_Shoes.this, User_Shoes_History.class);
                    intent.putExtra("purchaced", mPurchaed_list);

                    startActivity(intent);
                }else{
                    Toast.makeText(User_Shoes.this, "구매 목록이 없습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mBqtEditText = (EditText)findViewById(R.id.user_shoes_edittxt_1);

        mListView = (ListView)findViewById(R.id.user_shoes_listview);
        mListView.setAdapter(mShoes_NotesAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_item = null ;
                selected_item = (ShoesNote)parent.getItemAtPosition(position);
                Toast.makeText(User_Shoes.this, "selected item : " + selected_item.getName() , Toast.LENGTH_SHORT).show();

            }
        });

        renew_list();
    }

    private void renew_list(){

        mShoes_list.clear();


        List<ShoesNote> a = mDatabaseHelper.getAllShoesNotes();
        int i;
        for (i = 0; i < a.size(); i++){
            mShoes_list.add(a.get(i));
        }


        mShoes_NotesAdapter.notifyDataSetChanged();
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
