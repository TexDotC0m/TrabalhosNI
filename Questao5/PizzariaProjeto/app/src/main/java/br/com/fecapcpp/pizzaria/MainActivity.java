package br.com.fecapcpp.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox sabor1;
    private CheckBox sabor2;
    private CheckBox sabor3;
    private CheckBox sabor4;
    private int total;

    private Button botaoInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sabor1 = findViewById(R.id.cbSabor1);
        sabor2 = findViewById(R.id.cbSabor2);
        sabor3 = findViewById(R.id.cbSabor3);
        sabor4 = findViewById(R.id.cbSabor4);
        total = 0;
        botaoInicio = findViewById(R.id.btnProximaPagina);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void ProximaTela(View view) {
        Intent intent = new Intent(this, SelecaoTamanhoPagamento.class);
        StringBuilder sabores = new StringBuilder();

        if (!sabor1.isChecked() && !sabor2.isChecked() && !sabor3.isChecked() && !sabor4.isChecked()) {
            sabor1.setError("Selecione pelo menos um sabor de pizza");
            sabor2.setError("Selecione pelo menos um sabor de pizza");
            sabor3.setError("Selecione pelo menos um sabor de pizza");
            sabor4.setError("Selecione pelo menos um sabor de pizza");

        } else {
            if (sabor1.isChecked()) {
                sabores.append("Calabresa, ");
                total += 5;
            }
            if (sabor2.isChecked()) {
                sabores.append("Portuguesa, ");
                total += 7;
            }
            if (sabor3.isChecked()) {
                sabores.append("Marguerita, ");
                total += 4;
            }
            if (sabor4.isChecked()) {
                sabores.append("4 Queijos, ");
                total += 9;
            }

            if (sabores.length() > 2) {
                sabores.setLength(sabores.length() - 2);
            }
            intent.putExtra("sabores", sabores.toString());
            intent.putExtra("total", String.valueOf(total));
            startActivity(intent);
        }
    }

}