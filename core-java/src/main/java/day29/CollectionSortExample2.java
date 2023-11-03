package day29;

import org.example.iplstats.domain.Player;
import org.example.iplstats.util.JsonPlayerReaderUtil;

import java.util.Comparator;
import java.util.List;

public class CollectionSortExample2 {
    public static void main(String[] args) {
        List<Player> players = JsonPlayerReaderUtil.loadPlayers();
        List<Player> sortedList=players.stream().sorted(Comparator.comparing(Player::getAmount).reversed()
                .thenComparing(Player::getTeamName).reversed()
                .thenComparing(Player::getName)).toList();
        System.out.println(sortedList);
    }
}
