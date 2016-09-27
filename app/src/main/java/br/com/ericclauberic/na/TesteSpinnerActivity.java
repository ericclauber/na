package br.com.ericclauberic.na;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ericclauberic.na.controle.ListaDeGruposInsercao;
import br.com.ericclauberic.na.dao.GruposDAO;
import br.com.ericclauberic.na.modelo.Grupos;

public class TesteSpinnerActivity extends AppCompatActivity {

    private Spinner spn1;
    private List<String> nomes = new ArrayList<String>();
    private String nome;
    GruposDAO gruposDAO = new GruposDAO();
    ListaDeGruposInsercao listaDeGruposInsercao = new ListaDeGruposInsercao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_spinner);

        //List<Grupos> gruposList = listaDeGruposInsercao.getListaDeGrupos();
        List<Grupos> gruposList = gruposDAO.listaGruposBancoCidade("CE");
        //Adicionando Nomes no ArrayList
        for (int i = 0; i < gruposList.size(); i++) {
            Grupos grupos = gruposList.get(i);
            nomes.add(grupos.getCidade());
  //          System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + grupos.getCidade());
//            nomes.add("João");
//            nomes.add("Maria");
//            nomes.add("José");
//            nomes.add("Paulo");
//            nomes.add("Adriana");
        }

        //Identifica o Spinner no layout
        spn1 = (Spinner) findViewById(R.id.teste_spinner);
        //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nomes);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn1.setAdapter(spinnerArrayAdapter);

        //Método do Spinner para capturar o item selecionado
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                nome = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome que foi selecionado
                Toast.makeText(TesteSpinnerActivity.this, "Nome Selecionado: " + nome, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
