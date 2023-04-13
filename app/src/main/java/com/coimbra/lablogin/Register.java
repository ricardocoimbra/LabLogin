package com.coimbra.lablogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Register extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    MaterialButton btnReg;
    TextView gotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtEmail = findViewById(R.id.editTextEmail);
        txtPassword = findViewById(R.id.editTextPassword);
        btnReg = findViewById(R.id.buttonRegister);
        gotoLogin = findViewById(R.id.loginNow);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = txtEmail.getText().toString();
                password = String.valueOf(txtPassword.getText());

                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(Register.this, "O campo email não pode estar vazio", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this, "O campo senha não pode estar vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}