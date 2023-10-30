package quiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import day23.JsonReaderUtil;

import java.io.IOException;

public class JsonUtilReader {
    private JsonUtilReader() {
    }

    public static Quiz getQuize(QuizType type) {
        //String file="/quiz/"+type.toString().toLowerCase()+"_quiz"+".json";
        String fileName = "/quiz/" + type.name().toLowerCase() + "_quiz" + ".json";

      /*  ObjectMapper mapper = new ObjectMapper();
        Quiz quiz = null;
        try {
            quiz = mapper.readValue(JsonUtilReader.class.getResourceAsStream(fileName), Quiz.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        ObjectMapper mapper = new ObjectMapper();
        Quiz quiz= null;
        try {
            quiz = mapper.readValue(JsonUtilReader.class.getResourceAsStream(fileName), Quiz.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return quiz;
    }
}
