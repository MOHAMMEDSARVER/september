package org.example.iplstats.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.iplstats.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class JsonPlayerReaderUtil {
    private JsonPlayerReaderUtil() {
    }

    public static List<Player> loadPlayers() {
        String fileName = "/players_data.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Player> list = new ArrayList<>();
        try {
            list = mapper.readValue(JsonPlayerReaderUtil.class.getResourceAsStream(fileName), new TypeReference<>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
