package day28;



import org.example.iplstats.domain.Player;
import org.example.iplstats.util.JsonPlayerReaderUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample6 {

    public static void main(String[] args) {

        List<Player> players = JsonPlayerReaderUtil.loadPlayers();


        // Get team wise player details

        Map<String, List<Player>> playerDetailsMap = new HashMap<>();
       /* playerDetailsMap = players.stream()
                .filter(e->e.getTeamName())*/

        // Get player details based on role

        Map<String, List<Player>> roleWisePlayerMap = new HashMap<>();

        // Get teamName and count of players in each team

        Map<String,Integer> teamNameCountMap = new HashMap<>();

        // Get team and role wise player details
        Map<String,Map<String,List<Player>>> teamRoleWisePlayerMap = new HashMap<>();
    }
}
