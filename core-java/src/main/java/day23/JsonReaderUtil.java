package day23;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonReaderUtil {
    private static final String FILE_NAME = "/hotel_data.json";

    public static List<Hotel> loadHotelData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(JsonReaderUtil.class.getResourceAsStream(FILE_NAME), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
