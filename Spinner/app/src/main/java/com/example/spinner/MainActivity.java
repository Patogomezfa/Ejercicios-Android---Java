package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1;
    private EditText et2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Colocar el icono en el ActionBar

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        tv = (TextView) findViewById(R.id.tv_resultado);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        String [] opciones = {"sumar","restar","multiplicar","dividir"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_eva, opciones);
        spinner1.setAdapter(adapter);
    }

    //Metodo del button

    public void Calcular(View view){
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = spinner1.getSelectedItem().toString();

        if(seleccion.equals("sumar")){
            int suma = valor1_int+valor2_int;
            String resultado = String.valueOf(suma);
            tv.setText(resultado);
        }else if(seleccion.equals("restar")){
            int resta = valor1_int-valor2_int;
            String resultado = String.valueOf(resta);
            tv.setText(resultado);
        }else if(seleccion.equals("multiplicar")){
            int multi = valor1_int*valor2_int;
            String resultado = String.valueOf(multi);
            tv.setText(resultado);
        }else if(seleccion.equals("dividir")){
            if (valor2_int != 0) {
                int dividir = valor1_int / valor2_int;
                String resultado = String.valueOf(dividir);
                tv.setText(resultado);
            }else{
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
            }
        }
    }
}





