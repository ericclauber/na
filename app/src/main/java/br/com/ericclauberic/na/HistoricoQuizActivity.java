package br.com.ericclauberic.na;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.ericclauberic.na.adapter.HistoricoQuizAdapter;
import br.com.ericclauberic.na.dao.QuizDAO;
import br.com.ericclauberic.na.modelo.Quiz;

public class HistoricoQuizActivity extends AppCompatActivity {

    List<Quiz> quizLista;
    HistoricoQuizAdapter historicoQuizAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_quiz);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(this.getString(R.string.historico_quiz_titulo_barra));
        actionBar.setDisplayHomeAsUpEnabled(true);


        //
        final ListView listViewQuiz;

        QuizDAO quizDAO = new QuizDAO();
        //
        listViewQuiz = (ListView) findViewById(R.id.listView_historico_quiz);
        //
        quizLista = quizDAO.listaTodoHistoricoQuizBanco();
        //
        listViewQuiz.setAdapter(historicoQuizAdapter = new HistoricoQuizAdapter(this, quizLista));

        listViewQuiz.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                alertApagarHistorico(quizLista, position);
                return false;
            }
        });

    }

    public void chamaDeletaQuiz(Quiz quiz) {

        QuizDAO quizDAO = new QuizDAO();
        quizDAO.deletarQuiz(quiz);
        Toast.makeText(this, getString(R.string.texto_excluido_historico_activity), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_historico, menu);

        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /// valida o item da barra
        switch (item.getItemId()) {
            // finaliza e volta pra activity anterior
//            case android.R.id.home:
//                this.finish();
            // chama o método excluír e limpa a lista
            case R.id.menu_acao_configuracao:
                if (!this.quizLista.isEmpty()) {

                    alertApagarHistorico(quizLista);

                } else {
                    Toast.makeText(this, getString(R.string.text_nada_excluir_historico_activity), Toast.LENGTH_SHORT).show();
                }
        }


        return super.onOptionsItemSelected(item);
    }

    public void chamaDeletaTodoHistoricoQuiz(List<Quiz> quizList) {

        QuizDAO quizDAO = new QuizDAO();
        quizDAO.deletarListQuiz(quizList);
        Toast.makeText(this, getString(R.string.texto_historico_excluido_historico_activity), Toast.LENGTH_SHORT).show();

    }

    //
    // apaga todoo o histórico
    public void alertApagarHistorico(final List<Quiz> quizLista) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(HistoricoQuizActivity.this);
        //
        String mensagem = getString(R.string.texto_excluir_tudo_historico_activity);
        String excluir = getString(R.string.texto_excluir_historico_alert_historico_activity);
        //
        //  builder.setTitle(titulo);
        builder.setMessage(mensagem);
        //
        builder.setPositiveButton(excluir, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chamaDeletaTodoHistoricoQuiz(quizLista);
                //
                quizLista.removeAll(quizLista);
                //
                historicoQuizAdapter.notifyDataSetChanged();
            }
        });
        builder.setNeutralButton(getString(R.string.texto_cancelar_global), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    //
    // apaga único histórico
    public void alertApagarHistorico(final List<Quiz> quizLista, final int position) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(HistoricoQuizActivity.this);
        //
        String mensagem = getString(R.string.texto_exclui_historico_unico_historico_activity);
        String excluir = getString(R.string.texto_excluir_historico_alert_historico_activity);
        //
        //  builder.setTitle(titulo);
        builder.setMessage(mensagem);
        //
        builder.setPositiveButton(excluir, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Chama deleção do quiz
                chamaDeletaQuiz(quizLista.get(position));
                // Limpa o quiz na lista da posição
                quizLista.remove(position);
                // Atualiza a lista
                historicoQuizAdapter.notifyDataSetChanged();
            }
        });
        builder.setNeutralButton(getString(R.string.texto_cancelar_global), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

} //FIM
