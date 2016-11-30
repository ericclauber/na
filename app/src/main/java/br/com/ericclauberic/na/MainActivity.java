package br.com.ericclauberic.na;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import br.com.ericclauberic.na.controle.ToastListener;

public class MainActivity extends AppCompatActivity {

    private AdView adView;
    private ShareActionProvider mShareActionProvider;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //


        //
        //

        getMenuInflater().inflate(R.menu.menu_opcoes_main_activity, menu);

        MenuItem menuItem = menu.findItem(R.id.menu_item_compartilhar_app_main_activity);

        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);


        setShareIntent(compartilha());
        return super.onCreateOptionsMenu(menu);

    }
//
    public Intent compartilha() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "baixe o app");
        intent.setType("text/plain");
        //  startActivity(intent);

        return intent;
    }

    //
    private void setShareIntent(Intent intent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(intent);
        }
    }
    //

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_item_feedback:

                Intent intent = new Intent(this, EmailActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickQuiz(View view) {
        Intent intent = new Intent(this, IniciarQuizActivity.class);
        startActivity(intent);
    }

    public void onClickSobre(View view) {
        Intent intent = new Intent(this, QuemSomosActivity.class);
        startActivity(intent);

    }

    public void onClickSouNeorotico(View view) {
        Intent intent = new Intent(this, SouNeoroticoActivity.class);
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
