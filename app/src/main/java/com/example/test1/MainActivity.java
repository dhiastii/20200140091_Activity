package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan pass
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), halamandaftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //Membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password
                password = edpassword.getText().toString();

                //membuat variabel toast dan membuat toast
                Toast t = Toast.makeText(getApplicationContext(),
                        "email anda: " + nama + " dan Password anda: " + password + "",
                        Toast.LENGTH_LONG);


                if (nama.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "Email atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    if (nama.equals("Dhiasti Putri") && password.equals("dhiastiputrii")) {
                        Bundle b = new Bundle();
                        //key parsing data dimasukkan kedalam bundle
                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());


                        //membuat obyek untuk pindah halaman
                        Intent i = new Intent(getApplicationContext(),Home_Activity.class);
                        //memasukkan bundle kedalam intent
                        i.putExtras(b);
                        //berpindah ke halaman lain
                        startActivity(i);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Login Berhasil", Toast.LENGTH_LONG);
                        toast.show();
                        //menghapus isi dari editText
                        edemail.getText().clear();
                        edpassword.getText().clear();
                    } else {
                        if (password.equals("dhiasti putri")) {
                            Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_SHORT).show();
                        } else {
                            Bundle b = null;
                            if (nama.equals("dhiastiiputri")) {
                                Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Username Salah", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
    });
    }
}