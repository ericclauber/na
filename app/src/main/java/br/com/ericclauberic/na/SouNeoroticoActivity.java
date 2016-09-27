package br.com.ericclauberic.na;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import br.com.ericclauberic.na.controle.ToastListener;

public class SouNeoroticoActivity extends AppCompatActivity {

    private AdView adView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_neorotico);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // AdMob
        adView = (AdView) findViewById(R.id.sou_neurotico_activity_admob);
        adView.setAdListener(new ToastListener(this));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
