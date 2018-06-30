package t2;

import org.junit.Test;

public class QuizTest {

    @Test
    public void runQuiz() {
        Quiz quiz = new Quiz("Anton", "ru");
        quiz.printAllQuestion();
        quiz.printAnswer(1);

        quiz = new Quiz("Anton", "en");
        quiz.printAllQuestion();
        quiz.printAnswer(1);
    }

}