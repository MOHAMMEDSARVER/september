package quiz;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Quistions {
    int qid;
    String question;
    List<String> options;
    int answer;

}
