package com.example.madad.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.madad.Models.BedModel;
import com.example.madad.Models.ShareAndCare;
import com.example.madad.Models.slideImage;
import com.example.madad.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.Viewholder> {
    Context context;
    List<ShareAndCare> helperList;

    public ShareAdapter(Context context, List<ShareAndCare> helperList) {
        this.context = context;
        this.helperList = helperList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forshare, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ShareAndCare helper = helperList.get(position);
        holder.Name.setText(helper.getName());
        holder.Number.setText(helper.getNumber());
        holder.Adrs.setText(helper.getAddress());
        holder.Share.setText(helper.getShareAbleItem());

    }

    @Override
    public int getItemCount() {
        return helperList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

       private TextView Name,Number,Adrs,Share;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.SName);
            Number=itemView.findViewById(R.id.SNumber);
            Adrs=itemView.findViewById(R.id.SAdrs);
            Share=itemView.findViewById(R.id.SAlbetem);


        }
    }
}
