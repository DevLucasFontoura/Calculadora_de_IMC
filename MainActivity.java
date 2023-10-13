package com.example.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);


    }

    public void calcularImc(View view){

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura * altura);



        if (resultado < 19) {
            textResultado.setText("Abaixo do Peso: Seu índice de massa corporal indica que você está abaixo do peso ideal.");
        } else if (resultado < 25) {
            textResultado.setText("Peso Normal: Seu índice de massa corporal está dentro da faixa de peso saudável.");
        } else if (resultado < 30) {
            textResultado.setText("Sobrepeso: Seu índice de massa corporal indica que você está com sobrepeso.");
        } else if (resultado < 40) {
            textResultado.setText("Obesidade Tipo I: Seu índice de massa corporal indica obesidade de grau I.");
        } else {
            textResultado.setText("Obesidade Tipo II: Seu índice de massa corporal indica obesidade de grau II ou superior.");
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }



}