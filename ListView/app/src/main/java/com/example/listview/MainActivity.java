package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String nombres [] = {"Samuel","Noelia","Vico","Patricio","Elsa","Evangelina","Romina","Andres","Mariano","Juanita"};
    private String edades [] = {"32","30","31","28","63","4","27","33","25","99"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        lv1 = (ListView) findViewById(R.id.lv1);

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, R.layout.list_item_noe, nombres);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long i) {
                tv1.setText("La edad de " + lv1.getItemAtPosition(position) + " es " + edades[(int) i] + " años");
            }
        });
    }
}
