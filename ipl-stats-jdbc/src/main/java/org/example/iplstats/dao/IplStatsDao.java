package org.example.iplstats.dao;

import org.example.iplstats.domain.Player;
import org.example.iplstats.dto.RoleStatsDto;
import org.example.iplstats.dto.TeamStatsDto;

import java.util.List;
import java.util.ListIterator;

public interface IplStatsDao {
        List<String> selectTeamNames();
        List<String> selectRoles();

        List<Player> selectPlayersOfTream(String teamName);
        List<TeamStatsDto> selectTeamStats();
        List<RoleStatsDto> selectRoleStats(String teamName);
        List<Player> selectTopPaidPlayersOfEachTeam();


}
