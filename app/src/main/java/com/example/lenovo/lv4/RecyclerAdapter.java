package com.example.lenovo.lv4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecViewHolder> {
    private List<Forecast> forecasts=new ArrayList<Forecast>();

    private Context mContext;
    public RecyclerAdapter(List<Forecast> forecasts,Context context) {
        this.forecasts=forecasts;
        mContext=context;
    }

    class RecViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
        textView1=itemView.findViewById(R.id.date);
            textView2=itemView.findViewById(R.id.high);
            textView3=itemView.findViewById(R.id.fengxiang);
            textView4=itemView.findViewById(R.id.low);
            textView5=itemView.findViewById(R.id.fengli);
            textView6=itemView.findViewById(R.id.type);
        }
    }
    public RecyclerAdapter.RecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.summary,viewGroup,false);
        return new RecViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecViewHolder recViewHolder, int i) {
        recViewHolder.textView1.setText( forecasts.get(i).getDate());
        recViewHolder.textView2.setText( forecasts.get(i).getHigh());
        recViewHolder.textView3.setText( forecasts.get(i).getFengxiang());
        recViewHolder.textView4.setText( forecasts.get(i).getLow());
        recViewHolder.textView5.setText( forecasts.get(i).getFengli());
        recViewHolder.textView6.setText( forecasts.get(i).getType());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
