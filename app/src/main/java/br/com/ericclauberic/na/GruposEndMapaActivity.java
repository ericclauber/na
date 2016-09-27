package br.com.ericclauberic.na;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import br.com.ericclauberic.na.adapter.GruposAdapter;
import br.com.ericclauberic.na.controle.ListaDeCidadesInsercao;
import br.com.ericclauberic.na.controle.ToastListener;
import br.com.ericclauberic.na.dao.CidadesDAO;
import br.com.ericclauberic.na.dao.GruposDAO;
import br.com.ericclauberic.na.modelo.Cidades;
import br.com.ericclauberic.na.modelo.Grupos;

public class GruposEndMapaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewGrupos;
    private List<Grupos> gruposLista;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_grupos_end_mapa);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.texto_encontre_grupo_activity));
        actionBar.setDisplayHomeAsUpEnabled(true);
        //
        // AdMob
        adView = (AdView) findViewById(R.id.grupos_activity_admob);
        adView.setAdListener(new ToastListener(this));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        Spinner spinnerUF = (Spinner) findViewById(R.id.activity_grupos_uf_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterUF = ArrayAdapter.createFromResource(this,
                R.array.uf_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterUF.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerUF.setAdapter(adapterUF);
        spinnerUF.setOnItemSelectedListener(new UFSpinnerClass());
        //
        // ListView
//        listViewGrupos = (ListView) findViewById(R.id.activity_grupos_lista);
//        gruposLista = Grupos.getGrupos();
//        listViewGrupos.setAdapter(new GruposAdapter(this, gruposLista));
//        listViewGrupos.setOnItemClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        this.finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Grupos grupos = this.gruposLista.get(i);
        chamaMapa(grupos.getLatitude(), grupos.getLongitude());

    }

    public void chamaMapa(double latitude, double longitude) {
        Uri uriIntent = Uri.parse("geo:" + latitude + "," + longitude + "?z=20");
        //Uri uriIntent = Uri.parse("geo:" + latitude + "," + longitude + "?q=Paróquia+Nossa+Senhora+das+Dores,Fortaleza,CE");
        Intent intent = new Intent(Intent.ACTION_VIEW, uriIntent);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            //
            String mensagem = getString(R.string.texto_toast_abrir_mapa_grupos_activity);
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        }
    }

    class UFSpinnerClass implements AdapterView.OnItemSelectedListener {
        GruposDAO gruposDAO = new GruposDAO();
        CidadesDAO cidadesDAO = new CidadesDAO();
        ListaDeCidadesInsercao listaDeCidadesInsercao = new ListaDeCidadesInsercao();
        Context context;

        //List<Grupos> cidade = gruposDAO.listaGruposBancoCidade("CE");
        List<String> nomes = new ArrayList<String>();

        //
        //ArrayAdapter<String> adapterCidade = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item);
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

            //  List<Grupos> gruposList = gruposDAO.listaGruposBancoCidade("CE");
//                List<Cidades> cidadesList = listaDeCidadesInsercao.getListaDeCidade();

            List<Cidades> cidadesList = cidadesDAO.listaCidadesPorUF(String.valueOf(parent.getSelectedItem()));
//                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + v.);
            //Adicionando Nomes no ArrayList
            for (int i = 0; i < cidadesList.size(); i++) {
                Cidades cidades = cidadesList.get(i);
                nomes.add(cidades.getCidade());
            }

            Spinner spinnerCidade = (Spinner) findViewById(R.id.activity_grupos_cidade_spinner);
            //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(GruposEndMapaActivity.this, android.R.layout.simple_spinner_dropdown_item, nomes);
            ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinnerCidade.setAdapter(spinnerArrayAdapter);

//                Spinner spinnerCidade = (Spinner) findViewById(R.id.activity_grupos_cidade_spinner);
//
//// Create an ArrayAdapter using the string array and a default spinner layout
//                ArrayAdapter<CharSequence> adapterCidade = ArrayAdapter.createFromResource(v.getContext(),
//                        R.array.cidades_array, android.R.layout.simple_spinner_item);
//
//
//// Specify the layout to use when the list of choices appears
//                adapterCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//                spinnerCidade.setAdapter(adapterCidade);
            spinnerCidade.setOnItemSelectedListener(new CidadesSpinnerClass());
            //



        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    class CidadesSpinnerClass implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
        private ListView listViewGrupos;
        private List<Grupos> gruposLista;
        GruposDAO gruposDAO = new GruposDAO();


        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            //
            //   if (parent.getSelectedItem().equals("FORTALEZA")) {
//
            String cidade = (String) parent.getSelectedItem();

            listViewGrupos = (ListView) findViewById(R.id.activity_grupos_lista);
            //
            gruposLista = gruposDAO.listaGruposBancoCidade(String.valueOf(parent.getSelectedItem()));
            //
            listViewGrupos.setAdapter(new GruposAdapter(v.getContext(), gruposLista));
            listViewGrupos.setOnItemClickListener(this);
            //
            String mensagem = getString(R.string.texto_toast_abrir_mapa_grupos_activity);
            Toast toast = Toast.makeText(v.getContext(),mensagem, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            //    } else {
//                Toast.makeText(v.getContext(), "Nenhuma Cidade selecionadas ", Toast.LENGTH_SHORT).show();
            //  }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Grupos grupos = gruposDAO.listaTodosGruposBanco().get(i);//this.gruposLista.get(i);
//            Toast.makeText(view.getContext(), "O grupo é: " + grupos.getNomeGrupo(), Toast.LENGTH_SHORT).show();
            chamaMapa(grupos.getLatitude(), grupos.getLongitude());

        }
    }

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        if (i == 1) {
//
//            spi
//            TextView textView = (TextView) findViewById(R.id.grupo_text_view_temp);
//            textView.setText("Deu certo");
//            Toast.makeText(this,"Cidades selecionadas ", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this,"Nenhuma cidade ", Toast.LENGTH_SHORT).show();
//        }
//
//        Toast.makeText(this,"Selecionado item " + i, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
    //
    //

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println(">>>>>>>>>>>>>>>>>  Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(">>>>>>>>>>>>>>>>>  Destruido");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(">>>>>>>>>>>>>>>>>  Pausado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(">>>>>>>>>>>>>>>>>>  Stop");
    }


}
