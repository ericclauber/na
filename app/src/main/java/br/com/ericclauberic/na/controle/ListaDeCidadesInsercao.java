package br.com.ericclauberic.na.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.ericclauberic.na.modelo.Cidades;

/**
 * Created by eric on 08/09/16.
 */
public class ListaDeCidadesInsercao {

    public List<Cidades> getListaDeCidade() {

        ArrayList<Cidades> cidadesLista = new ArrayList<Cidades>();
        Cidades cidade;

        String[] cidades = new String[]{
                "FORTALEZA",
                "ACOPIARA",
                "AIUABA",
                "ALCÂNTARAS",
                "ALTANEIRA",
                "ALTO SANTO",
                "AMONTADA",
                "ANTONINA DO NORTE",
                "APUIARÉS",
                "AQUIRAZ",
                "ARACATI",
                "ARACOIABA",
                "ARARENDÁ",
                "ARARIPE",
                "QUIXADÁ"};

        String[] uf = new String[]{
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE",
                "CE"};

        for (int i = 0; i < cidades.length; i++) {
            cidade = new Cidades();
            cidade.setCidade(cidades[i]);
            cidade.setUf(uf[i]);
            cidadesLista.add(cidade);
        }

        return cidadesLista;
    }


}
