package com.example.prueba_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_valor1, et_valor2;
    private RadioButton rb_suma, rb_resta, rb_mul, rb_div;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valor1 = (EditText) findViewById(R.id.txt_valor1);
        et_valor2 = (EditText) findViewById(R.id.txt_valor2);
        rb_suma = (RadioButton) findViewById(R.id.rb_sumar);
        rb_resta = (RadioButton) findViewById(R.id.rb_restar);
        rb_mul = (RadioButton) findViewById(R.id.rb_multiplicar);
        rb_div = (RadioButton) findViewById(R.id.rb_dividir);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

    }

    //Metodo para el button

    public void Calcular(View view){
        String valor1_String = et_valor1.getText().toString(), valor2_String = et_valor2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        if (rb_suma.isChecked() == true){
            int suma = valor1_int+valor2_int;
            String resultado = String.valueOf(suma);
            tv_resultado.setText(resultado);
        }else if (rb_resta.isChecked() == true){
            int resta = valor1_int-valor2_int;
            String resultado = String.valueOf(resta);
            tv_resultado.setText(resultado);
        }else if (rb_mul.isChecked() == true){
            int mul = valor1_int*valor2_int;
            String resultado = String.valueOf(mul);
            tv_resultado.setText(resultado);
        }else if (rb_div.isChecked() == true){
            if (valor2_int != 0){
                int div = valor1_int/valor2_int;
                String resultado = String.valueOf(div);
                tv_resultado.setText(resultado);
            }else{
                Toast.makeText(this,"El segundo valor debe ser diferente de cero, ¡huevon!", Toast.LENGTH_LONG).show();
            }
        }

    }
}







