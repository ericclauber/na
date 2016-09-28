package br.com.ericclauberic.na.database;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import br.com.ericclauberic.na.R;
import br.com.ericclauberic.na.controle.ListaDeCidadesInsercao;
import br.com.ericclauberic.na.controle.ListaDeGruposInsercao;
import br.com.ericclauberic.na.dao.CidadesDAO;
import br.com.ericclauberic.na.dao.GruposDAO;
import br.com.ericclauberic.na.dao.PerguntasDAO;
import br.com.ericclauberic.na.modelo.Cidades;
import br.com.ericclauberic.na.modelo.Grupos;
import br.com.ericclauberic.na.modelo.PerguntasQuiz;
import br.com.ericclauberic.na.modelo.Quiz;

/**
 * Created by eric on 19/08/16.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final Integer DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "na.db";
    //
    private Dao<Quiz, Integer> quizDAO = null;
    private Dao<PerguntasQuiz, Integer> perguntasQuizDAO = null;
    private Dao<Grupos, Integer> gruposDAO = null;
    private Dao<Cidades, Integer> cidadesDAO = null;
    //
    Resources resources;
    Context context;
    AppCompatActivity appCompatActivity;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        // metodo inicializado a primeira vez que o app é instalado
        try {
            TableUtils.createTable(connectionSource, Quiz.class);
            TableUtils.createTable(connectionSource, PerguntasQuiz.class);
            TableUtils.createTable(connectionSource, Grupos.class);
            TableUtils.createTable(connectionSource, Cidades.class);
            //
            chamaInserePerguntasBanco();
            //
            chamaInsereGruposBanco();
            //
            chamaInsereCidadesBanco();
            //
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
// metodo inicializado sempre que é detectado uma nova versão do app
        try {
            TableUtils.dropTable(connectionSource, Quiz.class, true);
            TableUtils.dropTable(connectionSource, PerguntasQuiz.class, true);
            TableUtils.dropTable(connectionSource, Grupos.class, true);
            TableUtils.dropTable(connectionSource, Cidades.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }

    /**
     * Metodos utilizados para recuperar a instancia da tabela do banco
     */

    public Dao<PerguntasQuiz, Integer> getPerguntasQuizDAO() throws SQLException {
        if (perguntasQuizDAO == null) {
            perguntasQuizDAO = getDao(PerguntasQuiz.class);
        }
        return perguntasQuizDAO;
    }

    public Dao<Quiz, Integer> getQuizDAO() throws SQLException {
        if (quizDAO == null) {
            quizDAO = getDao(Quiz.class);

        }
        return quizDAO;
    }

    public Dao<Grupos, Integer> getGruposDAO() throws SQLException {
        if (gruposDAO == null) {
            gruposDAO = getDao(Grupos.class);
        }
        return gruposDAO;
    }

    //
    public Dao<Cidades, Integer> getCidadesDAO() throws SQLException {
        if (cidadesDAO == null) {
            cidadesDAO = getDao(Cidades.class);
        }
        return cidadesDAO;
    }

//

    /**
     * Metodo utilizado para limpar a referencia do DAO das tabelas do banco
     */
    public void closeAll() {
        perguntasQuizDAO = null;
        quizDAO = null;
        gruposDAO = null;
        cidadesDAO = null;
    }

    // Método para receber a String de perguntas e inserir no banco
    public void chamaInserePerguntasBanco() {

        // Array de perguntas para inserir no banco
        ArrayStringPerguntas arrayStringPerguntas = new ArrayStringPerguntas();
        String[] perguntasArray = arrayStringPerguntas.getArrayPerguntas();

        //
        PerguntasDAO perguntasDAO = new PerguntasDAO();
        PerguntasQuiz perguntasQuiz;
        //
        for (int i = 0; i < perguntasArray.length; i++) {
            perguntasQuiz = new PerguntasQuiz();
            perguntasQuiz.setPergunta(perguntasArray[i]);
            perguntasQuiz.setResposta(-1);
            perguntasDAO.salvarPerguntas(perguntasQuiz);
        }
    }
    //
    //
    public void chamaInsereGruposBanco() {
        List<Grupos> gruposList = new ListaDeGruposInsercao().getListaDeGrupos();

        GruposDAO gruposDAO = new GruposDAO();
        Grupos grupo;
        //
        for (int i = 0; i < gruposList.size(); i++) {
            grupo = new Grupos();
            grupo = gruposList.get(i);
            gruposDAO.salvarGrupos(grupo);

        }
    }

    //
    public void chamaInsereCidadesBanco() {
        List<Cidades> cidadesList = new ListaDeCidadesInsercao().getListaDeCidade();

        CidadesDAO cidadesDAO = new CidadesDAO();
        Cidades cidades;
        //
        for (int i = 0; i < cidadesList.size(); i++) {
            cidades = new Cidades();
            cidades = cidadesList.get(i);
            cidadesDAO.salvarCidades(cidades);

        }

    }
    //
    // Criado esta classe interna para extender de AddCompatActivity, e obter o método getResources(),
    // para repassar 'array de string' de perguntas
    public class ArrayStringPerguntas extends AppCompatActivity{

        public String[] getArrayPerguntas(){

            Resources resources = getResources();

            String[] array = resources.getStringArray(R.array.perguntas_array);
            return array;
        }
    }
    //
    //



} // FIM
