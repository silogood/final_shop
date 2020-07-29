package com.silogood.shop.admin.admin_acc.print;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.silogood.shop.R;
import com.silogood.shop.databasemanager.AccNote;
import com.silogood.shop.databasemanager.DatabaseHelper;
import com.silogood.shop.databasemanager.Acc_NotesAdapter;

import java.util.ArrayList;

public class Admin_Acc_Print extends AppCompatActivity {

    private ListView mListView;
    private TextView mTextView;
    private DatabaseHelper mDatabaseHelper;
    private String TAG = "ADMIN_ACC_PRINT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acc_print);
        mDatabaseHelper= new DatabaseHelper(this);
        init_view();
    }

    private void init_view(){

        mListView = (ListView)findViewById(R.id.listview);
        mTextView = (TextView)findViewById(R.id.selected_item_textview);

        ArrayList<AccNote> list = new ArrayList<AccNote>();

        Acc_NotesAdapter adapter = new Acc_NotesAdapter(this,R.layout.custom_listview_item,list);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                AccNote selected_item = (AccNote)adapterView.getItemAtPosition(position);

                mTextView.setText(selected_item.getName());
                AccNote an = new AccNote(selected_item.getId(),selected_item.getName(),selected_item.getCode(),selected_item.getBqt()-1,selected_item.getTimestamp());
                mDatabaseHelper.updateAccNote(an);

            }
        });



        int i = mDatabaseHelper.getAccNotesCount();
        long index ;
        for( index = 1 ; index < i ; index++ ){
            AccNote admin_acc = mDatabaseHelper.getAccNote(index);
            list.add(admin_acc);

        }
    }
}