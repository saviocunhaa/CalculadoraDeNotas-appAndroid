package com.example.calculadoradenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //criando objetos para o id
    private EditText n1,n2,n3,n4, numeroFaltas;
    private Button btCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recuperando todos os IDs da Activity main
        n1 = findViewById(R.id.nota1);
        n2 = findViewById(R.id.nota2);
        n3 = findViewById(R.id.nota3);
        n4 = findViewById(R.id.nota4);
        numeroFaltas = findViewById(R.id.numeroFalta);
        btCalcular = findViewById(R.id.btCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        //instaciar botão calcular para ativar o clik
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log.i("bt", "Botão ok"); // Esse log serve para testar o eveto de clique que será visto no Logcat

                // Validação par campos vazios.
                if (TextUtils.isEmpty(numeroFaltas.getText().toString())){
                    numeroFaltas.setError("Preencha o Valor");
                    return;
                } else  if (TextUtils.isEmpty(n1.getText().toString())){
                    n1.setError("Preencha o Valor");
                    return;
                } else  if (TextUtils.isEmpty(n2.getText().toString())){
                    n2.setError("Preencha o Valor");
                    return;
                } else  if (TextUtils.isEmpty(n3.getText().toString())){
                    n3.setError("Preencha o Valor");
                    return;
                } else  if (TextUtils.isEmpty(n4.getText().toString())) {
                    n4.setError("Preencha o Valor");
                    return;
                }

                double mediaFinal;
                //receber todos os dados em estringe e converter para seus tipos especificos
                double nota1 = Double.parseDouble(n1.getText().toString());
                double nota2 = Double.parseDouble(n2.getText().toString());
                double nota3 = Double.parseDouble(n3.getText().toString());
                double nota4 = Double.parseDouble(n4.getText().toString());
                int numeroFalta = Integer.parseInt(numeroFaltas.getText().toString());


                mediaFinal = (nota1 + nota2 + nota3 + nota4)/4;

                //iniciar verificação de clausulas
                if (mediaFinal >= 7 && numeroFalta <= 20){
                    txtResultado.setText(String.format("Aluno Aprovado \n Média: %.2f ", mediaFinal));
                    txtResultado.setTextColor(getColor(R.color.green));
                }else if(numeroFalta > 20) {
                    txtResultado.setText("Aluno Reprovado por Falta \n Faltas: "+ numeroFalta);
                    txtResultado.setTextColor(getColor(R.color.red));
                }else {
                    txtResultado.setText(String.format("Aluno Reprovado \n Media: %.2f ", mediaFinal));
                    txtResultado.setTextColor(getColor(R.color.red));
                }

                }

        });

    }
}