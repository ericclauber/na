package br.com.ericclauberic.na.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import br.com.ericclauberic.na.application.NAApplication;
import br.com.ericclauberic.na.database.DatabaseHelper;
import br.com.ericclauberic.na.modelo.Quiz;

/**
 * Created by eric on 19/08/16.
 */
public class QuizDAO {
    Context context;

    private final String TAG = QuizDAO.class.getName();
    //
    private DatabaseHelper databaseHelper;
    private Dao<Quiz, Integer> quizDAO;

    public QuizDAO() {
        this.databaseHelper = NAApplication.getDatabaseHelper();
        this.quizDAO = getQuizDAO();
    }


    private Dao<Quiz, Integer> getQuizDAO() {
        Dao<Quiz, Integer> dao = null;
        try {
            dao = databaseHelper.getQuizDAO();
            return dao;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dao;
    }

    //
    public boolean salvarQuiz(Quiz quiz) {
        boolean ok = true;
        try {
            quizDAO.createIfNotExists(quiz);
//            Toast.makeText(context.getApplicationContext(), "Quiz salvo com sucesso!", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            ok = false;
            e.printStackTrace();
            System.out.print(">>>>>>>>>>>>>>>>>> ERRO" + e);
        }
        return ok;
    }


    public List<Quiz> listaTodoHistoricoQuizBanco() {
        //    PerguntasQuiz toReturn = null;

        List<Quiz> quizList = null;//new ArrayList<Grupos>();
        try {
            quizList = quizDAO.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizList;
    }
//
public boolean deletarQuiz(Quiz quiz) {
    boolean ok = true;
    try {

        quizDAO.delete(quiz);
//            Toast.makeText(context.getApplicationContext(), "Quiz salvo com sucesso!", Toast.LENGTH_SHORT).show();
    } catch (SQLException e) {
        ok = false;
        e.printStackTrace();
    }
    return ok;
}

    public boolean deletarListQuiz(List<Quiz> quizList) {
        boolean ok = true;
        try {
            quizDAO.delete(quizList);
//            Toast.makeText(context.getApplicationContext(), "Quiz salvo com sucesso!", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            ok = false;
            e.printStackTrace();
        }
        return ok;
    }
} // FIM
