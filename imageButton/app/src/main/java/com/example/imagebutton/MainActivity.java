package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MensajeEva(View view){
        Toast.makeText(this, "Esta es la Eva piculina de papocho!", Toast.LENGTH_LONG).show();
    }
    public void MensajeGoo (View view){
        Toast.makeText(this, "¡Toca el otro botoncito perejil!", Toast.LENGTH_SHORT).show();
    }
}
