package com.example.proy_electiva1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CheckAmerica extends AppCompatActivity {
    private Button btnRegresar,btnCapital;
    private ListView lvLista;
    private ArrayList<csAmerica> listaPaises;
    private CheckBox rd1,rd2,rd3,rd4,rd5,rd6,rd7;
    private TextView t1,t2,t3,t4,t5,t6,t7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbutton);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnCapital = findViewById(R.id.btnCapital);
        rd1 = findViewById(R.id.rd1);
        rd2 = findViewById(R.id.rd2);
        rd3 = findViewById(R.id.rd3);
        rd4 = findViewById(R.id.rd4);
        rd5 = findViewById(R.id.rd5);
        rd6 = findViewById(R.id.rd6);
        rd7 = findViewById(R.id.rd7);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        America();
        Adaptadorpersonas adaptador = new Adaptadorpersonas(this);
        ListView lv1 = (ListView)findViewById(R.id.lvLista);
        lv1.setAdapter(adaptador);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckAmerica.this, Continentes.class);
                startActivity(intent);
            }
        });

        btnCapital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validar();
            }
        });

    }
    class Adaptadorpersonas extends ArrayAdapter<csAmerica>
    {
        AppCompatActivity appCompatActivity;
        Adaptadorpersonas (AppCompatActivity context ){
            super(context,R.layout.activity_checkbutton,listaPaises);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.check, null);
            TextView textview1 =(TextView)item.findViewById(R.id.txtpa);
            textview1.setText(listaPaises.get(position).getNombre());
            return (item);
        }
    }


    public void America()
    {
        listaPaises = new ArrayList<csAmerica>();
        listaPaises.add(new csAmerica("El salvador"));
        listaPaises.add(new csAmerica("Argentina"));
        listaPaises.add(new csAmerica("Canada"));
        listaPaises.add(new csAmerica("Chile"));
        listaPaises.add(new csAmerica("Estados Unidos"));
        listaPaises.add(new csAmerica("Brasil"));
        listaPaises.add(new csAmerica("Colombia"));
    }

    public void Validar(){

        if(rd1.isChecked()==true){
            t1.setText("San salvador");
        }
        if(rd2.isChecked()==true){
            t2.setText("Buenos Aires");
        }
        if(rd3.isChecked()==true){
            t3.setText("Ottawa");
        }
        if(rd4.isChecked()==true){
            t4.setText("Santiago");
        }
        if(rd5.isChecked()==true){
            t5.setText("Washington.D.C");
        }
        if(rd6.isChecked()==true){
            t6.setText("Brasilia");
        }
        if(rd7.isChecked()==true){
            t7.setText("Buenos Ares");
        }
    }
}
