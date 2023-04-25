package com.coimbra.lablogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioActivity extends AppCompatActivity {

    private EditText myFirstName;
    private EditText myLastName;
    private Button myButtonSave;
    private Button myButtonDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        myFirstName = findViewById(R.id.editTextFirstName);
        myLastName = findViewById(R.id.editTextLastName);
        myButtonSave = findViewById(R.id.buttonSave);
        myButtonDisplay = findViewById(R.id.buttonDisplay);

        myButtonSave.setEnabled(false);
        myLastName.setEnabled(false);

        myFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                myLastName.setEnabled(!editable.toString().isEmpty());

            }
        });

        myLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                myButtonSave.setEnabled(!editable.toString().isEmpty());
            }
        });

        myButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = myFirstName.getText().toString();
                String lName = myLastName.getText().toString();

                MyDatabaseHelper myDB = new MyDatabaseHelper(FormularioActivity.this);
                myDB.addPerson(fName.trim(), lName.trim());
            }
        });

        myButtonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(FormularioActivity.this);
                Intent intent = new Intent(FormularioActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}