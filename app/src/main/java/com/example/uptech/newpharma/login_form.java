package com.example.uptech.newpharma;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uptech.newpharma.LearnMore.Learn_more;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_form extends AppCompatActivity implements View.OnClickListener{
    Button login1,login2,login3;
    private FirebaseAuth firebaseAuth;
    private EditText username,password;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        progressDialog = new ProgressDialog(this);
        login1=(Button) findViewById(R.id.logbt1);
        login2=(Button) findViewById(R.id.logbt2);
        login3=(Button) findViewById(R.id.logbt3);
        username=(EditText) findViewById(R.id.log_username);
        password=(EditText) findViewById(R.id.log_password);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), nav_drawer.class));

        }




////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        login1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(login_form.this, "done", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(login_form.this,Learn_more.class);
//                startActivity(intent);
//            }
//        });
//
//        login2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(login_form.this, "done", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(login_form.this,sign_up.class);
//                startActivity(intent);
//            }
//        });
//
//        login3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(login_form.this, "done", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(login_form.this,nav_drawer.class);
//                startActivity(intent);
//            }
//        });
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        login1.setOnClickListener(this);
        login3.setOnClickListener(this);
        login2.setOnClickListener(this);
    }


    private void UserLogin(){
        String Username = username.getText().toString().trim();
        String Password = password.getText().toString().trim();
        if (TextUtils.isEmpty(Username)) {
            Toast.makeText(this, "please enter first name ", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
            return;
        }
        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(this, "please enter the Password ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (username.getText().toString().equals("pharmacy@yahoo.com")&& password.getText().toString().equals("0123456789"))
        {
            startActivity(new Intent(getApplicationContext(), nav_drawer.class));

        }
        progressDialog.setMessage("Login...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(Username,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    finish();
                    startActivity(new Intent(getApplicationContext(), nav_drawer.class));
                }
                if (!task.isSuccessful()){

                    Toast.makeText(login_form.this, "Wrong Mail or Password Please Try Again ", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == login3){

            UserLogin();
        }
        if(v == login2){

            startActivity(new Intent(this , sign_up.class));
        }
        if(v==login1)
        {
            startActivity(new Intent(this , Learn_more.class));

        }
    }
}
