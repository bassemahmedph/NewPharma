package com.example.uptech.newpharma;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.uptech.newpharma.common_desaes.common_disease;
import com.example.uptech.newpharma.maps.MapPlacesActivity;
import com.example.uptech.newpharma.pharmacy_directory.Pharmacy_Directory;
import com.google.firebase.auth.FirebaseAuth;

public class nav_drawer extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout mDrawerlayout ;
    private ActionBarDrawerToggle mToggle ;
    LinearLayout back , maps , Common;
    private FirebaseAuth firebaseAuth;
    View directoryMedi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        mDrawerlayout = (DrawerLayout) findViewById(R.id.nav_drawer_id);
        mToggle = new ActionBarDrawerToggle(this ,mDrawerlayout,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        directoryMedi=(View) findViewById(R.id.directory_of_meducines);
       directoryMedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nav_drawer.this, Pharmacy_Directory.class));
            }
        });


        maps = (LinearLayout) findViewById(R.id.nav_maps);
        maps.setOnClickListener(this);

        Common=(LinearLayout) findViewById(R.id.nav_common_disease_button);
        Common.setOnClickListener(this);

        //////////////////////////////////////////////////////
        back = (LinearLayout) findViewById(R.id.backtest);
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this , login_form.class));
        }
        back.setOnClickListener(this);

//////////////////////////////////////////////////////////////


   }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == back) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, login_form.class));
        }
        if(v== maps)
        {
            startActivity(new Intent(this, MapPlacesActivity.class));

        }
        if(v== Common)
        {
           startActivity(new Intent(this, common_disease.class));

        }

    }
}
