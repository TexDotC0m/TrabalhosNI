package br.fecapcpp.calculodesalario;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView Salario;
    private TextView Resultado;
    private RadioGroup RadioGroup;
    private RadioButton rbQuarenta, rbQuarentaECinco, rbCinquenta;
    private double porcentagemQuarenta, porcentagemQuarentaECinco, porcentagemCinquenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Salario = findViewById(R.id.Salario);
        Resultado = findViewById(R.id.Resultado);

        rbQuarenta = findViewById(R.id.rbQuarenta);
        rbQuarentaECinco = findViewById(R.id.rbQuarentaECinco);
        rbCinquenta = findViewById(R.id.rbCinquenta);

        porcentagemQuarenta = 1.4;
        porcentagemQuarentaECinco = 1.45;
        porcentagemCinquenta = 1.5;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view) {
        String salarioString = Salario.getText().toString();
        double salario = Double.parseDouble(salarioString);

        if (rbQuarenta.isChecked()) {
            salario *= porcentagemQuarenta;
        }
       if (rbQuarentaECinco.isChecked()) {
           salario *= porcentagemQuarentaECinco;
        }
        if (rbCinquenta.isChecked()) {
            salario *= porcentagemCinquenta;
        }
            DecimalFormat df = new DecimalFormat("#,##0.00");// Formata
            Resultado.setText("R$ " + df.format(salario));// Exibe o resultado formatado
    }
    }
