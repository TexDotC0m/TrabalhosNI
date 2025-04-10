package br.fecapcpp.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaginaConclusaoPedido extends AppCompatActivity {
 private Button voltar;
 private String lanche;
 private String nome;
 private TextView txtNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_conclusao_pedido);

        txtNome = findViewById(R.id.TextoPedido);

        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        lanche = bundle.getString("Lanche");
        txtNome.setText("Muito obrigado " +nome+ "! O seu pedido do Lanche: "+lanche+" Já está sendo preparado!");

        voltar = findViewById(R.id.btnVoltar);
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