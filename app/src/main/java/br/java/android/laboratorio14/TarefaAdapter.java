package br.java.android.laboratorio14;


import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.List;
import java.util.zip.Inflater;

public class TarefaAdapter extends BaseAdapter {

    private List<Tarefa> tarefas;
    private Context contexto;
    private InstanciaVisao instanciaVisao;

    public TarefaAdapter(Context contextoParam, List<Tarefa> arrayTarefas){
        contexto = contextoParam;
        tarefas = arrayTarefas;
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Object getItem(int i) {
        return tarefas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater inflador = (LayoutInflater)
                    contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflador.inflate(R.layout.celula_tarefa,null);
            instanciaVisao = new InstanciaVisao();
            instanciaVisao.setTarefaCheckBox((CheckBox)
                    view.findViewById(R.id.tarefaCheckBox));
            instanciaVisao.setCelulaLayout((LinearLayout)
                    view.findViewById(R.id.celulaTarefaLayout));
            view.setTag(instanciaVisao);
        }else{
            instanciaVisao = (InstanciaVisao) view.getTag();
        }

        final Tarefa t = tarefas.get(i);
        instanciaVisao.getTarefaCheckBox().setText(t.getTarefa());
        instanciaVisao.getTarefaCheckBox().setChecked(t.isConcluida());

        // O Checkbox perde a função de seleção
        // Logo quando ela for pressionada, ira abrir uma nova tela com os detalhes da tarefa

        instanciaVisao.getCelulaLayout().setOnClickListener
                (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto,DetalheActivity.class);
                intent.putExtra("tarefa",t);
                contexto.startActivity(intent);
            }
        });

        return view;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
