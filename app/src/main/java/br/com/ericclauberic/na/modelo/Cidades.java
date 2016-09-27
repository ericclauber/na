package br.com.ericclauberic.na.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by eric on 08/09/16.
 */
@DatabaseTable(tableName = "cidades")
public class Cidades {
    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(columnName = "cidade",indexName = "idx_cidade")
    private String cidade;

    @DatabaseField(columnName = "uf", indexName = "idx_uf")
    private String uf;

    public Cidades() {
    }

    public Cidades(String cidade, String uf) {
        this.cidade = cidade;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
