package com.silogood.shop.databasemanager;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.silogood.shop.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class All_NotesAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<AllNote> mItemList;
    private int mLayout;
    private Drawable mDrawable;

    private  String TAG = "ALL NOTESADAPTER";

    public All_NotesAdapter(Context context, int layout, ArrayList<AllNote> itemList)
    {
        this.mContext = context;
        this.mLayout = layout;
        this.mItemList = itemList;
        this.mInflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
       return mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NoteViewHolder viewHolder;

        // 캐시된 뷰가 없을 경우 새로 생성하고 뷰홀더를 생성한다
        if(convertView == null)
        {
            convertView = mInflater.inflate(mLayout, parent, false);

            viewHolder = new NoteViewHolder();
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.iconImage);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.code = (TextView) convertView.findViewById(R.id.code);
            viewHolder.bqt = (TextView) convertView.findViewById(R.id.bqt);
            viewHolder.timestamp = (TextView) convertView.findViewById(R.id.timestemp);

            convertView.setTag(viewHolder);
            notifyDataSetChanged();
        }
        // 캐시된 뷰가 있을 경우 저장된 뷰홀더를 사용한다
        else
        {
            viewHolder = (NoteViewHolder) convertView.getTag();
        }


        // path = item..  fake !
        if(mItemList.get(position).getPath().contains("jaket")) {
            mDrawable = mContext.getDrawable(R.drawable.jaket);
        } else if (mItemList.get(position).getPath().contains("necklace")) {
            mDrawable = mContext.getDrawable(R.drawable.necklace);
        } else if (mItemList.get(position).getPath().contains("sneaker")){
            mDrawable = mContext.getDrawable(R.drawable.sneaker);
        } else {
            mDrawable = mContext.getDrawable(R.drawable.shirts);
        }

        viewHolder.icon.setBackground(mDrawable);
        viewHolder.name.setText("상품명 : "+mItemList.get(position).getName());
        viewHolder.code.setText("품번 : "+ mItemList.get(position).getCode());
        viewHolder.bqt.setText("수량 : "+ String.valueOf(mItemList.get(position).getBqt()));
        viewHolder.timestamp.setText(mItemList.get(position).getTimestamp());
        notifyDataSetChanged();
        return convertView;

    }

    public class NoteViewHolder
    {
        public ImageView icon;
        public TextView name;
        public TextView code;
        public TextView bqt;
        public TextView timestamp;
    }
}
