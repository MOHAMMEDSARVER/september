package quiz;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class QuizeServiceImpl implements QuizeService {

    @SneakyThrows
    @Override
    public void startQuize(String username, QuizType type) {
        Quiz quizType = getQuizetype(type);
        List<Quistions> quistions = quizType.getQuestions();

        System.out.println("you have selected quiz " + type + " total number of question are " + quistions.size());
        System.out.println(username + " please wait your quize is getting ready:");
        TimeUnit.SECONDS.sleep(3);

        //todo quiz display
        Scanner sc = new Scanner(System.in);
        int totalscore = 0;
        for (Quistions question : quistions) {
            System.out.println("");
            System.out.println(question.question);
            System.out.println("Options are:");
            int i = 1;
            for (String s : question.getOptions()) {
                System.out.println(" Enter " + i++ + " for " + s);
            }
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            if (choice == question.answer)
                totalscore++;
        }
        displayresult(username, totalscore, quistions.size());


    }

    private void displayresult(String username, int totalscore, int size) {
        System.out.println("dear " + username + " You have scored :" + totalscore + " out of " + size);
    }

    private Quiz getQuizetype(QuizType type) {
        return JsonUtilReader.getQuize(type);
    }
}

