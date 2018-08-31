package com.example.uptech.newpharma.LearnMore;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uptech.newpharma.R;
import com.example.uptech.newpharma.common_desaes.common_disease;
import com.example.uptech.newpharma.login_form;
import com.example.uptech.newpharma.maps.MapPlacesActivity;

public class Learn_more extends AppCompatActivity implements View.OnClickListener{
private ViewPager viewPager;
    private SlideAdapter myadapter;
     Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        viewPager=(ViewPager) findViewById(R.id.viewpager);
        myadapter=new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
        back=(Button)findViewById(R.id.btnEnd);
        back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == back) {
            startActivity(new Intent(this, login_form.class));

        }
    }
}
