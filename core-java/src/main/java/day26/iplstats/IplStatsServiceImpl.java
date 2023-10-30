package day26.iplstats;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.OptionalDouble;

public class IplStatsServiceImpl implements IplStatsService {
    List<Player> players;

    public IplStatsServiceImpl() {
        players = JsonReaderUtil.readJson("Players.json", new TypeReference<>() {
        });
    }

    @Override
    public List<Player> getAllPlayers() {
        return players;
    }

    @Override
    public List<String> getTeamNames() {

        return players.stream()
                .map(e -> e.getTeamName())
                .distinct()
                .toList();
    }

    @Override
    public List<String> playersByTeam(String teamName) {
        return players.stream()
                .filter(e -> e.getTeamName().equals(teamName))
                .map(e -> e.getName())
                .toList();

    }

    @Override
    public List<String> playersByRole(String role) {
        return players.stream()
                .filter(e -> e.getRole().equals(role))
                .map(e -> e.getName())
                .toList();
    }

    @Override
    public List<String> playersByTeamAndRole(String teamName, String role) {
        return players.stream()
                .filter(e -> e.getTeamName().equals(teamName))
                .filter(e -> e.getRole().equals(role))
                .map(e -> e.getName())
                .toList();

    }

    @Override
    public List<String> getRoleNames() {
        return players.stream()
                .map(e -> e.getRole())
                .distinct()
                .toList();
    }

    @Override
    public double getMaxAmount() {
       return 1;
    }

    @Override
    public double totalAmountByTeam(String teamName) {

        return players.stream()
                .filter(e -> e.getTeamName().equals(teamName))
                .mapToDouble(e -> e.getAmount())
                .sum();

    }
}
