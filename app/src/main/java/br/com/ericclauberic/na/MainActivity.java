package br.com.ericclauberic.na;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import br.com.ericclauberic.na.controle.ToastListener;

public class MainActivity extends AppCompatActivity {
private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        // AdMob
        adView = (AdView) findViewById(R.id.main_admob);
        adView.setAdListener(new ToastListener(this));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);



    }

    public void onClickQuiz(View view) {
        Intent intent = new Intent(this,IniciarQuizActivity.class);
        startActivity(intent);
    }

    public void onClickSobre(View view) {
        Intent intent = new Intent(this,QuemSomosActivity.class);
        startActivity(intent);

    }

    public void onClickSouNeorotico(View view) {
        Intent intent = new Intent(this,SouNeoroticoActivity.class);
        startActivity(intent);

//        ArrayList<Grupos> gruposList = (ArrayList<Grupos>) new GruposDAO().listaTodosGruposBanco();
//
//        for (int i =0; i< gruposList.size(); i++) {
//            Grupos grupos = gruposList.get(i);
//
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + grupos.getNomeGrupo());
//        }
    }

    public void onClickMapaGrupos(View view) {

        Intent intent = new Intent(this, GruposEndMapaActivity.class);
        startActivity(intent);

//        //Uri uriIntent = Uri.parse("geo:-3.732134, -38.543449?z=20");
//        Uri uriIntent = Uri.parse("geo:-3.732134,-38.543449?q=Paróquia+Nossa+Senhora+das+Dores,Fortaleza,CE");
//        Intent intent = new Intent(Intent.ACTION_VIEW,uriIntent);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        } else {
//            Toast.makeText(this,"Nenhum aplicativo para abrir o mapa está instalado!",Toast.LENGTH_SHORT).show();
//        }
    }




    public void onClickGruposTemp(View view) {
        Intent intent = new Intent(this, TesteSpinnerActivity.class);
        startActivity(intent);
    }
}
