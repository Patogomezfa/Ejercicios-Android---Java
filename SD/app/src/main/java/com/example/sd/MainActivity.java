package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    //Creo objeto EditText ya que son  los controles que colocamos en la interfaz grafica
    private EditText et_nombre, et_contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relacion entre parte logica y parte grafica
        et_nombre = (EditText) findViewById(R.id.txt_nombre);
        et_contenido = (EditText) findViewById(R.id.txt_contenido);

    }

    //Metodos para boton guardar

    public void Guardar(View view){
        //Creamos variables a los campos para guardar los elementos que introduzca el user
        String nombre = et_nombre.getText().toString();
        String contenido = et_contenido.getText().toString();
        //Usamos try-catch porque los metodos que vamos a usar los solicitan
        try{
            //Cuando vamos a guardar un archivo de texto en la tarjeta SD, le tenemos que decir a la App donde se encuentra la tarjeta SD
            File tarjetaSD = Environment.getExternalStorageDirectory(); // FILE: Nos permite guardar de manera temporal la ruta de la SD // Enviroment.getExternal... nos ayuda a recuperar la ruta y guardarla en el file
            Toast.makeText(this, tarjetaSD.getPath(), Toast.LENGTH_SHORT).show(); // Muestra al user la ruta donde se guardo el archivo // .getPath recupera lo que esta dentro del archivo file
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE)); //Abrimos el archivo creado

            crearArchivo.write(contenido);//Le pasamos el contenido escrito al programa
            crearArchivo.flush(); // Limpiamos el buffer
            crearArchivo.close(); //Es importante cerrar los archivos abiertos

            Toast.makeText(this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();

            //Limpio los campos de texto
            et_nombre.setText("");
            et_contenido.setText("");

        }catch (IOException e){
            Toast.makeText(this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para boton consultar

    public void Consultar(View view){

        String nombre = et_nombre.getText().toString(); //Creamos una variable para recuperar el nombre del archivo que el user quiere consultar

        try{
            File tarjetaSD = Environment.getExternalStorageDirectory(); //Igual que al guardar el archivo tenemos que indicar donde esta el archivo
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre); //Ya que tenemos la ruta de la tarjeta sd, buscamos el archivo
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));//Abrimos el archivo

            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);//Tenemos que verificar que el archivo no esta vacio, leyendo linea x linea
            String linea = leerArchivo.readLine();//Indicamos que tiene que leer la primer linea y guardarla dentro de una variable
            String contenidoCompleto = "";//Creamos la variable que va a contener a todas las lineas de texto

            while(linea != null){// Se activa si la primer linea no esta vacia
                contenidoCompleto = contenidoCompleto + linea + "\n";
                linea = leerArchivo.readLine();//Vamos leyendo linea por linea
            }

            leerArchivo.close();//agregamos el cierre de la lectura del archivo
            abrirArchivo.close();//Indicamos que el archivo tiene que cerrarse
            et_contenido.setText(contenidoCompleto);//Mostramos todo lo que encontramos dentro de nuestro archivo

        }catch (IOException e){
            Toast.makeText(this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
        }
        //Agregamos los metodos a los botones con ONCLICK en la interfaz grafica
    }
}
