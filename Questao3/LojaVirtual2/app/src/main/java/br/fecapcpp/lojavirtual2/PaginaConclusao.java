package br.fecapcpp.lojavirtual2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaginaConclusao extends AppCompatActivity {
    private Button voltar;
    private TextView ColocarNome;
    private String NomeColocado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_conclusao);
        voltar = findViewById(R.id.btnVoltar);

        ColocarNome = findViewById(R.id.MensagemConclusao3);
        NomeColocado = ColocarNome.getText().toString();

        Bundle bundle = getIntent().getExtras();
        NomeColocado = bundle.getString("nome");
        ColocarNome.setText(NomeColocado);

        voltar.setOnClickListener(view ->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}