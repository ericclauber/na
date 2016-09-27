package br.com.ericclauberic.na.testes;

import java.util.List;

import br.com.ericclauberic.na.controle.ListaDeCidadesInsercao;
import br.com.ericclauberic.na.modelo.Cidades;

/**
 * Created by eric on 19/08/16.
 */
public class Teste {

    public static void main(String[] args) {

        int contador = 0;
        int resultado = 0;

//        List<PerguntasQuiz> perguntasQuizList = new ArrayList<>();
//        //List<Quiz> quizList = new ArrayList<Quiz>();
//        //
//        PerguntasQuiz perguntasQuiz1 = new PerguntasQuiz();
//        perguntasQuiz1.setId(1);
//        perguntasQuiz1.setPergunta("aaa?");
//        perguntasQuiz1.setResposta("Sim");
//        perguntasQuizList.add(perguntasQuiz1);
//        //
//
//        PerguntasQuiz perguntasQuiz2 = new PerguntasQuiz();
//        perguntasQuiz2.setId(2);
//        perguntasQuiz2.setPergunta("bbb?");
//        perguntasQuiz2.setResposta("Sim");
//        perguntasQuizList.add(perguntasQuiz2);
//        //
//        PerguntasQuiz perguntasQuiz3 = new PerguntasQuiz();
//        perguntasQuiz3.setId(3);
//        perguntasQuiz3.setPergunta("ccc?");
//        perguntasQuiz3.setResposta("Sim");
//        perguntasQuizList.add(perguntasQuiz3);
//
//        PerguntasQuiz perguntasQuiz4 = new PerguntasQuiz();
//        perguntasQuiz3.setId(4);
//        perguntasQuiz3.setPergunta("ccc?");
//        perguntasQuiz4.setResposta("Não");
//        perguntasQuizList.add(perguntasQuiz4);
//        //
//        PerguntasQuiz perguntasQuiz5 = new PerguntasQuiz();
//        perguntasQuiz5.setId(5);
//        perguntasQuiz5.setPergunta("ccc?");
//        perguntasQuiz5.setResposta("Talvez");
//        perguntasQuizList.add(perguntasQuiz5);


   //     ListIterator<PerguntasQuiz> quizListIterator = perguntasQuizList.listIterator();

//        while (quizListIterator.hasNext()) {
//            PerguntasQuiz pq = quizListIterator.next();
//            if (pq.getResposta().equals("Sim")) {
//                contador += 2;
//            }
//            if (pq.getResposta().equals("Talvez")) {
//                contador += 1;
//            }
//            System.out.println("Resposta: " + pq.getResposta());
//        }
//        System.out.println("Contador: " + contador);

          List<Cidades> cidadesList = new ListaDeCidadesInsercao().getListaDeCidade();

        //CidadesDAO cidadesDAO = new CidadesDAO();
        Cidades cidades;
        //
        for (int i = 0; i < cidadesList.size(); i++) {
            cidades = new Cidades();
            cidades = cidadesList.get(i);
            System.out.println("Cidade " + cidades.getCidade() + " " + i);

        }

    }
}
