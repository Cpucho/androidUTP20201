package com.example.apppagohoras;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etHoras;
    Spinner spinner1;
    TextView tvRpta;
    Button btnCalcular, btnLimpiar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHoras = (EditText) findViewById(R.id.etHoras);
        tvRpta  = (TextView) findViewById(R.id.tvRpta);
        btnCalcular = (Button) findViewById(R.id.btCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        spinner1 = (Spinner) findViewById(R.id.spTipoH);

        //CARGAMOS ITEM AL SPINNER
        final String  [] opciones = {"1","2","3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinner1.setAdapter(adapter);

        //PROCEDIMIENTOS
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horas = Integer.parseInt(etHoras.getText().toString());
                String tipoHora = spinner1.getSelectedItem().toString();
                int PagoTot = 0;

                switch (tipoHora){
                    case "1" :
                        PagoTot = 65 * horas;
                        break;
                    case "2" :
                        PagoTot = 75 * horas;
                        break;
                    case "3" :
                        PagoTot = 95 * horas;
                        break;
                }
                tvRpta.setText("Total a Pagar: S/. " + PagoTot + "");
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etHoras.setText("");
                spinner1.setSelection(0);
                tvRpta.setText("");
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


    }
}
