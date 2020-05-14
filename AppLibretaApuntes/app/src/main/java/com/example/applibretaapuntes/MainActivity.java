package com.example.applibretaapuntes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Button btnIngresar, btnLimpiar, btnSalir;
    TextView tvRpta;
    ArrayList<String> Usuarios;
    ArrayList<String> Passwords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        tvRpta = (TextView) findViewById(R.id.tvRpta);

        Usuarios = new ArrayList<>();
        Passwords = new ArrayList<>();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje="";
                String usuario = etUser.getText().toString();
                String password = etPass.getText().toString();

                if (usuario.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Complete todos los Campos!!", Toast.LENGTH_SHORT).show();
                    procLimpiar();
                } else {
                        Usuarios.add(usuario);
                        Passwords.add(password);
                        for (int i=0; i < Usuarios.size(); i++) {
                            int a = i+1;
                            mensaje += ""+a + ": " + Usuarios.get(i).toString() + " , " + Passwords.get(i).toString()+"\n";
                        }
                        tvRpta.setText(""+mensaje);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procLimpiar();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    public void procLimpiar(){
        etUser.setText("");
        etPass.setText("");
        tvRpta.setText("");
    }
}
