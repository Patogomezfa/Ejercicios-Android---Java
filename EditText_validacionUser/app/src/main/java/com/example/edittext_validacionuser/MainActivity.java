package com.example.edittext_validacionuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etn, etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn = (EditText) findViewById(R.id.txt_nombre);
        etp = (EditText) findViewById(R.id.txt_password);

    }

    public void Registrar(View view){
        String nombre = etn.getText().toString();
        String password = etp.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show();
        }
        if (password.length()== 0){
            Toast.makeText(this, "Debe ingresar un password", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() != 0 && password.length() != 0){
            Toast.makeText(this, "Registro en proceso", Toast.LENGTH_LONG).show();
        }
    }
}
