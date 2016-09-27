package br.com.ericclauberic.na;

import java.util.List;
import java.util.ListIterator;
import br.com.ericclauberic.na.modelo.PerguntasQuiz;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
//public class ApplicationTest extends ApplicationTestCase<Application> {
//    public ApplicationTest() {
//        super(Application.class);
//    }
//}

public class ApplicationTest {

    public static void main(String[] args) {

        int contador = 5;
        int resultado = 0;

        List<PerguntasQuiz> perguntasQuizList = null;
        //List<Quiz> quizList = new ArrayList<Quiz>();
        //
        PerguntasQuiz perguntasQuiz1 = new PerguntasQuiz();
        perguntasQuiz1.setId(1);
        perguntasQuiz1.setPergunta("aaa?");
   //     perguntasQuiz1.setResposta("Sim");
        perguntasQuizList.add(perguntasQuiz1);
        //

        PerguntasQuiz perguntasQuiz2 = new PerguntasQuiz();
        perguntasQuiz2.setId(2);
        perguntasQuiz2.setPergunta("bbb?");
  //      perguntasQuiz2.setResposta("Sim");
        perguntasQuizList.add(perguntasQuiz2);
                //
        PerguntasQuiz perguntasQuiz3 = new PerguntasQuiz();
        perguntasQuiz3.setId(3);
        perguntasQuiz3.setPergunta("ccc?");
    //    perguntasQuiz3.setResposta("Sim");
        perguntasQuizList.add(perguntasQuiz3);

        PerguntasQuiz perguntasQuiz4 = new PerguntasQuiz();
        perguntasQuiz3.setId(4);
        perguntasQuiz3.setPergunta("ccc?");
   //     perguntasQuiz4.setResposta("Não");
        perguntasQuizList.add(perguntasQuiz4);
        //
        PerguntasQuiz perguntasQuiz5 = new PerguntasQuiz();
        perguntasQuiz5.setId(5);
        perguntasQuiz5.setPergunta("ccc?");
   //     perguntasQuiz5.setResposta("Talvez");
        perguntasQuizList.add(perguntasQuiz5);


        ListIterator<PerguntasQuiz> quizListIterator = perguntasQuizList.listIterator();

        while (quizListIterator.hasNext()) {
            PerguntasQuiz pq = quizListIterator.next();
   //         System.out.println(pq.getResposta());
        }


//        for (int i = 0; i < perguntasQuizList.size(); i++) {
//            perguntasQuizList.listIterator();
//        }



//        List<Quiz> quizList =
//
//                new ArrayList<Quiz>();
//        quizList.s
//
//        Quiz quiz;
//        quiz.setIdPergunta(1);
//        quiz.setQtSim(35);
//        quiz.setQtTalvez(10);
//        quiz.setQtNao(5);



    }

}