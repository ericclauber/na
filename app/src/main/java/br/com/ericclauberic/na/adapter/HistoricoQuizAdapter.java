package br.com.ericclauberic.na.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.ericclauberic.na.R;
import br.com.ericclauberic.na.modelo.Quiz;

/**
 * Created by eric on 21/09/16.
 */

public class HistoricoQuizAdapter extends BaseAdapter{
    //

    private final Context context;
    private final List<Quiz> quizList;

    public HistoricoQuizAdapter(Context context, List<Quiz> quizList) {
        this.context = context;
        this.quizList = quizList;
    }

    @Override
    public int getCount() {
        return quizList != null ? quizList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return quizList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //; Infla a view
        View view1 = LayoutInflater.from(context).inflate(R.layout.historico_quiz_adapter_lista, viewGroup, false);
        // Retorna as view da lista; que precisa atualizar
        TextView pontuacao = (TextView) view1.findViewById(R.id.layout_historico_adapter_textview_pontuacao);
        TextView data = (TextView) view1.findViewById(R.id.layout_historico_adapter_textview_label_data);

        // Atualiza os valores
        Quiz quiz = this.quizList.get(i);
        //
        pontuacao.setText(String.valueOf(quiz.getPercResultado()));
        //
        Date dataBanco = quiz.getDataQuiz();
        String dataF = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataF);
        String dataFortmatada = simpleDateFormat.format(dataBanco);
        //
        data.setText(dataFortmatada);
        //data.setText(String.valueOf(quiz.getDataQuiz()));
        // Retorna a view dos grupos
        return view1;
    }

} // FIM


