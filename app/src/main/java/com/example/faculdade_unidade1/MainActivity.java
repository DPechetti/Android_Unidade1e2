package com.example.faculdade_unidade1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.faculdade_unidade1.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static String format(double x) {
        return String.format("%.2f", x);
    }

    public void enviarMensagem(View view){
        Intent intent = new Intent(this, Resultado.class);

        CheckBox cbFj = (CheckBox) findViewById(R.id.cbFeijao);
        CheckBox cbLt = (CheckBox) findViewById(R.id.cbLeite);
        CheckBox cbmcr = (CheckBox) findViewById(R.id.cbMacarrao);
        CheckBox cbfrfa = (CheckBox) findViewById(R.id.cbFarofa);
        CheckBox cbrfri = (CheckBox) findViewById(R.id.cbRefrigerante);
        CheckBox cbbttfrt = (CheckBox) findViewById(R.id.cbBatataFrita);
        RadioButton rdFormaPgto = (RadioButton) findViewById(R.id.rdDinheiro);
        EditText desc = (EditText) findViewById(R.id.etDesconto);

        double desconto = Double.parseDouble(desc.getText().toString());
        double valor = 0;
        String forma = "";
        int cont = 0;

        if(cbFj.isChecked()){
            valor += 2.69;
            cont++;
        }
        if(cbLt.isChecked()){
            valor += 2.70;
            cont++;
        }
        if(cbmcr.isChecked()){
            valor += 16.7;
            cont++;
        }
        if(cbfrfa.isChecked()){
            valor += 3.38;
            cont++;
        }
        if(cbrfri.isChecked()){
            valor += 3;
            cont++;
        }
        if(cbbttfrt.isChecked()){
            valor += 5;
            cont++;
        }
        if(rdFormaPgto.isChecked()){
            forma = "dinheiro";
        }else{
            forma = "cartão";
        }

        double total = valor - desconto;

        if(total < 0){
            total = 0;
        }

        String msg = "Item(ns) Selecionado(s): " + cont +
                "\nPagamento feito em " + forma +
                "\nTotal da compra: " + format(valor) +
                "\nDesconto " + format(desconto) +
                "\nValor final: "+ format(total);
        intent.putExtra(EXTRA_MESSAGE, msg);
        startActivity(intent);
    }
}
