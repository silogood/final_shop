package com.silogood.shop.user.user_acc;

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
import com.silogood.shop.databasemanager.AccNote;
import com.silogood.shop.databasemanager.Acc_NotesAdapter;
import com.silogood.shop.databasemanager.DatabaseHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class User_Acc extends AppCompatActivity {

    private String TAG = "USER_ACC";

    private EditText mBqtEditText ;
    private Button mPurchaceBtn;
    private Button mHistoryBtn;
    private ListView mListView;
    private DatabaseHelper mDatabaseHelper;
    private AccNote selected_item;

    private ArrayList<AccNote> mClothes_list;

    private ArrayList<AccNote> mPurchaed_list;

    private Acc_NotesAdapter mAcc_NotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_acc);

        mDatabaseHelper= new DatabaseHelper(this);
        mClothes_list = new ArrayList<AccNote>();
        mPurchaed_list = new ArrayList<AccNote>();
        ////
        init_view();
    }

    private void init_view() {



        mAcc_NotesAdapter = new Acc_NotesAdapter(this,R.layout.custom_listview_item, mClothes_list);


        mPurchaceBtn = (Button)findViewById(R.id.user_acc_purchace_btn);
        mPurchaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int parse = Integer.parseInt(mBqtEditText.getText().toString());
                long now = System.currentTimeMillis();
                Date mDate = new Date(now);

                if (selected_item != null) {
                    if (selected_item.getBqt() - parse < 0) {
                        Toast.makeText(User_Acc.this, "남은 수량이 모자랍니다! ", Toast.LENGTH_SHORT).show();
                    } else {
                        AccNote cn = new AccNote(selected_item.getName(), selected_item.getCode(), selected_item.getBqt() - parse, mDate.toString());
                        mDatabaseHelper.updateAccNoteBycode(cn);

                        renew_list();
                        mAcc_NotesAdapter.notifyDataSetChanged();

                        // add purchaced list
                        AccNote purchaced_cn = new AccNote(selected_item.getName(), selected_item.getCode(), parse, mDate.toString());
                        mPurchaed_list.add(purchaced_cn);
                    }
                }
            }
        });

        mHistoryBtn = (Button)findViewById(R.id.user_acc_go_history_btn);
        mHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mPurchaed_list.size() != 0) {
                    Intent intent = new Intent(User_Acc.this, User_Acc_History.class);
                    intent.putExtra("purchaced", mPurchaed_list);
                    startActivity(intent);
                }else{
                    Toast.makeText(User_Acc.this, "구매 목록이 없습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mBqtEditText = (EditText)findViewById(R.id.user_acc_edittxt_1);

        mListView = (ListView)findViewById(R.id.user_acc_listview);
        mListView.setAdapter(mAcc_NotesAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_item = null ;
                selected_item = (AccNote)parent.getItemAtPosition(position);
                Toast.makeText(User_Acc.this, "selected item : " + selected_item.getName() , Toast.LENGTH_SHORT).show();

            }
        });

        renew_list();
    }

    private void renew_list(){

        mClothes_list.clear();


        List<AccNote> a = mDatabaseHelper.getAllAccNotes();
        int i;
        for (i = 0; i < a.size(); i++){
            mClothes_list.add(a.get(i));
        }


        mAcc_NotesAdapter.notifyDataSetChanged();
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
