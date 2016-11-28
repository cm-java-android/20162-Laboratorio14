package br.java.android.laboratorio14;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class PricipalActivity extends ListActivity {

    private List<Tarefa> tarefas;
    private TarefaAdapter tarefaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricipal);

        tarefas = TarefaNegocio.listarTarefas(this);
        tarefaAdapter = new TarefaAdapter(this,tarefas);
        setListAdapter(tarefaAdapter);

        findViewById(R.id.adicionarButton)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent novaTarefa = new Intent(PricipalActivity.this,NovaTarefaActivity.class);
                startActivity(novaTarefa);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        tarefas = TarefaNegocio.listarTarefas(this);
        tarefaAdapter.setTarefas(tarefas);
        tarefaAdapter.notifyDataSetChanged();
    }
}
