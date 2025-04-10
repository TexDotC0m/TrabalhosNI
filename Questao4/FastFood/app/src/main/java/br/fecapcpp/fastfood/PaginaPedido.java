package br.fecapcpp.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class PaginaPedido extends AppCompatActivity {

    private Button concluirPedido;
    private String NomePedido;
    private TextInputEditText EditarNome;
    private RadioButton rbOpcao1;
    private RadioButton rbOpcao2;
    private RadioButton rbOpcao3;
    private RadioButton rbOpcao4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_pedido);

        EditarNome = findViewById(R.id.ColocarNome);

         rbOpcao1= findViewById(R.id.rbOpcao1);
         rbOpcao2= findViewById(R.id.rbOpcao2);
         rbOpcao3= findViewById(R.id.rbOpcao3);
         rbOpcao4= findViewById(R.id.rbOpcao4);

        concluirPedido = findViewById(R.id.btnMenuConcluir);
        concluirPedido.setOnClickListener(view ->{
            Intent intent = new Intent(this, PaginaConclusaoPedido.class);
            NomePedido = EditarNome.getText().toString();

            intent.putExtra("nome",NomePedido);

            if(rbOpcao1.isChecked())intent.putExtra("Lanche","X-Burger");
            if(rbOpcao2.isChecked())intent.putExtra("Lanche","X-Salada");
            if(rbOpcao3.isChecked())intent.putExtra("Lanche","Vegetariano");
            if(rbOpcao4.isChecked())intent.putExtra("Lanche","HotCat");

            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}