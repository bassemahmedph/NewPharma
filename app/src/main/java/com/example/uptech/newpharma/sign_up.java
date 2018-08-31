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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends AppCompatActivity implements View.OnClickListener {
    private Button btn1 , btn2;
    private EditText firstname,lastname,email,password,repassword,age,phone;
    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


        btn1=(Button) findViewById(R.id.reg_createacc);
        btn2=(Button) findViewById(R.id.reg_back);

        firstname = (EditText) findViewById(R.id.reg_firstname);
        lastname = (EditText) findViewById(R.id.reg_lastname);
        email = (EditText) findViewById(R.id.reg_mail);
        password = (EditText) findViewById(R.id.reg_password);
        repassword= (EditText) findViewById(R.id.reg_repassword);
        age = (EditText) findViewById(R.id.reg_age);
        phone = (EditText) findViewById(R.id.reg_phone);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), nav_drawer.class));
        }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(login_form.this, "done", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(sign_up.this,nav_drawer.class);
//                startActivity(intent);
//            }
//        });

//        bt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(login_form.this, "done", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(sign_up.this,login_form.class);
//                startActivity(intent);
//            }
//        });
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    private void registerUser() {

        String FirstName = firstname.getText().toString().trim();
        String LastName = lastname.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String Repassword = repassword.getText().toString().trim();
        String Phone = phone.getText().toString().trim();
        String Age = age.getText().toString().trim();

        if (TextUtils.isEmpty(FirstName)) {
            Toast.makeText(this, "please enter first name ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(LastName)) {
            Toast.makeText(this, "please enter last name ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(this, "please enter email ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(this, "please enter password ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Repassword)) {
            Toast.makeText(this, "please re-type password ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Phone)) {
            Toast.makeText(this, "please enter phone number ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Age)) {
            Toast.makeText(this, "please enter age ", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
//                    saveUserInformatio();
                    finish();
//                    Toast.makeText(sign_up.this, "done ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), nav_drawer.class));

                } else {
                    Toast.makeText(sign_up.this, "something wronge ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

//    public void saveUserInformatio() {
//        String Name = firstname.getText().toString().trim();
//        // String lastname = LastName.getText().toString().trim();
//        String Email = email.getText().toString().trim();
//        String Password = password.getText().toString().trim();
//        //String repassword = EditTextrepassword.getText().toString().trim();
//        String Phone = phone.getText().toString().trim();
//        String Age = age.getText().toString().trim();
//
//        String Id = firebaseAuth.getCurrentUser().getUid();
//        UserInformation userInformation = new UserInformation(Name, Email, Phone, Age);
//        databaseReference.child(Id).setValue(userInformation);
//
//
//    }

    @Override
    public void onClick(View v) {
        if(v==btn1){
            registerUser();

        }
        if (v==btn2)
        {
            startActivity(new Intent(this,login_form.class));
        }


    }
}
