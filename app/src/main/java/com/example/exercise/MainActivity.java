package com.example.exercise;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnSignup;
    EditText edemail, edpassword;
    String nama, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignup=findViewById(R.id.btSignup);
        btnLogin=findViewById(R.id.btLogin);
        edemail=findViewById(R.id.edEemail);
        edpassword=findViewById(R.id.edPassword);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "Menu Pendaftaran", Toast.LENGTH_LONG);
                t.show();

                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama=edemail.getText().toString();
                password=edpassword.getText().toString();

                String email="admin@mail.com";
                String pass="123456";

                if (nama.isEmpty() || password.isEmpty())
                {
                    Toast t = Toast.makeText(getApplicationContext(), "email dan password wajib diisi!!!", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    if (nama.equals(email) && password.equals(pass)){

                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), Hasil.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);
                        t.show();
                    }

                }
            }
        });
    }
}