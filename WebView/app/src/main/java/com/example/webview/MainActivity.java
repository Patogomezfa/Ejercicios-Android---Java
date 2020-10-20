package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_web);
    }

    //Metodo boton ir

    public void Navegar(View view){

        Intent i = new Intent(this, Activity_web.class);
        i.putExtra("sitioWeb",et1.getText().toString());
        startActivity(i);
    }
}
