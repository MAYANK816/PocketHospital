package com.example.madad.Features;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.madad.Adapters.ShareAdapter;
import com.example.madad.Models.ShareAndCare;
import com.example.madad.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Share extends AppCompatActivity {
    RecyclerView recyclerView;
    ShareAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    List<ShareAndCare> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        recyclerView = findViewById(R.id.ShareRecycler);
        databaseReference = FirebaseDatabase.getInstance().getReference("ShareAbleItem");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList =new ArrayList<>();

        adapter = new ShareAdapter(getApplicationContext(),arrayList);
        recyclerView.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                   ShareAndCare s = new ShareAndCare();
                   s.setName(dataSnapshot.child("name").getValue().toString());
                   s.setNumber(dataSnapshot.child("number").getValue().toString());
                   s.setAddress(dataSnapshot.child("address").getValue().toString());
                   s.setShareAbleItem(dataSnapshot.child("shareAbleItem").getValue().toString());
                   arrayList.add(s);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}