package com.example.madad.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madad.Models.BedModel;
import com.example.madad.R;
import com.google.firebase.firestore.auth.User;

import java.util.List;

public class BedAdapter extends RecyclerView.Adapter<BedAdapter.MyViewHolder> {
    Context context;
    List<BedModel> arrayList;


    public BedAdapter(Context context, List arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.getlayout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BedModel b = (BedModel) arrayList.get(position);
        holder.hname.setText(b.getHsname());
        holder.hnumber.setText(b.getHsnmbr());
        holder.hadrs.setText(b.getHsadrs());
        holder.bedavl.setText(b.getBdavl());
        holder.bedtype.setText(b.getBdtype());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView hname,hnumber,hadrs,bedavl,bedtype;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hname  = itemView.findViewById(R.id.hospitalName);
            hnumber  = itemView.findViewById(R.id.hospitalNumber);
            hadrs  = itemView.findViewById(R.id.hospitalAdrs);
            bedavl = itemView.findViewById(R.id.BedAvailable);
            bedtype = itemView.findViewById(R.id.BedType);

        }
    }
}
