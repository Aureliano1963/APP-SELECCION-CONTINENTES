package com.example.proy_electiva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class result_RadioB extends AppCompatActivity {
    private ListView paisesListView;
    private ListView lagosRiosVolcanesList;
    private Button buttonRegresar,buttonSiguiente;
    private ArrayList<csContinente> listaContinentes;
    TextView continenteTextView;
    TextView tipoVistatext;
    Element[] rios = {
            new Element("TÁMESIS", 0),new Element("VOLGA", 0),new Element("SENA", 0),new Element("DANUBIO", 0),
            new Element("MISISIPI", 1),new Element("COLORADO", 1), new Element("MISURI.", 1),new Element("RÍO GRANDE", 1),
            new Element("DARLING", 2), new Element("MURRAY", 2),new Element("WAIKATO", 2),new Element("CLUTHA", 2),
            new Element("OBI", 3),new Element("AMUR", 3),new Element("INDO", 3), new Element("GANGES", 3),
            new Element("NILO", 4),new Element("CONGO", 4),new Element("NÍGER", 4),new Element("SENEGAL", 4)};
    Element[] lagos = {
            new Element("LÁDOGA", 0), new Element("ONEGA",0),new Element("VÄNERN", 0),  new Element("PEIPUS",0),
            new Element("SUPERIOR", 1), new Element("HURÓN", 1),new Element("LAGO NICARAGUA", 1), new Element(" MARACAIBO", 1),
            new Element("EYRE.", 2), new Element("TORRENS.", 2),new Element("GAIRDNER", 2), new Element("MACKAY", 2),
            new Element("BAIKAL", 3), new Element("BALJASH", 3),new Element("KARA BOGAZ GOL", 3), new Element("ARAL", 3),
            new Element("VICTORIA", 4), new Element("TANGANICA", 4), new Element("MALAUI", 4),new Element("BANGWEULU", 4)};

    Element[] volcanes = {
            new Element("ARTHUR’S SEAT", 0), new Element("MONTE DEL TEIDE", 0), new Element("MONTE VESUBIO", 0), new Element("MONTE ETNA", 0),
            new Element("VOLCÁN DE COLIMA", 1), new Element("MONTE SANTA HELENA", 1), new Element("POPOCATÉPETL", 1), new Element("VOLCÁN DE SAN SALVADOR", 1),
            new Element("RUAPEHU", 2), new Element("ULAWUN", 2), new Element("NGAURUHOE", 2), new Element("MANAM", 2),
            new Element("EL PINATUBO.", 3), new Element("EL MERAPI", 3), new Element("EL TAAL.", 3), new Element("VOLCÁN KRAKATOA.", 3),
            new Element("NYAMURAGIRA", 4), new Element("KILIMANJARO", 4), new Element("KARTHALA", 4), new Element("NYIRAGONGO", 4)};

    Element[] paises = {
            new Element("ALEMANIA", 0), new Element("ESPAÑA", 0), new Element("ESLOVAQUIA", 0), new Element("VATICANO", 0), new Element("RUSIA", 0),new Element("BULGARIA", 0), new Element("ITALIA", 0),
            new Element("EL SALVADOR", 1), new Element("ESTADOS UNIDOS", 1), new Element("CANADÁ", 1), new Element("COLOMBIA", 1), new Element("BRASIL", 1),new Element("ARGENTINA", 1), new Element("MÉXICO", 1),
            new Element("NUEVA ZELANDA", 2), new Element("AUSTRALIA", 2), new Element("FIYI", 2), new Element("KIRIBATI", 2), new Element("ISLAS MARSHALL", 2),new Element("MICRONESIA", 2), new Element("NAURU", 2),
            new Element("CATAR", 3), new Element("JAPÓN", 3), new Element("ISRAEL", 3), new Element("LÍBANO", 3), new Element("PAKISTÁN", 3),new Element("TAILANDIA", 3), new Element("CHINA", 3),
            new Element("EGIPTO", 4), new Element("NÍGER", 4), new Element("KENIA", 4), new Element("MADAGASCAR", 4), new Element("NIGERIA", 4),new Element("UGANDA", 4), new Element("TANZANIA", 4)};
    int tipoVista;
    int tipoInfo;
    private String continenteSelecionado = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__radio_b);


        Bundle b = getIntent().getExtras();
        String[] resultArr = b.getStringArray("selectedItems");
        
        if(resultArr.length > 0)
        {
            continenteSelecionado = resultArr[0];
        }
        tipoVista = b.getInt("tipoVista");
        tipoInfo = b.getInt("tipoInfo");
        paisesListView = findViewById(R.id.outputList);
        tipoVistatext = findViewById(R.id.tipoVistatext);
        lagosRiosVolcanesList =findViewById(R.id.lagosRiosVolcanesList);
        continenteTextView = findViewById(R.id.continenteTextView);
        buttonRegresar  = findViewById(R.id.buttonRegresar);
        buttonSiguiente = findViewById(R.id.buttonSiguiente);

        buttonRegresar.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(result_RadioB.this, select_continent.class);
                startActivity(intent);
            }
        });

        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result_RadioB.this, desglos.class);
                startActivity(intent);
            }
        });
        cargarPaises();
        continenteTextView.setText(continenteSelecionado);
        Log.d("Tipo vista ", tipoVista + "");
        switch (tipoVista)
        {
            //rios
            case 0:
                cargarRios();
                tipoVistatext.setText("Rios");
                break;
            //lagos
            case 1:
                cargarLagos();
                tipoVistatext.setText("Lagos");
                break;
            //volcanes
            case 2:
                cargarVolcanes();
                tipoVistatext.setText("Volcanes");
                break;
            default:
        }
    }
    
    private void cargarPaises()
    {
        switch (continenteSelecionado)
        {
            //id 0
            case "Europa":
                cargarPaisesPorContinenete(0);
                break;
            //id 1
            case "America":
                cargarPaisesPorContinenete(1);
                break;
            //id 2
            case "Oceania":
                cargarPaisesPorContinenete(2);
                break;
            //id 3
            case "Asia":
                cargarPaisesPorContinenete(3);
                break;
            //id 4
            case "Africa":
                cargarPaisesPorContinenete(4);
                break;
        }
    }
    
    private void cargarPaisesPorContinenete(int continente)
    {
        List<String> list = new ArrayList<>();
        for (Element item: paises) {
            if(item.continente == continente)
            {
                list.add(item.nombre);
            }
        }
        llenarPaises(list);
    }
    
    private void cargarRios()
    {
        Log.d("Contienente", continenteSelecionado);
        switch (continenteSelecionado)
        {
            //id 0
            case "Europa":
                cargarRioPorContinenete(0);
                break;
            //id 1
            case "America":
                cargarRioPorContinenete(1);
                break;
            //id 2
            case "Oceania":
                cargarRioPorContinenete(2);
                break;
            //id 3
            case "Asia":
                cargarRioPorContinenete(3);
                break;
            //id 4
            case "Africa":
                cargarRioPorContinenete(4);
                break;
        }
    }
    
    private void cargarRioPorContinenete(int continente)
    {
        List<String> list = new ArrayList<>();
        for (Element item: rios) {
            if(item.continente == continente)
            {
                list.add(item.nombre);
            }
        }
        llenarListaDos(list);
    }
    
    private void cargarVolcanes()
    {
        
        switch (continenteSelecionado)
        {
            //id 0
            case "Europa":
                cargarVolcanesPorContinenete(0);
                break;
            //id 1
            case "America":
                cargarVolcanesPorContinenete(1);
                break;
            //id 2
            case "Oceania":
                cargarVolcanesPorContinenete(2);
                break;
            //id 3
            case "Asia":
                cargarVolcanesPorContinenete(3);
                break;
            //id 4
            case "Africa":
                cargarVolcanesPorContinenete(4);
                break;
        }
    }
    
    private void cargarVolcanesPorContinenete(int continente)
    {
        List<String> list = new ArrayList<>();
        for (Element item: volcanes) {
            if(item.continente == continente)
            {
                list.add(item.nombre);
            }
        }
        llenarListaDos(list);
    }
    
    private void cargarLagos()
    {
        
        switch (continenteSelecionado)
        {
            //id 0
            case "Europa":
                cargarLagosPorContinenete(0);
                break;
            //id 1
            case "America":
                cargarLagosPorContinenete(1);
                break;
            //id 2
            case "Oceania":
                cargarLagosPorContinenete(2);
                break;
            //id 3
            case "Asia":
                cargarLagosPorContinenete(3);
                break;
            //id 4
            case "Africa":
                cargarLagosPorContinenete(4);
                break;
        }
    }
    
    private void cargarLagosPorContinenete(int continente)
    {
        List<String> list = new ArrayList<>();
        for (Element item: lagos) {
            if(item.continente == continente)
            {
                list.add(item.nombre);
            }
        }
        llenarListaDos(list);
    }
    
    private void llenarListaDos(List<String> lista)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        lagosRiosVolcanesList.setAdapter(adapter);
    }
    
    private void llenarPaises(List<String> lista)
    {
        //lleno con radioButton
        if(tipoInfo == 0)
        {
        
        }
        //lleno con checkBox
        else
        {
        
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, lista);
        paisesListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        paisesListView.setAdapter(adapter);
    }
    
    class Element
    {
        public String nombre;
        public int continente;
        public Element(String nombre, int continente)
        {
            this.nombre = nombre;
            this.continente = continente;
        }

    }

}