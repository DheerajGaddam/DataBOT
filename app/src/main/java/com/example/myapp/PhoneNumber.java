package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.myapp.R.layout.activity_phone_number;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PhoneNumber extends AppCompatActivity {

    private EditText editTextMobile;
    Button btnContinue;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        //initialize fields
        editTextMobile = findViewById(R.id.editTextMobile);
        btnContinue = findViewById(R.id.buttonContinue);
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        //check whether the user is logged in
        /*if (currentUser != null) {
            //Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            //startActivity(intent);
            //finish();
            Toast.makeText(this, "Already Logged in", Toast.LENGTH_SHORT).show();
        }else {*/
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobileNo = editTextMobile.getText().toString().trim();

                if (mobileNo.isEmpty() || mobileNo.length() < 10) {
                    editTextMobile.setError("Enter a valid mobile");
                    editTextMobile.requestFocus();
                    return;
                }

                Intent intent = new Intent(PhoneNumber.this, VerifyPhoneActivity.class);
                intent.putExtra("mobile", mobileNo);
                startActivity(intent);
            }
        });
        //}
    }
}