package com.toly1994.mycode.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.toly1994.mycode.R;
import com.toly1994.mycode.bean.ResultBean;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private Context mContext;
    private List<ResultBean.NoteBean> mData;

    public HomeAdapter(List<ResultBean.NoteBean> data) {
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_a_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ResultBean.NoteBean note = mData.get(position);


        if (note.getName().equals(mData.get(0).getName())) {
            holder.mIdNewTag.setVisibility(View.VISIBLE);
        } else {
            holder.mIdNewTag.setVisibility(View.GONE);

        }

        Picasso.get()
                .load(note.getImgUrl())
                .into(holder.mIvCover);

        holder.mIvTvTitle.setText(note.getName());
        holder.mIdTvType.setText(note.getType());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public View mIdNewTag;
        public TextView mIvTvTitle;
        public ImageView mIvCover;
        public TextView mIdTvType;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIvTvTitle = itemView.findViewById(R.id.iv_tv_title);
            mIvCover = itemView.findViewById(R.id.iv_cover);
            mIdTvType = itemView.findViewById(R.id.id_tv_type);
            mIdNewTag = itemView.findViewById(R.id.id_new_tag);
        }
    }
}