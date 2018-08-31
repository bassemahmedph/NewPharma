package com.example.uptech.newpharma.common_desaes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.uptech.newpharma.R;

import java.lang.reflect.Array;

public class Inside_card_common_diseases extends AppCompatActivity {

    private TextView tvname,tvdescriotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_card_common_diseases);
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String description = intent.getExtras().getString("desicription");

        Log.d("TAG", name + " ### " + description);

        tvname = (TextView) findViewById(R.id.name_inside);
        tvdescriotion = (TextView) findViewById(R.id.Description_inside);

        tvname.setText(name);
        tvdescriotion.setText(description);




    }
}
