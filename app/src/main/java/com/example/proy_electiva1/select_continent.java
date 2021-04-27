package com.example.proy_electiva1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

public class select_continent extends Activity implements OnClickListener {
    Button buttonSelect;
    Button buttonAtras;
    ListView listView;
    ArrayAdapter<String> adapter;
    RadioButton rbtnRios;
    RadioButton rbtnLagos;
    RadioButton rbtnVolcanes;
    RadioButton rbtnRadio;
    RadioButton rbtnCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_continent);

        findViewsById();

        String[] continentes = getResources().getStringArray(R.array.continentes);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, continentes);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        buttonSelect.setOnClickListener(this);

    }


    private void findViewsById() {
        listView = (ListView) findViewById(R.id.list);
        buttonSelect = (Button) findViewById(R.id.btnSelect);
        buttonAtras = (Button) findViewById(R.id.btnRegresar);
        //Radio Button vista
        rbtnRios = findViewById(R.id.rbtnRios);
        rbtnLagos = findViewById(R.id.rbtnLagos);
        rbtnVolcanes = findViewById(R.id.rbtnVolcanes);
        //Radio Button tipo de informacion
        rbtnRadio = findViewById(R.id.rbtnRadio);
        rbtnCheckBox = findViewById(R.id.rbtnCheckBox);

        buttonAtras.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(select_continent.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public void onClick(View v) {
        SparseBooleanArray checked = listView.getCheckedItemPositions();
       // listView.setMultiChoiceModeListener();
        ArrayList<String> selectedItems = new ArrayList<String>();
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapter
            int position = checked.keyAt(i);
            // Add sport if it is checked i.e.) == TRUE!
            if (checked.valueAt(i))
                selectedItems.add(adapter.getItem(position));
        }
        //tipo vista selecionado
        int tipoVistaSelecionado = 0;
        if(rbtnRios.isChecked())
        {
            tipoVistaSelecionado = 0;
        }
        else if(rbtnLagos.isChecked())
        {
            tipoVistaSelecionado = 1;
        }
        else
        {
            tipoVistaSelecionado = 2;
        }
        //tipo informacion selecionado
        int tipoInformacionSelecionado = 0;
        if(rbtnRadio.isChecked())
        {
            tipoInformacionSelecionado = 0;
        }
        else
        {
            tipoInformacionSelecionado = 1;
        }
        String[] outputStrArr = new String[selectedItems.size()];
        for (int i = 0; i < selectedItems.size(); i++) {
            outputStrArr[i] = selectedItems.get(i);
        }

        Intent intent = new Intent(getApplicationContext(),
                result_RadioB.class);

        // Create a bundle object
        Bundle b = new Bundle();
        //pasar datos a mi actividad llamada
        b.putStringArray("selectedItems", outputStrArr);
        b.putInt("tipoVista", tipoVistaSelecionado);
        b.putInt("tipoInfo", tipoInformacionSelecionado);
        // Add the bundle to the intent.
        intent.putExtras(b);

        // start the ResultActivity

        startActivity(intent);

    }
}
