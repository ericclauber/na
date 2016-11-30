package br.com.ericclauberic.na.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by eric on 12/08/16.
 */
@DatabaseTable(tableName = "perguntasquiz")
public class PerguntasQuiz {

    public static final int RESPOSTA_SIM = 2;
    public static final int RESPOSTA_AS_VEZES = 1;
    public static final int RESPOSTA_NAO = 0;


    @DatabaseField(generatedId = true, columnName = "id")
    private int id;
    @DatabaseField(columnName = "pergunta")
    private String pergunta;

    @DatabaseField(columnName = "resposta")
    private int resposta;

    @DatabaseField(columnName = "status")
    private int status = 0;

    @DatabaseField(columnName = "respostardobuttonsim")
    private String respostaRdoButtonSim;

    @DatabaseField(columnName = "respostardobuttonveses")
    private String respostaRdoButtonAsVeses;

    @DatabaseField(columnName = "respostardobuttonnao")
    private String respostaRdoButtonNao;

    public PerguntasQuiz() {
    }

    public PerguntasQuiz(String pergunta, int resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;

    }

    //
    //
    private long checkedId = -1;

    public long getSelectedRadioButtonId() {
        return checkedId;
    }

    public void setSelectedRadioButtonId(long checkedId) {
        this.checkedId = checkedId;
    }
    //
    //

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }


    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRespostaRdoButtonSim() {
        return respostaRdoButtonSim;
    }

    public void setRespostaRdoButtonSim(String respostaRdoButtonSim) {
        this.respostaRdoButtonSim = respostaRdoButtonSim;
    }

    public String getRespostaRdoButtonAsVeses() {
        return respostaRdoButtonAsVeses;
    }

    public void setRespostaRdoButtonAsVeses(String respostaRdoButtonAsVeses) {
        this.respostaRdoButtonAsVeses = respostaRdoButtonAsVeses;
    }

    public String getRespostaRdoButtonNao() {
        return respostaRdoButtonNao;
    }

    public void setRespostaRdoButtonNao(String respostaRdoButtonNao) {
        this.respostaRdoButtonNao = respostaRdoButtonNao;
    }
}
