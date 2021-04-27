package com.example.proy_electiva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Africa extends AppCompatActivity {

    private Button btnRegresar,btnCapital;
    private ListView lvLista;
    private ArrayList<csAmerica> listaPaises;
    private RadioButton rd1,rd2,rd3,rd4,rd5,rd6,rd7;
    private TextView t1,t2,t3,t4,t5,t6,t7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_africa);
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
        Africa();
        Adaptadorpersonas adaptador = new Adaptadorpersonas(this);
        ListView lv1 = (ListView)findViewById(R.id.lvLista);
        lv1.setAdapter(adaptador);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Africa.this, desglos.class);
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
            super(context,R.layout.activity_africa,listaPaises);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.america, null);
            TextView textview1 =(TextView)item.findViewById(R.id.txtpa);
            textview1.setText(listaPaises.get(position).getNombre());
            return (item);
        }
    }

    public void Africa()
    {
        listaPaises = new ArrayList<csAmerica>();
        listaPaises.add(new csAmerica("Camerun"));
        listaPaises.add(new csAmerica("Republica del congo"));
        listaPaises.add(new csAmerica("Costa de marfil"));
        listaPaises.add(new csAmerica("Egipto"));
        listaPaises.add(new csAmerica("Ghana"));
        listaPaises.add(new csAmerica("Marruecos"));
        listaPaises.add(new csAmerica("Nigeria"));
    }

    public void Validar(){

        if(rd1.isChecked()==true){
            t1.setText("Yaunde");
        }
        if(rd2.isChecked()==true){
            t2.setText("Brazzavile");
        }
        if(rd3.isChecked()==true){
            t3.setText("Yamusurk");
        }
        if(rd4.isChecked()==true){
            t4.setText("El cairo");
        }
        if(rd5.isChecked()==true){
            t5.setText("Accra");
        }
        if(rd6.isChecked()==true){
            t6.setText("Rabat");
        }
        if(rd7.isChecked()==true){
            t7.setText("Abuya");
        }
    }
}