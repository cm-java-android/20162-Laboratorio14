package br.java.android.laboratorio14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class DetalheActivity extends Activity {

    private Tarefa tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_layout);

        tarefa = (Tarefa) getIntent().getSerializableExtra("tarefa");

        ((TextView)findViewById(R.id.tarefaTextView))
                .setText(tarefa.getTarefa());
        ((TextView)findViewById(R.id.descricaoTextView))
                .setText(tarefa.getDescricao());
        ((CheckBox)findViewById(R.id.concluidoCheckBox))
                .setChecked(tarefa.isConcluida());

        findViewById(R.id.excluirButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TarefaNegocio.apagarTarefa(tarefa.getId(),DetalheActivity.this);
                finish();
            }
        });

        findViewById(R.id.concluirButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarefa.setConcluida(true);
                TarefaNegocio.atualizarTarefa(tarefa,DetalheActivity.this);
                finish();
            }
        });

    }
}
