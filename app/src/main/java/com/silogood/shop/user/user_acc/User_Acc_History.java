package com.silogood.shop.user.user_acc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.silogood.shop.R;
import com.silogood.shop.databasemanager.AccNote;
import com.silogood.shop.databasemanager.Acc_NotesAdapter;

import java.util.ArrayList;

public class User_Acc_History extends AppCompatActivity {

    private String TAG = "HISTORY ACC";
    private ListView mListView;
    private ArrayList<AccNote> mPurchaed_list;
    private Acc_NotesAdapter mPurchaced_notesAdapter;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mIntent = getIntent();
        ArrayList<AccNote> cn =  (ArrayList<AccNote>) mIntent.getSerializableExtra("purchaced");
        //ArrayList<AccNote> cn =  (ArrayList<AccNote>) mIntent.getExtras().getSerializable("purchaced");

        Log.d(TAG,"#SILOGOOD CN.GET(0).GETnAME : "+cn.get(0).getName());

        mPurchaed_list = new ArrayList<AccNote>();

        mPurchaced_notesAdapter = new Acc_NotesAdapter(this,R.layout.custom_listview_item, mPurchaed_list);

        mListView = (ListView)findViewById(R.id.purchaced_listview);
        mListView.setAdapter(mPurchaced_notesAdapter);

        int i ;
        for (i = 0; i < cn.size(); i++) {
            mPurchaed_list.add(cn.get(i));
        }

        mPurchaced_notesAdapter.notifyDataSetChanged();

    }


}
