package com.example.appfeedbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Encuesta_Inicio extends AppCompatActivity {

    TextView tvContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta__inicio);

        tvContenido = (TextView) findViewById(R.id.tvContenido);

        tvContenido.setText("La ponderación deberá tener en cuenta el siguiente criterio \n" +
                " de valoración \n "+
                "1: Muy Mal \n"+"2: Mal \n"+"3: Bueno \n"+"4: Demasiado Bueno \n"+"5: Muy Bueno");


    }
}
