package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {
    Button btnBatal, btnDaftar;
    EditText ednama, edalamat, edemail, edpassword, edrepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftaran);

        ednama = findViewById(R.id.edNama);
        edalamat = findViewById(R.id.edAlamat);
        edemail = findViewById(R.id.edEemail);
        edpassword = findViewById(R.id.edPassw);
        edrepass = findViewById(R.id.edRepass);

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ednama.getText().toString().isEmpty() ||
                        edalamat.getText().toString().isEmpty() ||
                        edemail.getText().toString().isEmpty() ||
                        edpassword.getText().toString().isEmpty() ||
                        edrepass.getText().toString().isEmpty())
                {
                    Snackbar.make(v, "Wajib isi seluruh data!!!", Snackbar.LENGTH_LONG).show();
                }
                else{
                    if (edpassword.getText().toString().equals(edrepass.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else{
                        Snackbar.make(v, "Password dan Repassword harus sama!!!", Snackbar.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}
