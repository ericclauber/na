package br.com.ericclauberic.na.dao;

import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import br.com.ericclauberic.na.application.NAApplication;
import br.com.ericclauberic.na.database.DatabaseHelper;
import br.com.ericclauberic.na.modelo.Cidades;

/**
 * Created by eric on 08/09/16.
 */
public class CidadesDAO {

    private final String TAG = CidadesDAO.class.getName();

    private DatabaseHelper databaseHelper;
    private Dao<Cidades, Integer> cidadesDao;

    public CidadesDAO() {
        this.databaseHelper = NAApplication.getDatabaseHelper();
        this.cidadesDao = getCidadesDAO();
    }


    // recupera a instancia da tabela de Perguntas em DatabaseHelper
    private Dao<Cidades, Integer> getCidadesDAO() {
        Dao<Cidades, Integer> dao = null;
        try {
            dao = databaseHelper.getCidadesDAO();
            return dao;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dao;
    }
    //

    public void refresh(Cidades cidades) {
        try {
            cidadesDao.refresh(cidades);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //
    public void salvarCidades(Cidades cidades) {
        try {
            cidadesDao.createIfNotExists(cidades);
            Log.d(TAG, ">>>>>>>>>>>>>>>> !!!!!!!!!!!!!!!!!!!!!Salvo com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Cidades> listaTodasCidadesBanco() {
        //    PerguntasQuiz toReturn = null;

        List<Cidades> cidadesList = null;//new ArrayList<Grupos>();
        try {
            cidadesList = cidadesDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidadesList;
    }

    //
    public List<Cidades> listaCidadesPorUF(String uf) {
        //    PerguntasQuiz toReturn = null;

        List<Cidades> cidadesList = null;

//        QueryBuilder<Account, Integer> qb = accountDao.queryBuilder();
//        qb.where().ge("orderCount", 10);
//        results = accountDao.queryRaw(qb.prepareStatementString());

        try {
//            QueryBuilder<Grupos, Integer> qb = gruposDao.queryBuilder();
//            qb.where().ge("orderCount", 10);
//            gruposList = gruposDao.queryRaw(qb.prepareStatementString());
//            String query = "select cidade from grupos where uf = ?";
//            gruposList = gruposDao.queryRaw(query, uf);
            cidadesList = cidadesDao.queryForEq("uf", uf);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidadesList;
    }
}
