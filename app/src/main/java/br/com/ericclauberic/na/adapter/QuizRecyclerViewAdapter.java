package br.com.ericclauberic.na.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private List<PerguntasQuiz> perguntasQuizList;

    //
    public QuizRecyclerViewAdapter() {
        this.perguntasQuizList = new PerguntasDAO().listaTodasPerguntasBanco();
    }

    //
    public QuizRecyclerViewAdapter(List<PerguntasQuiz> perguntasQuizList) {
        this.perguntasQuizList = perguntasQuizList;
    }

    @Override
    public QuizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Desta forma o card view não pega o match_Parent no layout_width
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perguntas_card_view, null);

        // Assim(false) a view raiz, é usada somente para inflar o outro xml(card_view)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perguntas_card_view, parent, false);
        QuizViewHolder quizViewHolder = new QuizViewHolder(view);
        return quizViewHolder;

    }

    @Override
    public void onBindViewHolder(final QuizViewHolder holder, final int position) {
        // Recupera as informações na posição em questão.
        final PerguntasQuiz perguntasQuiz = perguntasQuizList.get(position);
        //


        //your other stuff
//
//        if (holder.radioGroup.getCheckedRadioButtonId() == holder.radioButtonSim.getId()) {
//            holder.radioGroup.check(holder.radioButtonSim.getId());
//            //holder.radioButtonSim.isChecked();
//        } else if (holder.radioGroup.getCheckedRadioButtonId() == holder.radioButtonAsVezes.getId()) {
//            holder.radioButtonAsVezes.isChecked();
//        } else if (holder.radioGroup.getCheckedRadioButtonId() == holder.radioButtonNao.getId()) {
//            holder.radioButtonNao.isChecked();
//        } else {
//            holder.radioGroup.clearCheck();
//        }
////        Message message = messageArrayList.get(position);
////        holder.vRadioGroup.setTag(position);
////        if (message.getSelectedRadioButtonId() != -1) {
////            holder.vRadioGroup.check(message.getSelectedRadioButtonId());
////        } else {
////            //your always need to write else condition
////            holder.vRadioGroup.clearCheck();
////        }


        // Modifica o texto na View.
        holder.textViewPerguntas.setText(perguntasQuiz.getPergunta());
        //
        holder.radioButtonSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizaListaPerguntaQuizResposta(holder.getLayoutPosition(), PerguntasQuiz.RESPOSTA_SIM);

            }
        });

        holder.radioButtonAsVezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizaListaPerguntaQuizResposta(holder.getLayoutPosition(), PerguntasQuiz.RESPOSTA_AS_VEZES);

            }
        });

        holder.radioButtonNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizaListaPerguntaQuizResposta(holder.getLayoutPosition(), PerguntasQuiz.RESPOSTA_NAO);
            }
        });
    }


    public void atualizaListaPerguntaQuizResposta(int posição, int resposta) {

        perguntasQuizList.get(posição).setResposta(resposta);

    }

    public List<PerguntasQuiz> getPerguntasQuizList() {

        return perguntasQuizList;

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
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
        QuizRecyclerViewAdapter quizRecyclerViewAdapter;

        public QuizViewHolder(View itemView) {
            super(itemView);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.card_view_radio_group);
            //
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == R.id.card_view_radio_button_sim) {
                        group.setTag(checkedId);
                        Log.i("log", "Item: " + getAdapterPosition() + " selecionado SIM");
                    } else if (checkedId == R.id.card_view_radio_button_as_vezes) {
                        group.setTag(checkedId);
                        Log.i("log", "Item: " + getAdapterPosition() + " selecionado AS VEZES");
                    } else if (checkedId == R.id.card_view_radio_button_nao) {
                        group.setTag(checkedId);
                        Log.i("log", "Item: " + getAdapterPosition() + " selecionado NÃO");
                    } else {
                        group.clearCheck();
                    }

                }
            });
//            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
////                    RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
////                    radioButton.i
//
////                    int radioButtonID = group.getCheckedRadioButtonId();
////                    RadioButton radioButtonID = (RadioButton) group.findViewById(checkedId);
//                    int posicaoClicado = (int) radioGroup.getTag();
//
//                    quizRecyclerViewAdapter.getPerguntasQuizList().get(posicaoClicado).setSelectedRadioButtonId(checkedId);
//
//                }
//            });
            //
            radioButtonSim = (RadioButton) itemView.findViewById(R.id.card_view_radio_button_sim);
            radioButtonAsVezes = (RadioButton) itemView.findViewById(R.id.card_view_radio_button_as_vezes);
            radioButtonNao = (RadioButton) itemView.findViewById(R.id.card_view_radio_button_nao);
            textViewPerguntas = (TextView) itemView.findViewById(R.id.text_view_id_perguntas_quiz);
        }


    }

}
