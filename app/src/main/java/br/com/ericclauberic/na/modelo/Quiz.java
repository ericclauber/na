package br.com.ericclauberic.na.modelo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by eric on 12/08/16.
 */
@DatabaseTable(tableName = "quiz")
public class Quiz {

    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(columnName = "idpergunta")
    private int idPergunta;

    @DatabaseField(columnName = "resposta")
    private String resposta;

    @DatabaseField(columnName = "qtsim")
    private int qtSim;

    @DatabaseField(columnName = "qtasvezes")
    private int qtAsVezes;

    @DatabaseField(columnName = "qtnao")
    private int qtNao;

    @DatabaseField(columnName = "percresultado")
    private int percResultado;

    @DatabaseField(columnName = "dataquiz", dataType = DataType.DATE)
    private Date dataQuiz;

    public Quiz() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getQtSim() {
        return qtSim;
    }

    public void setQtSim(int qtSim) {
        this.qtSim = qtSim;
    }

    public int getQtAsVezes() {
        return qtAsVezes;
    }

    public void setQtAsVezes(int qtAsVezes) {
        this.qtAsVezes = qtAsVezes;
    }

    public int getQtNao() {
        return qtNao;
    }

    public void setQtNao(int qtNao) {
        this.qtNao = qtNao;
    }

    public int getPercResultado() {
        return percResultado;
    }

    public void setPercResultado(int percResultado) {
        this.percResultado = percResultado;
    }

    public Date getDataQuiz() {
        return dataQuiz;
    }

    public void setDataQuiz(Date dataQuiz) {
        this.dataQuiz = dataQuiz;
    }
}
