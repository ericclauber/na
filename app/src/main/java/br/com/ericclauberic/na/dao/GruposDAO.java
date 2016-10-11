package br.com.ericclauberic.na.dao;

import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import br.com.ericclauberic.na.application.NAApplication;
import br.com.ericclauberic.na.database.DatabaseHelper;
import br.com.ericclauberic.na.modelo.Cidades;
import br.com.ericclauberic.na.modelo.Grupos;

/**
 * Created by eric on 02/09/16.
 */
public class GruposDAO {

    private final String TAG = GruposDAO.class.getName();

    private DatabaseHelper databaseHelper;
    private Dao<Grupos, Integer> gruposDao;

    public GruposDAO() {
        this.databaseHelper = NAApplication.getDatabaseHelper();
        this.gruposDao = getGruposDAO();
    }

    // recupera a instancia da tabela de Perguntas em DatabaseHelper
    private Dao<Grupos, Integer> getGruposDAO() {
        Dao<Grupos, Integer> dao = null;
        try {
            dao = databaseHelper.getGruposDAO();
            return dao;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dao;
    }

    //
    public void salvarGrupos(Grupos grupos) {
        try {
            gruposDao.createIfNotExists(grupos);
            Log.d(TAG, ">>>>>>>>>>>>>>>>Salvo com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Grupos> listaTodosGruposBanco() {
        //    PerguntasQuiz toReturn = null;

        List<Grupos> gruposList = null;//new ArrayList<Grupos>();
        try {
            gruposList = gruposDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gruposList;
    }

    //
    public List<Grupos> listaGruposBancoCidade(String cidade) {
        //    PerguntasQuiz toReturn = null;

        List<Grupos> gruposList = null;

        try {
            gruposList = gruposDao.queryForEq("cidade", cidade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gruposList;
    }
    //
    public List<Grupos> listaGruposCodCidade(Cidades cidades) {

        List<Grupos> gruposList = null;

        try {
            gruposList = gruposDao.queryBuilder().where().eq("codcidade", cidades).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gruposList;
    }


} //FIM
