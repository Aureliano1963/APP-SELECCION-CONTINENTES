package com.example.proy_electiva1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class desglos extends AppCompatActivity {

    private ListView lvLista;
    private ArrayList<csdesglo> listaContinentes;
    private Button btnRegresar, btnSiguiente;
    private RadioButton rdbBotones;
    private CheckBox rdbCheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desglo);
        btnRegresar = findViewById(R.id.btnRegresar);
        rdbCheckbox = findViewById(R.id.rdbCheckbox);
        rdbBotones = findViewById(R.id.rdbBotones);
        ValoresLista();

        Adaptadorpersonas adaptador = new Adaptadorpersonas(this);
        ListView lv1 = (ListView)findViewById(R.id.lvLista);
        lv1.setAdapter(adaptador);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (rdbBotones.isChecked()==true){
                    if(i==0) {
                        Intent intent = new Intent(desglos.this, America.class);
                        startActivity(intent);
                    }
                    if(i==1) {
                        Intent intent = new Intent(desglos.this, Europa.class);
                        startActivity(intent);
                    }
                    if(i==2) {
                        Intent intent = new Intent(desglos.this, Africa.class);
                        startActivity(intent);
                    }
                    if(i==3) {
                        Intent intent = new Intent(desglos.this, Asia.class);
                        startActivity(intent);
                    }
                    if(i==4) {
                        Intent intent = new Intent(desglos.this, Oceania.class);
                        startActivity(intent);
                    }
                    Toast.makeText(desglos.this,listaContinentes.get(i).getNombre(),Toast.LENGTH_LONG).show();
                }
                else if(rdbCheckbox.isChecked()==true) {

                    if(i==0) {
                        Intent intent = new Intent(desglos.this, CheckAmerica.class);
                        startActivity(intent);
                    }
                    if(i==1) {
                        Intent intent = new Intent(desglos.this, CheckEuropa.class);
                        startActivity(intent);
                    }
                    if(i==2) {
                        Intent intent = new Intent(desglos.this, CheckAfrica.class);
                        startActivity(intent);
                    }
                    if(i==3) {
                        Intent intent = new Intent(desglos.this, CheckAsia.class);
                        startActivity(intent);
                    }
                    if(i==4) {
                        Intent intent = new Intent(desglos.this, CheckOceania.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(desglos.this,"Seleccione RadioButton o CheckBox",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(desglos.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ValoresLista()
    {
        listaContinentes = new ArrayList<csdesglo>();
        listaContinentes.add(new csdesglo("America",'1'));
        listaContinentes.add(new csdesglo("Europa",'2'));
        listaContinentes.add(new csdesglo("Africa",'3'));
        listaContinentes.add(new csdesglo("Asia",'4'));
        listaContinentes.add(new csdesglo("Oceania",'5'));


    }

    class Adaptadorpersonas extends ArrayAdapter<csdesglo>
    {
        AppCompatActivity appCompatActivity;
        Adaptadorpersonas (AppCompatActivity context ){
            super(context, R.layout.activity_continentes, listaContinentes);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.continente, null);

            TextView textview1 =(TextView)item.findViewById(R.id.txtContinente);
            textview1.setText(listaContinentes.get(position).getNombre());
            ImageView imageView1 = (ImageView)item.findViewById(R.id.imgCont);

            if (listaContinentes.get(position).getImg()=='1')
                imageView1.setImageResource(R.mipmap.america);
            if (listaContinentes.get(position).getImg()=='2')
                imageView1.setImageResource(R.mipmap.europa);
            if (listaContinentes.get(position).getImg()=='3')
                imageView1.setImageResource(R.mipmap.africa);
            if (listaContinentes.get(position).getImg()=='4')
                imageView1.setImageResource(R.mipmap.asia);
            if (listaContinentes.get(position).getImg()=='5')
                imageView1.setImageResource(R.mipmap.oceania);
            return (item);
        }
    }
}
