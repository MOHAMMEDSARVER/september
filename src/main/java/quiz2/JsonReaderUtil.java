package quiz2;

import com.fasterxml.jackson.databind.ObjectMapper;
import quiz.JsonUtilReader;

import java.io.IOException;

public class JsonReaderUtil {
    private void JsonUtilReader() {

    }

    public Quiz getQuiz(QuizType type) {
        String file = type.toString().toLowerCase() + "quiz.json";
        ObjectMapper objectMapper = new ObjectMapper();
        Quiz quiz;
        try {
            quiz = objectMapper.readValue(JsonUtilReader.class.getResourceAsStream(file), Quiz.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return quiz;
    }
}
