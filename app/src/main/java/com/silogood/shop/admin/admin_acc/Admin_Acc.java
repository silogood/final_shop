package com.silogood.shop.admin.admin_acc;

import androidx.appcompat.app.AppCompatActivity;

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


public class Admin_Acc extends AppCompatActivity {
    
    private String TAG = "ADMIN ACC";

    private DatabaseHelper mDatabaseHelper;

    private EditText mEditText_Product;
    private EditText mEditText_Code;
    private EditText mEditText_Bqt;
    private Button mAddBtn;
    private Button mDelBtn;
    private Button mModifyBtn;
    private ListView mListView;

    private ArrayList<AccNote> mAcc_list;
    private Acc_NotesAdapter mAcc_NotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acc);

        mDatabaseHelper= new DatabaseHelper(this);

        init_view();
    }

    private void init_view() {

        mAcc_list = new ArrayList<AccNote>();
        mAcc_NotesAdapter = new Acc_NotesAdapter(this,R.layout.custom_listview_item, mAcc_list);


        mEditText_Product = (EditText)findViewById(R.id.admin_acc_edittxt_1);

        mEditText_Code = (EditText)findViewById(R.id.admin_acc_edittxt_2) ;

        mEditText_Bqt = (EditText)findViewById(R.id.admin_acc_edittxt_3) ;

        mAddBtn = (Button)findViewById(R.id.admin_acc_addbtn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText_Product.getText();
                int parse = Integer.parseInt(mEditText_Bqt.getText().toString());
                mDatabaseHelper.setInsertNote("acc",mEditText_Product.getText().toString(),mEditText_Code.getText().toString(),parse);

                Toast.makeText(Admin_Acc.this, "새 아이템 추가 완료", Toast.LENGTH_SHORT).show();

                renew_list();
                mAcc_NotesAdapter.notifyDataSetChanged();
            }
        });



        mDelBtn = (Button)findViewById(R.id.admin_acc_purchace_btn);
        mDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseHelper.deleteAccNotebyname(mEditText_Code.getText().toString());

                Toast.makeText(Admin_Acc.this, "제거 완료", Toast.LENGTH_SHORT).show();
                renew_list();
                mAcc_NotesAdapter.notifyDataSetChanged();
            }
        });

        mModifyBtn = (Button)findViewById(R.id.admin_acc_go_history_btn);
        mModifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Clothes , shoes sam

                if (mEditText_Product.getText().toString().equals("") || mEditText_Code.getText().toString().equals("") || mEditText_Bqt.getText().toString().equals("")) {
                    Toast.makeText(Admin_Acc.this, "상품의 정보를 전부 입력 해 주세요.", Toast.LENGTH_SHORT).show();
                }else {

                    int parse = Integer.parseInt(mEditText_Bqt.getText().toString());
                    long now = System.currentTimeMillis();
                    Date mDate = new Date(now);

                    AccNote cn = new AccNote(mEditText_Product.getText().toString(), mEditText_Code.getText().toString(), parse, mDate.toString());
                    mDatabaseHelper.updateAccNoteBycode(cn);
                    Toast.makeText(Admin_Acc.this, "변경 되었습니다.", Toast.LENGTH_SHORT).show();


                    renew_list();
                    mAcc_NotesAdapter.notifyDataSetChanged();
                }
            }
        });

        mListView = (ListView)findViewById(R.id.admin_acc_listview);
        mListView.setAdapter(mAcc_NotesAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //List Item click
                AccNote selected_item = (AccNote)parent.getItemAtPosition(position);
                mEditText_Product.setText(selected_item.getName());
                mEditText_Code.setText(selected_item.getCode());
                mEditText_Bqt.setText(Integer.toString(selected_item.getBqt()));
            }
        });

        renew_list();

    }


    private void renew_list(){

        mAcc_list.clear();


        List<AccNote> a = mDatabaseHelper.getAllAccNotes();
        int i;
        for (i = 0; i < a.size(); i++){
            mAcc_list.add(a.get(i));
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