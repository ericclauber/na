package br.com.ericclauberic.na;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import br.com.ericclauberic.na.controle.ToastListener;

public class ResultadoQuizActivity extends AppCompatActivity {
    //
    private InterstitialAd mInterstitial;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_quiz);
        //
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.texto_bar_grafico_emocional_activity));
        actionBar.setDisplayHomeAsUpEnabled(true);
        //
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String pontuacao = bundle.getString("pontuacao");
        //
        TextView txtPontuacao = (TextView) findViewById(R.id.activity_resultado_textview_pontuacao);
        txtPontuacao.setText(pontuacao);

        TextView txtDica = (TextView) findViewById(R.id.activity_resultado_textview_dica);
        // metódo dicaResultado valida a pontuação, e retorna a dica.
        txtDica.setText(dicaResultado(Integer.parseInt(pontuacao)));
        //
        // Chama anúncio intertitial
        chamaCarregaAdMobIntertitial();
        //

    }

    public String dicaResultado(int pontuacao) {
        String dica = "";
        if (pontuacao <= 25) {
            dica = this.getString(R.string.texto_pontuacao_menor25);
        } else if (pontuacao > 26 && pontuacao <= 50) {
            dica = this.getString(R.string.texto_pontuacao_entre25e50);
        } else if (pontuacao >= 51 && pontuacao <= 75) {
            dica = this.getString(R.string.texto_pontuacao_entre51e75);
        } else if (pontuacao > 75) {
            dica = this.getString(R.string.texto_pontuacao_acima75);
        }
        return dica;
    }


    public void chamaCarregaAdMobIntertitial() {
        //
        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new ToastListener(this) {
            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
            }
        });
        //
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitial.loadAd(adRequest);
        //

    }

    //
    //
    public void chamaAdMobIntertitial() {
        if (mInterstitial.isLoaded()) {
            mInterstitial.show();
        }
    }

    @Override
    protected void onPause() {
        chamaAdMobIntertitial();
        super.onPause();
    }
} // FIM
