package br.com.ericclauberic.na;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import br.com.ericclauberic.na.controle.ToastListener;

public class IniciarQuizActivity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_quiz);
        //
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.legenda_icone_quiz_emocional));
        actionBar.setDisplayHomeAsUpEnabled(true);
        // AdMOB
        adView = (AdView) findViewById(R.id.activity_iniciar_quiz_admob);
        adView.setAdListener(new ToastListener(this));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void onClickIniciarQuiz(View view) {
        Intent intent = new Intent(this, QuizEmocionalActivity.class);
        startActivity(intent);
    }

    public void onClickComoFazer(View view) {
        Intent intent = new Intent(this, ComoFazerQuizActivity.class);
        startActivity(intent);
    }

    public void onClickHistorico(View view) {

        Intent intent = new Intent(this, HistoricoQuizActivity.class);
        startActivity(intent);

    }


} // FIM
