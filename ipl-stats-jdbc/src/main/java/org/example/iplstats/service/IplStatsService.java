package org.example.iplstats.service;

import org.example.iplstats.domain.Player;
import org.example.iplstats.dto.RoleStatsDto;
import org.example.iplstats.dto.TeamStatsDto;

import javax.swing.text.PlainDocument;
import java.util.List;

public interface IplStatsService {
    List<String> getTeamNames();

    List<String> getRoles();

    List<Player> getPlayersOfTeam(String teamName);

    List<TeamStatsDto> getTeamStats();

    List<RoleStatsDto> getRoleStats(String teamName);

    List<Player> getTopPaidPlayersOfEachTeam();
}
