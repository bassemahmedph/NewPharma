package com.example.uptech.newpharma.pharmacy_directory;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.uptech.newpharma.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Pharmacy_Directory extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ListView customlistview;
    MyCustomListAdapter2 myCustomListAdapter2;
    DatabaseReference databaseReference;
//    ArrayList<pharmacy_dicrectory_const> mproducts;
    static String name = "";
    ArrayList<String> namme = new ArrayList<>();
    ArrayList<String> adddresss = new ArrayList<>();
    ArrayList<String> Number= new ArrayList<>();
//    public String[] names = {"El 3zby" , "masr" , "fo2ad" , "hena"};
//    public String[] phones = {"01115125" , "0154841212" , "01245488" , "0166875151"};
//    public String[] address = {"22shar3 hussin mahran " , "55 mohndsen shehab" , "11 masr el gdeda" , "10 masr el adema"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy__directory);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("city");

        customlistview = (ListView) findViewById(R.id.pharma_list_view);
        spinner = (Spinner) findViewById(R.id.pharma_spinner);
        customlistview.setAdapter(myCustomListAdapter2);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("pharmacies");


        updateListView();



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();


        customlistview.invalidateViews();
        //kemya.clearTextFilter();
        name = parent.getItemAtPosition(position).toString();
        updateListView();


    }

    private void updateListView() {
        databaseReference.child(name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                namme.clear();
                adddresss.clear();
                Number.clear();

                for (DataSnapshot drags : dataSnapshot.getChildren()) {
                    namme.add(drags.child("name").getValue(String.class));
                    adddresss.add(drags.child("address").getValue(String.class));
                    Number.add(drags.child("Number").getValue(String.class));
                }

                myCustomListAdapter2 = new MyCustomListAdapter2(getApplicationContext(), namme, adddresss, Number);
                customlistview.setAdapter(myCustomListAdapter2);
                myCustomListAdapter2.notifyDataSetChanged();


                //  productlistAdapters.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }}
