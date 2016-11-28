package br.java.android.laboratorio14;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NovaTarefaActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_tarefa_layout);

        findViewById(R.id.salvarButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tarefa = ((EditText) findViewById(R.id.tarefaEditText))
                        .getText().toString();
                String descricao = ((EditText)findViewById(R.id.descricaoEditText))
                        .getText().toString();
                Tarefa t = new Tarefa();
                t.setTarefa(tarefa);
                t.setDescricao(descricao);
                t.setConcluida(false);
                TarefaNegocio.criarTarefa(t,NovaTarefaActivity.this);
                finish();
            }
        });

    }
}
