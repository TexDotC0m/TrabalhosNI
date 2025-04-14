package br.com.fecapcpp.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelecaoTamanhoPagamento extends AppCompatActivity {
    private RadioButton rbTamanho1;
    private RadioButton rbTamanho2;
    private RadioButton rbTamanho3;
    private RadioButton rbPagamento1;
    private RadioButton rbPagamento2;
    private int total;
    private String strTotal;
    private Button btnConcluir2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecao_tamanho_pagamento);

        rbTamanho1 = findViewById(R.id.rbTamanho1);
        rbTamanho2 = findViewById(R.id.rbTamanho2);
        rbTamanho3 = findViewById(R.id.rbTamanho3);
        rbPagamento1 = findViewById(R.id.rbPagamento1);
        rbPagamento2 = findViewById(R.id.rbPagamento2);
        btnConcluir2 = findViewById(R.id.btnContinuar2);

        Bundle bundle = getIntent().getExtras();
        strTotal = bundle.getString("total");
        total = Integer.parseInt(strTotal);

        btnConcluir2.setOnClickListener(view -> {
            Intent intent = new Intent(this, ResumoPedido.class);

            if (!rbTamanho1.isChecked() && !rbTamanho2.isChecked() && !rbTamanho3.isChecked()) {
                rbTamanho1.setError("Selecione um tamanho de pizza");
                rbTamanho2.setError("Selecione um tamanho de pizza");
                rbTamanho3.setError("Selecione um tamanho de pizza");
                return;
            }

            if (!rbPagamento1.isChecked() && !rbPagamento2.isChecked()) {
                rbPagamento1.setError("Selecione uma forma de pagamento");
                rbPagamento2.setError("Selecione uma forma de pagamento");
                return;
            }

            if (rbTamanho1.isChecked()) {
                intent.putExtra("tamanho", "pequena");
                total += 45;
            } else if (rbTamanho2.isChecked()) {
                intent.putExtra("tamanho", "média");
                total += 50;
            } else if (rbTamanho3.isChecked()) {
                intent.putExtra("tamanho", "grande");
                total += 55;
            }

            if (rbPagamento1.isChecked()) {
                intent.putExtra("pagamento", "cartão");
            } else if (rbPagamento2.isChecked()) {
                intent.putExtra("pagamento", "dinheiro");
            }

            intent.putExtra("sabores", getIntent().getStringExtra("sabores"));
            intent.putExtra("total", String.valueOf(total));
            startActivity(intent);
        });

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}