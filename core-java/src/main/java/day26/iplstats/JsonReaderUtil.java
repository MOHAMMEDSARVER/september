package day26.iplstats;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonReaderUtil {
    private JsonReaderUtil() {

    }

    public <T> T readJson(String filename, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(JsonReaderUtil.class.getResourceAsStream("/" + filename), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Problem with loading data..");

    }

    public static <T> T readJson(String filename, TypeReference<T> typeReference) {
        try {
            return new ObjectMapper().readValue(JsonReaderUtil.class.getResourceAsStream("/" + filename), typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Problem with loading data..");

    }

}
