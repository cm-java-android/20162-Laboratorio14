package br.java.android.laboratorio14;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TarefasOpenHelper extends SQLiteOpenHelper {

    private static final String NOME_DO_BANCO = "TarefasBancoDados";
    private static final int VERSAO_BANCO = 1;

    private Context contexto;

    public TarefasOpenHelper(Context context) {
        // Como não vamos utilizar o CursorFactory, que é um padrão que
        // evita uma sobrecarga de conexão, por isso que ele é nulo
        // A versão do banco independente do aplicativo
        // Caso haja alguma alteração no banco, esse valor deve ser alterado
        super(context, NOME_DO_BANCO, null, VERSAO_BANCO);
        this.contexto = context;

    }

    /**
     *  Aqui é feito a criação do banco de dados de Fato
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tarefas " +
                    "(_id integer PRIMARY KEY " +
                    "  AUTOINCREMENT, " +
                    "  tarefa text, " +
                    "  descricao text, " +
                    "  concluida boolean)";
        sqLiteDatabase.execSQL(sql);
    }

    /**
     * Aqui deve ser colocado um tratamento caso o banco seja alterado
     * Exemplo, migrando da versao 1 para tres
     * @param sqLiteDatabase
     * @param versaoAntiga numero da versao antiga
     * @param versaoNova Numero da versao nova
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoNova) {
        if(versaoAntiga == 1 && versaoNova == 3){
            // Atualiza algo no banco
        }

        // Evite colocar aqui instruções de DROP ALL TABLES e chamar o metodo onCreate
        // Isso além de ser feio, afeta consideravelmente a performance da aplicação
    }
}
