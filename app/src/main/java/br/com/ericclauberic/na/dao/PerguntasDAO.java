package br.com.ericclauberic.na.dao;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import br.com.ericclauberic.na.application.NAApplication;
import br.com.ericclauberic.na.database.DatabaseHelper;
import br.com.ericclauberic.na.modelo.PerguntasQuiz;

//import com.j256.ormlite.logger.Log;

/**
 * Created by eric on 19/08/16.
 */
public class PerguntasDAO {

    private final String TAG = PerguntasDAO.class.getName();

    private DatabaseHelper databaseHelper;
    private Dao<PerguntasQuiz, Integer> perguntasQuizDAO;

    public PerguntasDAO() {
        this.databaseHelper = NAApplication.getDatabaseHelper();
        this.perguntasQuizDAO = getPerguntasQuizDAO();
    }

    // recupera a instancia da tabela de Perguntas em DatabaseHelper
    private Dao<PerguntasQuiz, Integer> getPerguntasQuizDAO() {
        Dao<PerguntasQuiz, Integer> dao = null;
        try {
            dao = databaseHelper.getPerguntasQuizDAO();
            return dao;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dao;
    }

    //
    public void salvarPerguntas(PerguntasQuiz perguntasQuiz) {
        try {
            perguntasQuizDAO.createIfNotExists(perguntasQuiz);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //
    public List<PerguntasQuiz> listaTodasPerguntasBanco() {
    //    PerguntasQuiz toReturn = null;

        List<PerguntasQuiz> perguntasQuizList = null;
        try {
            perguntasQuizList = perguntasQuizDAO.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  perguntasQuizList;
    }
    //

} // FIM
