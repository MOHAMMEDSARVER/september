package quiz2;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    String question;
    int qid;
    List<String> options;
    int answer;
}
