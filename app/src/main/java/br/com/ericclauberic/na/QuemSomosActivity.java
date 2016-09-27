package br.com.ericclauberic.na;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import br.com.ericclauberic.na.controle.ToastListener;

public class QuemSomosActivity extends AppCompatActivity {

    private AdView adView;

    int tamanhoTexto = 20;
    TextView textViewZoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quem_somos);
        //textViewZoom = (TextView) findViewById(R.id.text_view_quem_somos);
       // tamanhoTexto = (int) textViewZoom.getTextSize();
        // Admob
        adView = (AdView) findViewById(R.id.quem_somos_activity_admob);
        adView.setAdListener(new ToastListener(this));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void onClickZoomMenos(View view) {

        if (tamanhoTexto == 5) {
        // nada a fazer
        } else {
            tamanhoTexto -= 5;
            alteraTamanhoFonte(tamanhoTexto);
        }




    }

    public void onClickZoomMais(View view) {

        if (tamanhoTexto == 35) {
            // nada a fazer
        } else {
            tamanhoTexto += 5;
            alteraTamanhoFonte(tamanhoTexto);
        }
    }

    public void alteraTamanhoFonte(int tamanho) {
        textViewZoom = (TextView) findViewById(R.id.text_view_quem_somos);
        textViewZoom.setTextSize(tamanho);
    }
}
