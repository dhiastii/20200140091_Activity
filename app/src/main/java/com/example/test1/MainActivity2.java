package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //
        email = findViewById(R.id.tf_nama);
        password = findViewById(R.id.tf_password);

        Bundle bundle = getIntent().getExtras();

        String Temail = bundle.getString("a");
        String Tpassword = bundle.getString("b");

        email.setText(Temail);
        password.setText(Tpassword);
    }
}