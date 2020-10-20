package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//MIO
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Selecccion(View view){
        switch (view.getId()){
            case R.id.fresas:
                Toast.makeText(this, "Estas son fresas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.manzanas:
                Toast.makeText(this, "Estas son manzanas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pina:
                Toast.makeText(this, "Esto es una piña", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sandia:
                Toast.makeText(this, "Esto es una sandia", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bananas:
                Toast.makeText(this, "Estas son bananas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cerezas:
                Toast.makeText(this, "Estas son cerezas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.kiwis:
                Toast.makeText(this, "Estos son kiwis", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mangos:
                Toast.makeText(this, "Estos con mangos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.melon:
                Toast.makeText(this, "Este es un mélon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.naranja:
                Toast.makeText(this, "Estas son naranjas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.peras:
                Toast.makeText(this, "Estas son peras", Toast.LENGTH_SHORT).show();
                break;
            case R.id.uvas:
                Toast.makeText(this, "Estas son uvas", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}