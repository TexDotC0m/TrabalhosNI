package br.fecapcpp.lojavirtual2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class PaginaCadastro extends AppCompatActivity {
    private Button concluir;
    private String Nome;
    private TextInputEditText EditarNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_cadastro);

        EditarNome = findViewById(R.id.EditarNome);

        concluir = findViewById(R.id.Concluir);
        concluir.setOnClickListener(view ->{
            Intent intent = new Intent(this, PaginaConclusao.class);
             Nome = EditarNome.getText().toString();

            intent.putExtra("nome",Nome);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}