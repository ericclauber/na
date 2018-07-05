package br.com.ericclauberic.na;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Date;
import java.util.List;

import br.com.ericclauberic.na.adapter.QuizRecyclerViewAdapter;
import br.com.ericclauberic.na.controle.ToastListener;
import br.com.ericclauberic.na.dao.QuizDAO;
import br.com.ericclauberic.na.modelo.PerguntasQuiz;
import br.com.ericclauberic.na.modelo.Quiz;

public class QuizEmocionalActivity extends FragmentActivity {

    private AdView adView;
    private RecyclerView recyclerView;
    QuizRecyclerViewAdapter quizRecyclerViewAdapter;
    public static final String STATE_RECYCLER = "recycler";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_emocional);

        // Admob
        adView = (AdView) findViewById(R.id.quiz_activity_admob);
        adView.setAdListener(new ToastListener(this));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        recyclerView = (RecyclerView) findViewById(R.id.quiz_emocional_recycle_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        this.quizRecyclerViewAdapter = new QuizRecyclerViewAdapter();
        recyclerView.setAdapter(quizRecyclerViewAdapter);

        if (savedInstanceState != null) {
            recyclerView = savedInstanceState.getParcelable(String.valueOf(quizRecyclerViewAdapter));
        }
    }

    public void onClickSalvarQuiz(View view) {

        List<PerguntasQuiz> perguntasQuizList = quizRecyclerViewAdapter.getPerguntasQuizList();

        int pontuacao = 0;
        boolean ok = true;

        for (int i = 0; i < perguntasQuizList.size(); i++) {

            if (perguntasQuizList.get(i).getResposta() == -1) {

                alertRespostasQuiz(i + 1);
                ok = false;
                break;

            } else {

                pontuacao += perguntasQuizList.get(i).getResposta();
            }
        }

        if (ok == true) {
            // salva Quiz
            chamaSalvarQuiz(pontuacao);
            // passa e mostra resultado em ResultadoQuizActivity
            Bundle bundle = new Bundle();
            bundle.putString("pontuacao", String.valueOf(pontuacao));
            Intent intent = new Intent(this, ResultadoQuizActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            this.finish();
        }
    }

    public boolean chamaSalvarQuiz(int percResultado) {
        boolean ok = true;

        Quiz quiz = new Quiz();
        QuizDAO quizDAO = new QuizDAO();
        //
        quiz.setPercResultado(percResultado);
        quiz.setDataQuiz(new Date());
        //
        ok = quizDAO.salvarQuiz(quiz);
        //
        return ok;
    }

    public void alertRespostasQuiz(final int item) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(QuizEmocionalActivity.this);

        String mensagem = getString(R.string.texto_item_nao_respondido_quiz_activity) + " \""
                + item + "\" " + getString(R.string.texto_nao_respondido_quiz_activity);
        String responder = this.getString(R.string.texto_alert_responder_quiz);

        builder.setMessage(mensagem);

        builder.setNeutralButton(responder, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                recyclerView.smoothScrollToPosition(item - 1);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
