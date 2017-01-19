package com.devscious.menuorder;

/**
 * Created by Khang.Dong on 2017-01-17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class CustomList extends RecyclerView.Adapter<CustomList.myViewHolder>{
    private final LayoutInflater inflater;
    private List<Data> listData = new ArrayList<Data>();
    public CustomList(Context context, List<Data> data){
        inflater = LayoutInflater.from(context);
        this.listData = data;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_single,parent,false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        holder._title.setText(listData.get(position).getTitle());
        holder._price.setText(String.valueOf(listData.get(position).getPrice()) + " VND");
        holder._quality.setText("x " + String.valueOf(listData.get(position).getQuality()));
        holder._imgview.setImageResource(listData.get(position).getImageId());
        holder._imgdelete.setImageResource(R.mipmap.ic_launcher);
    }

    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView _imgview;
        ImageView _imgdelete;
        TextView  _title;
        TextView _price;
        TextView _quality;

        public myViewHolder(View itemView) {
            super(itemView);
            _imgview = (ImageView) itemView.findViewById(R.id.img);
            _imgdelete = (ImageView) itemView.findViewById(R.id.imgDelete);
            _title = (TextView) itemView.findViewById(R.id.txtTitle);
            _price = (TextView) itemView.findViewById(R.id.txtPrice);
            _quality = (TextView) itemView.findViewById(R.id.txtQuality);
            _imgdelete.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            EventBus.getDefault().post(String.valueOf(getAdapterPosition()));
            removeItem(getAdapterPosition());
            Toast.makeText(v.getContext(),"Deleted",Toast.LENGTH_LONG).show();
        }
    }
}
