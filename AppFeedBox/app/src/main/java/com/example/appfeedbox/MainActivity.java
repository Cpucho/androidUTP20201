package com.example.appfeedbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin,btnSignUp;
    EditText etUser, etPass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.etUsuario);
        etPass = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Encuesta_Inicio.class);

                String Usuario = etUser.getText().toString();
                String Password = etPass.getText().toString();

                if (!Usuario.isEmpty() && !Password.isEmpty()){

                    if (Usuario.equals("utp") && Password.equals("123")){

                        Toast.makeText(getApplicationContext(),"Bienvenido: "+Usuario+" !",Toast.LENGTH_LONG).show();
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(),"Usuario o Password no Existe!",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Complete todos los campos!",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Registro_Usuario.class);
                startActivity(intent);



            }
        });
    }
}
