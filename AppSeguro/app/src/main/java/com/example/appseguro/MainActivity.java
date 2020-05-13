package com.example.appseguro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spEmpleado;
    CheckBox cbAfp, cbMovilidad, cbRpc;
    Button btnCalcular, btnLimpiar, btnSalir;
    TextView tvRpta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spEmpleado = (Spinner) findViewById(R.id.spEmpleado);

        final String [] opciones = {"Asistente","Senior","Gerente"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spEmpleado.setAdapter(adapter);



        cbAfp = (CheckBox) findViewById(R.id.cbAfp);
        cbMovilidad = (CheckBox) findViewById(R.id.cbMovilidad);
        cbRpc = (CheckBox) findViewById(R.id.cbRpc);
        tvRpta = (TextView) findViewById(R.id.tvRspt);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tipoEmp = spEmpleado.getSelectedItem().toString();
                double pagoBruto = 0.0;
                double pagoNeto ;
                double desc = 0.0;

                switch(tipoEmp){
                    case "Asistente":
                        pagoBruto = 2400.0;
                        break;
                    case "Senior":
                        pagoBruto = 4800.0;
                        break;
                    case "Gerente":
                        pagoBruto = 10000.0;
                        break;
                }


                if (cbAfp.isChecked()){
                    desc = pagoBruto * 0.1;
                }
                if (cbMovilidad.isChecked()) {
                    desc = desc + 80;
                }
                if (cbRpc.isChecked()){
                    desc = desc + 20;
                }

                pagoNeto = pagoBruto - desc;

                tvRpta.setText("El Sueldo Neto  : S/. "+pagoNeto+ "\n"
                              +" Total Descuento: S/. " +desc+"");

            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spEmpleado.setSelection(0);
                cbAfp.setChecked(false);
                cbMovilidad.setChecked(false);
                cbRpc.setChecked(false);
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
