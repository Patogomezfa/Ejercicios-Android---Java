package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo = (EditText) findViewById(R.id.txt_codigo);
        et_descripcion = (EditText) findViewById(R.id.txt_descripcion);
        et_precio= (EditText) findViewById(R.id.txt_precio);
    }

    //Metodo para dar de alta a los productos
    public void Registrar(View view){
        AdminSQLiteOpenHelper Admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1); //indicamos el nombre de la BD con la que trabajamos que es != al de la otra clase// version es la version de la BD (esta es nuestra primer version)
        //Creamos la conexion con la BD y la abrimos en modo de lectura/escritura
        SQLiteDatabase BaseDeDatos = Admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){ //Si la variable codigo, descripccion y precio NO (!) esta vacio entonces ejecuta el codigo que esta aqui adentro
            ContentValues registro = new ContentValues(); //Para colocar dentro de la BD

            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);
            //Con esto guardamos los datos que el user ha escrito
            //Ahora los insertamos en la tabla
            BaseDeDatos.insert("articulos", null, registro);

            //Es importante cerrar la BD y limpiar los campos
            BaseDeDatos.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();

        }

    }
    //Metodo para buscar un articulo

    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            // Cursor nos va a apoyar al momento de que nosotros queramos seleccionar un producto a travez de su codigo. nos permite poner un select
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select descripcion, precio from articulos where codigo =" + codigo, null);  //indicamos el nombre de la BD con la que trabajamos que es != al de la otra clase// version es la version de la BD (esta es nuestra primer version)

            if(fila.moveToFirst()){// Condicional que nos retorne true en caso de encontrar datos en la tabla. // moveToFirst revisa si nuestra consulta tiene valores
                //Tenemos que poner donde mostrar el valor encontrado
                et_descripcion.setText(fila.getString(0));//Siempre en nuestra primer consulta le tenemos que poner 0.
                et_precio.setText(fila.getString(1));// Es como si fuera un vector(Array). empieza a contar desde cero
                BaseDeDatabase.close();//Cierro bd si se cumple el IF, estaba abierta desde el AdminSQLiteOpenHelper
            } else {
                Toast.makeText(this,"No existe el artículo", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();//Si no se cumple la condicion TAMBIEN tengo que cerrar la BD
            }

        } else {
            Toast.makeText(this, "Debes introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }

    //Metdo para eliminar un articulo
    public void Eliminar (View view){
        AdminSQLiteOpenHelper Admin = new AdminSQLiteOpenHelper
                (this, "administracion",null,1); // Si el nombre esta mal escrito no se va a conectar con la BD
        SQLiteDatabase BaseDeDatos = Admin.getWritableDatabase(); // Debe abrir mi BD en modo lectura/escritura

        String codigo = et_codigo.getText().toString();//Con esto recuperamos el codigo que el user quiere eliminar

        //Validar el campo
        if (!codigo.isEmpty()){
            //declaramos un entero porque .delete retorna cuantos articulos ha borrado
            int cantidad = BaseDeDatos.delete("articulos", "codigo="+ codigo, null);//Esta estructura usamos para eliminar datos en la BD
            BaseDeDatos.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if (cantidad == 1){
                Toast.makeText(this, "El articulo ha sido eliminado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }
    }
    //Metodo para modificar un producto
    public void Modificar(View view){
        AdminSQLiteOpenHelper Admin = new AdminSQLiteOpenHelper
                (this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = Admin.getWritableDatabase();
        //Guardamos los 3 valores que el usuario ingreso porque no sabemos cual va a modificar
        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();
        //Evitamos que cualquiera de los campos esten en blanco
        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            //Guardamos dentro de registro las modificaciones que el user escribio dentro de los campos
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio",precio);

            //Ahora lo guardamos dentro de la BD
            int cantidad = BaseDeDatos.update("articulos", registro, "codigo=" + codigo,null);
            BaseDeDatos.close();
            
            if (cantidad == 1){
                Toast.makeText(this, "El articulo modificado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
}
