package br.com.ericclauberic.na.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by eric on 31/08/16.
 */
@DatabaseTable(tableName = "grupos")
public class Grupos {

    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(columnName = "nomeGrupo")
    private String nomeGrupo;
    @DatabaseField(columnName = "endereco")
    private String endereco;
    @DatabaseField(columnName = "numero")
    private String numero;
    @DatabaseField(columnName = "bairro")
    private String bairro;
    @DatabaseField(columnName = "cidade", indexName = "idx_cidade_grupo")
    private String cidade;
    @DatabaseField(columnName = "uf")
    private String uf;
    @DatabaseField(columnName = "local")
    private String local;
    @DatabaseField(columnName = "latitude")
    private double latitude;
    @DatabaseField(columnName = "longitude")
    private double longitude;
    @DatabaseField(columnName = "diasreunioes")
    private String diasReunioes;
    @DatabaseField(columnName = "horario")
    private String horario;
    @DatabaseField(columnName = "ddd1")
    private int ddd1;
    @DatabaseField(columnName = "telefone1")
    private long telefone1;
    @DatabaseField(columnName = "ddd2")
    private int ddd2;
    @DatabaseField(columnName = "telefone2")
    private long telefone2;
    @DatabaseField(columnName = "email1")
    private String email1;
    @DatabaseField(columnName = "email2")
    private String email2;
    // Faz referência ao Id da cidade em Cidades
    @DatabaseField(foreign = true, columnName = "codcidade", foreignAutoRefresh = true)
    private Cidades cidades;


    public Grupos() {
    }

    public Grupos(int id, String nomeGrupo, double latitude, double longitude) {
        this.nomeGrupo = nomeGrupo;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDiasReunioes() {
        return diasReunioes;
    }

    public void setDiasReunioes(String diasReunioes) {
        this.diasReunioes = diasReunioes;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getDdd1() {
        return ddd1;
    }

    public void setDdd1(int ddd1) {
        this.ddd1 = ddd1;
    }

    public long getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(long telefone1) {
        this.telefone1 = telefone1;
    }

    public int getDdd2() {
        return ddd2;
    }

    public void setDdd2(int ddd2) {
        this.ddd2 = ddd2;
    }

    public long getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(long telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public Cidades getCidades() {
        return cidades;
    }

    public void setCidades(Cidades cidades) {
        this.cidades = cidades;
    }

    @Override
    public String toString() {
        return cidade;
    }
} // FIM
