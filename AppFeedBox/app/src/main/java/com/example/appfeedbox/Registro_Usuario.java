package com.example.appfeedbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Registro_Usuario extends AppCompatActivity {

    Spinner spTipoUser;
    Button  btnRegisUser ,btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__usuario);

        btnRegisUser = (Button) findViewById(R.id.btnRegUser);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        spTipoUser = (Spinner) findViewById(R.id.spTipoUser);

        final String[] opcs = {"Administrador","Usuario"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcs);
        spTipoUser.setAdapter(adapter);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
