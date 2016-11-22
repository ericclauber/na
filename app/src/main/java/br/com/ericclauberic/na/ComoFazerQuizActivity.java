package br.com.ericclauberic.na;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import br.com.ericclauberic.na.controle.ToastListener;

public class ComoFazerQuizActivity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_como_fazer_quiz);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.titulo_activity_como_fazer);
        actionBar.setDisplayHomeAsUpEnabled(true);

        adView = (AdView) findViewById(R.id.activity_como_fazer_quiz_admob);
        adView.setAdListener(new ToastListener(this));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
