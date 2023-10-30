package day26.iplstats;

import java.util.List;

public interface IplStatsService {
    List<Player> getAllPlayers();
    List<String> getTeamNames();
    List<String> playersByTeam(String teamName);
    List<String> playersByRole(String role);
    List<String> playersByTeamAndRole(String teamName,String role);
    List<String> getRoleNames();
    double getMaxAmount();
    double totalAmountByTeam(String teamName);
}
