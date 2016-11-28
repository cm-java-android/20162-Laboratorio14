package br.java.android.laboratorio14;

import android.text.Layout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Esse é o padrão ViewHolder
 * Essa classe ira guardar a instancia desse Layout
 * Evitando que seja chamado varias vezes o metodo findViewByID
 * fazendo com que a performance da aplicação melhore consideravelmente
 */
public class InstanciaVisao {

    private CheckBox tarefaCheckBox;
    private LinearLayout celulaLayout;

    public CheckBox getTarefaCheckBox() {
        return tarefaCheckBox;
    }

    public void setTarefaCheckBox(CheckBox tarefaCheckBox) {
        this.tarefaCheckBox = tarefaCheckBox;
    }

    public LinearLayout getCelulaLayout() {
        return celulaLayout;
    }

    public void setCelulaLayout(LinearLayout celulaLayout) {
        this.celulaLayout = celulaLayout;
    }
}
