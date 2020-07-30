package com.silogood.shop.user.user_clothes;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.silogood.shop.MainActivity;
import com.silogood.shop.R;
import com.silogood.shop.databasemanager.ClothesNote;
import com.silogood.shop.databasemanager.Clothes_NotesAdapter;
import com.silogood.shop.databasemanager.DatabaseHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User_Clothes extends AppCompatActivity {

    private String TAG = "USER_CLOTHES";

    private EditText mBqtEditText ;
    private Button mPurchaceBtn;
    private Button mHistoryBtn;
    private ListView mListView;
    private DatabaseHelper mDatabaseHelper;
    private ClothesNote selected_item;

    private ArrayList<ClothesNote> mClothes_list;

    private ArrayList<ClothesNote> mPurchaed_list;

    private Clothes_NotesAdapter mClothes_notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_clothes);

        mDatabaseHelper= new DatabaseHelper(this);
        mClothes_list = new ArrayList<ClothesNote>();
        mPurchaed_list = new ArrayList<ClothesNote>();
        ////
        init_view();
    }

    private void init_view() {



        mClothes_notesAdapter = new Clothes_NotesAdapter(this,R.layout.custom_listview_item, mClothes_list);


        mPurchaceBtn = (Button)findViewById(R.id.user_clothes_purchace_btn);
        mPurchaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int parse = Integer.parseInt(mBqtEditText.getText().toString());
                long now = System.currentTimeMillis();
                Date mDate = new Date(now);

                if (selected_item != null) {
                    if (selected_item.getBqt() - parse < 0) {
                        Toast.makeText(User_Clothes.this, "남은 수량이 모자랍니다! ", Toast.LENGTH_SHORT).show();
                    } else {
                        ClothesNote cn = new ClothesNote(selected_item.getName(), selected_item.getCode(), selected_item.getBqt() - parse, mDate.toString());
                        mDatabaseHelper.updateClothesNoteBycode(cn);

                        renew_list();
                        mClothes_notesAdapter.notifyDataSetChanged();

                        // add purchaced list
                        ClothesNote purchaced_cn = new ClothesNote(selected_item.getName(), selected_item.getCode(), parse, mDate.toString());
                        mPurchaed_list.add(purchaced_cn);
                    }
                }
            }
        });

        mHistoryBtn = (Button)findViewById(R.id.user_clothes_go_history_btn);
        mHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(User_Clothes.this,History.class);
                intent.putExtra("purchaced",mPurchaed_list);

                startActivity(intent);

            }
        });

        mBqtEditText = (EditText)findViewById(R.id.user_clothes_edittxt_1);

        mListView = (ListView)findViewById(R.id.user_clothes_listview);
        mListView.setAdapter(mClothes_notesAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selected_item = null ;
            selected_item = (ClothesNote)parent.getItemAtPosition(position);
                Toast.makeText(User_Clothes.this, "selected item : " + selected_item.getName() , Toast.LENGTH_SHORT).show();

            }
        });

        renew_list();
    }

    private void renew_list(){

        mClothes_list.clear();


        List<ClothesNote> a = mDatabaseHelper.getAllClothesNotes();
        int i;
        for (i = 0; i < a.size(); i++){
            mClothes_list.add(a.get(i));
        }


        mClothes_notesAdapter.notifyDataSetChanged();
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
