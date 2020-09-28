package com.example.practicacalificada1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText et_peso,et_altura;
    TextView resultado_imc,recomendacion_imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_peso = findViewById(R.id.et_peso);
        et_altura = findViewById(R.id.et_altura);

        resultado_imc = findViewById(R.id.resultado_imc);
        recomendacion_imc = findViewById(R.id.recomendacion_imc);
        Button btn_calcular = findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat imcformato = new DecimalFormat("#.##");
                String peso = et_peso.getText().toString();
                String altura = et_altura.getText().toString();

                Double imc = (Double.parseDouble(peso)/ (Double.parseDouble(altura) * Double.parseDouble(altura)));

                resultado_imc.setText("Para un peso de " + peso + " Kg y una Talla de " + altura + " metros, su IMC es: "+ imcformato.format(imc));

                if(imc < 18.5)
                {
                    recomendacion_imc.setText("Peso insuficiente");
                }
                if((imc >= 18.5) && (imc <= 24.9))
                {
                    recomendacion_imc.setText("Normal");
                }
                if((imc >= 25.0) && (imc <= 29.9))
                {
                    recomendacion_imc.setText("Sobrepeso");
                }
                if((imc >= 30.0)&& (imc <= 34.9))
                {
                    recomendacion_imc.setText("Obesidad tipo I");
                }
                if((imc >= 35.0) && (imc <= 39.9))
                {
                    recomendacion_imc.setText("Obesidad tipo II");
                }
                if((imc >= 40.0) && (imc <= 49.9))
                {
                    recomendacion_imc.setText("Obesidad tipo III (Morvida)");
                }
                if(imc >= 50.0)
                {
                    recomendacion_imc.setText("Obesidad tipo IV (Extrema)");
                }


            }
        });





    }
}