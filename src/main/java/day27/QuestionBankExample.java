package day27;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@EqualsAndHashCode
@ToString
class Question {
    private int qno;
    private String question;
}

public class QuestionBankExample {
    public static void main(String[] args) {
        List<Question> list = initQuestions();
        Set<Question> set = getQuestions(20, list);

        set.forEach(System.out::println);

    }

    private static Set<Question> getQuestions(int i, List<Question> list) {
        Set<Question> set = new HashSet<>();
        while (set.size() != i) {
            set.add(list.get(ThreadLocalRandom.current().nextInt(1, list.size())));
        }

        return set;
    }

    private static List<Question> initQuestions() {
        List<Question> questionsList = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            Question question = new Question();
            question.setQno(i);
            question.setQuestion("Question :" + i);
            questionsList.add(question);
        }
        return questionsList;
    }
}
