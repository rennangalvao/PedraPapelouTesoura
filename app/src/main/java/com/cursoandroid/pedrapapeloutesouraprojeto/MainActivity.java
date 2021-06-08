package com.cursoandroid.pedrapapeloutesouraprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selecionadoPedra(View view){

        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){

        this.opcaoSelecionada( "papel" );
    }

    public void selecionadoTesoura(View view){

        this.opcaoSelecionada( "tesoura" );
    }

    public void opcaoSelecionada( String escolhaUsuario){

        TextView textpResultado = findViewById(R.id.testeResultado);
        ImageView imageResultado = findViewById(R.id.imageResultado);
        int numero = new Random().nextInt( 3 ); //0,1,2
        String[] opcoes = { "pedra", "papel", "tesoura" };
        String escolhaApp = opcoes[ numero ];

        switch ( escolhaApp){
            case "pedra":

                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":

                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if( (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){ // App ganhador
            textpResultado.setText("Você perdeu :( " );

        }else if( (escolhaApp == "papel" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "pedra" && escolhaUsuario == "papel") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "pedra")
        ){// Usuario Ganhador
            textpResultado.setText("Você ganhou ;) " );

        }else{ // Empate
            textpResultado.setText("Empatamos :D" );
        }



    }
}