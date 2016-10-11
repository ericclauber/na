package br.com.ericclauberic.na.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.ericclauberic.na.modelo.Cidades;
import br.com.ericclauberic.na.modelo.Grupos;

/**
 * Created by eric on 02/09/16.
 */
public class ListaDeGruposInsercao {

    public List<Grupos> getListaDeGrupos() {
        List<Grupos> gruposList = new ArrayList<Grupos>();
        Cidades cidades;
        //
        Grupos harmonia = new Grupos();
        harmonia.setNomeGrupo("Harmonia");
        harmonia.setEndereco("Praça Otávio Bonfim");
        harmonia.setNumero("S/N");
        harmonia.setBairro("Otávio Bonfim");
        harmonia.setCidade("FORTALEZA");
        harmonia.setUf("CE");
        harmonia.setLocal("Pastoral da Saúde da Paróquia N. Sra. das Dores");
        harmonia.setLatitude(-3.732134);
        harmonia.setLongitude(-38.543449);
        cidades = new Cidades();
        cidades.setId(1);
        harmonia.setCidades(cidades);
        //
        Grupos sabedoria = new Grupos();
        sabedoria.setNomeGrupo("Sabedoria");
        sabedoria.setEndereco("Av. Sen. Fernandes Távora");
        sabedoria.setNumero("S/N");
        sabedoria.setBairro("Henrique Jorge");
        sabedoria.setCidade("FORTALEZA");
        sabedoria.setUf("CE");
        sabedoria.setLocal("Escola Mariano Martins");
        sabedoria.setLatitude(-3.760402);
        sabedoria.setLongitude(-38.585766);
        cidades = new Cidades();
        cidades.setId(1);
        sabedoria.setCidades(cidades);

        Grupos paz = new Grupos();
        paz.setNomeGrupo("Serenidade");
        paz.setEndereco("Av Rui Barbosa");
        paz.setNumero("1970");
        paz.setBairro("Aldeota");
        paz.setCidade("FORTALEZA");
        paz.setUf("CE");
        paz.setLocal("Inst.Cearense Educ. Surdos");
        paz.setLatitude(-3.740259);
        paz.setLongitude(-38.510964);
        cidades = new Cidades();
        cidades.setId(1);
        paz.setCidades(cidades);

        Grupos livre = new Grupos();
        livre.setNomeGrupo("Livre");
        livre.setEndereco("Av Rui Barbosa");
        livre.setNumero("1970");
        livre.setBairro("Aldeota");
        livre.setCidade("FORTALEZA");
        livre.setUf("CE");
        livre.setLocal("Inst.Cearense Educ. Surdos");
        livre.setLatitude(-3.740259);
        livre.setLongitude(-38.510964);
        cidades = new Cidades();
        cidades.setId(1);
        livre.setCidades(cidades);

        Grupos porhoje = new Grupos();
        porhoje.setNomeGrupo("Só por Hoje");
        porhoje.setEndereco("Praça Otávio Bonfim");
        porhoje.setNumero("S/N");
        porhoje.setBairro("Otávio Bonfim");
        porhoje.setCidade("FORTALEZA");
        porhoje.setUf("CE");
        porhoje.setLocal("Pastoral da Saúde da Paróquia N. Sra. das Dores");
        porhoje.setLatitude(-3.732134);
        porhoje.setLongitude(-38.543449);
        cidades = new Cidades();
        cidades.setId(1);
        porhoje.setCidades(cidades);

        Grupos amanha = new Grupos();
        amanha.setNomeGrupo("Só por Hoje");
        amanha.setEndereco("Praça Otávio Bonfim");
        amanha.setNumero("S/N");
        amanha.setBairro("Otávio Bonfim");
        amanha.setCidade("QUIXADAAAA");
        amanha.setUf("CE");
        amanha.setLocal("Pastoral da Saúde da Paróquia N. Sra. das Dores");
        amanha.setLatitude(-3.732134);
        amanha.setLongitude(-38.543449);
        cidades = new Cidades();
        cidades.setId(15);
        amanha.setCidades(cidades);

        gruposList.add(harmonia);
        gruposList.add(sabedoria);
        gruposList.add(paz);
        gruposList.add(livre);
        gruposList.add(porhoje);
        gruposList.add(amanha);

        return gruposList;

    }
}
