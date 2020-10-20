package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private EditText et8;

    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.mil);
        et2 = (EditText) findViewById(R.id.quinientos);
        et3 = (EditText) findViewById(R.id.doscientos);
        et4 = (EditText) findViewById(R.id.cien);
        et5 = (EditText) findViewById(R.id.cincuenta);
        et6 = (EditText) findViewById(R.id.veinte);
        et7 = (EditText) findViewById(R.id.diez);
        et8 = (EditText) findViewById(R.id.cinco);

        tv1 = (TextView) findViewById(R.id.txt_resultado);
    }



    //Este metodo realiza la suma
    public void suma(View view){

        String valor1 = et1.getText().toString();
        int num1 = Integer.parseInt(valor1);
        int suma1 = num1 * 1000;

        String valor2 = et2.getText().toString();
        int num2 = Integer.parseInt(valor2);
        int suma2 = num2 * 500;

        String valor3 = et3.getText().toString();
        int num3 = Integer.parseInt(valor3);
        int suma3 = num3 * 200;

        String valor4 = et4.getText().toString();
        int num4 = Integer.parseInt(valor4);
        int suma4 = num4 * 100;

        String valor5 = et5.getText().toString();
        int num5 = Integer.parseInt(valor5);
        int suma5 = num5 * 50;

        String valor6 = et6.getText().toString();
        int num6 = Integer.parseInt(valor6);
        int suma6 = num6 * 20;

        String valor7 = et7.getText().toString();
        int num7 = Integer.parseInt(valor7);
        int suma7 = num7 * 10;

        String valor8 = et8.getText().toString();
        int num8 = Integer.parseInt(valor8);
        int suma8 = num8 * 5;

        int suma = suma1+suma2+suma3+suma4+suma5+suma6+suma7+suma8;

        String result = String.valueOf(suma);
        tv1.setText(result);
    }

}
