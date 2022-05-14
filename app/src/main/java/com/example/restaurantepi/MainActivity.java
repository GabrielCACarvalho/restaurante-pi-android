package com.example.restaurantepi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.restaurantepi.model.Produto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    /*private Button criarPedido;
    private Button listarProdutos;
    private Button adicionarItem;
    private CardView listaProdutos;*/

    private ObjectMapper objectMapper;

    private OkHttpClient client;

    List<Produto> produto;

    String teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new OkHttpClient();
        objectMapper = new ObjectMapper();


        getWebservice();

        System.out.println(teste);

        /*criarPedido = findViewById(R.id.CriarPedido);
        listarProdutos = findViewById(R.id.salvarProduto);
        adicionarItem = findViewById(R.id.listarProduto);
        listaProdutos = findViewById(R.id.ListaProdutos);

        criarPedido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

            }
        });*/


    }

    private void getWebservice() {
        final Request request = new Request.Builder().url("http://192.168.100.5:8081/produto/listar").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                teste = "fail";
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                teste = response.body().string();
            }
        });
    }
}