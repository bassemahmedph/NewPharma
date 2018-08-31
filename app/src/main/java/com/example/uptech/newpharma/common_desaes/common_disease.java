package com.example.uptech.newpharma.common_desaes;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uptech.newpharma.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class common_disease extends AppCompatActivity {
    ArrayList<diseases> diseasesList;
    DatabaseReference databaseReference;
    RecyclerView myrecycle;
    RecycleViewAdapter recycleViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_disease);


        
        diseasesList = new ArrayList<>();//2
         myrecycle = findViewById(R.id.recycleviewid);//1

        recycleViewAdapter = new RecycleViewAdapter(this,diseasesList); //3

//        RecycleViewAdapter myadapter =new RecycleViewAdapter(this,diseasesList);
        myrecycle.setAdapter(recycleViewAdapter);//4
        myrecycle.setLayoutManager(new GridLayoutManager(this,3));//5
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Diseases");

        databaseReference.child("skin desies").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot drags : dataSnapshot.getChildren()) {
                    diseases products = drags.getValue(diseases.class);
//                     System.out.println(products.getName());
//                    System.out.println(products.getDesciption());
                    diseasesList.add(products);


                }
                recycleViewAdapter.notifyDataSetChanged();//-_-

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }}






