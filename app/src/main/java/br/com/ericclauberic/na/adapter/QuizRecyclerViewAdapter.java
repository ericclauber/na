package br.com.ericclauberic.na.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import br.com.ericclauberic.na.R;
import br.com.ericclauberic.na.dao.PerguntasDAO;
import br.com.ericclauberic.na.modelo.PerguntasQuiz;

/**
 * Created by eric on 22/08/16.
 */
public class QuizRecyclerViewAdapter extends RecyclerView.Adapter<QuizRecyclerViewAdapter.QuizViewHolder> {

    Context context;
    //
    public List<PerguntasQuiz> perguntasQuizList;
    private RadioButton lastCheckedRB = null;
    private int mCheckedId;
    private int mSelectedPosition;

    //
    public QuizRecyclerViewAdapter() {
        this.perguntasQuizList = new PerguntasDAO().listaTodasPerguntasBanco();
    }

    //
    public QuizRecyclerViewAdapter(List<PerguntasQuiz> perguntasQuizList) {
        this.perguntasQuizList = perguntasQuizList;
    }


    @Override
    public QuizViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // Desta forma o card view não pega o match_Parent no layout_width
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perguntas_card_view, null);

        // Assim(false) a view raiz, é usada somente para inflar o outro xml(card_view)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perguntas_card_view, parent, false);
        final QuizViewHolder quizViewHolder = new QuizViewHolder(view);


        return quizViewHolder;

    }

    @Override
    public void onBindViewHolder(final QuizViewHolder holder, final int position) {
        // Recupera as informações na posição em questão. OLD
//        final PerguntasQuiz perguntasQuiz = perguntasQuizList.get(holder.getAdapterPosition());
        //

        //
        // Recupera as informações na posição em questão.
        holder.textViewPerguntas.setText(perguntasQuizList.get(holder.getAdapterPosition()).getPergunta());


        //
        holder.radioButtonSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                atualizaListaPerguntaQuizResposta(holder.getAdapterPosition(), PerguntasQuiz.RESPOSTA_SIM);

            }
        });
        //
        holder.radioButtonAsVezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                atualizaListaPerguntaQuizResposta(holder.getAdapterPosition(), PerguntasQuiz.RESPOSTA_AS_VEZES);


            }
        });

        holder.radioButtonNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                atualizaListaPerguntaQuizResposta(holder.getAdapterPosition(), PerguntasQuiz.RESPOSTA_NAO);

            }
        });


    }

    // Atualiza a resposta da lista em determinada posição
    public void atualizaListaPerguntaQuizResposta(int posição, int resposta) {

        perguntasQuizList.get(posição).setResposta(resposta);

    }

    public List<PerguntasQuiz> getPerguntasQuizList() {

        return perguntasQuizList;

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        PerguntasQuiz perguntasQuiz = perguntasQuizList.get(position);
        long reposta;

        return super.getItemId(position);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int getItemCount() {
        int tamanhoLista;
        if (perguntasQuizList == null || perguntasQuizList.isEmpty()) {
            tamanhoLista = 0;
        } else {
            tamanhoLista = this.perguntasQuizList.size();
        }

        return tamanhoLista;
    }


    public static class QuizViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewPerguntas;
        private RadioGroup radioGroup;
        private RadioButton radioButtonSim;
        private RadioButton radioButtonAsVezes;
        private RadioButton radioButtonNao;


        public QuizViewHolder(final View itemView) {
            super(itemView);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.card_view_radio_group);
            radioButtonSim = (RadioButton) itemView.findViewById(R.id.card_view_radio_button_sim);
            radioButtonAsVezes = (RadioButton) itemView.findViewById(R.id.card_view_radio_button_as_vezes);
            radioButtonNao = (RadioButton) itemView.findViewById(R.id.card_view_radio_button_nao);
            textViewPerguntas = (TextView) itemView.findViewById(R.id.text_view_id_perguntas_quiz);


        }


    }

}
