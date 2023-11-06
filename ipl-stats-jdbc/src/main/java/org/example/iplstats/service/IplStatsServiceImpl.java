package org.example.iplstats.service;

import org.example.iplstats.dao.IplStatsDao;
import org.example.iplstats.dao.IplStatsDaoImpl;
import org.example.iplstats.domain.Player;
import org.example.iplstats.dto.RoleStatsDto;
import org.example.iplstats.dto.TeamStatsDto;

import java.util.List;

public class IplStatsServiceImpl implements IplStatsService {

    IplStatsDao iplStatsDao = new IplStatsDaoImpl();

    @Override
    public List<String> getTeamNames() {

        return iplStatsDao.selectTeamNames();

    }

    @Override
    public List<String> getRoles() {
        return iplStatsDao.selectRoles();
    }

    @Override
    public List<Player> getPlayersOfTeam(String teamName) {
        assert teamName != null : "Team Name Cannot be null";
        return iplStatsDao.selectPlayersOfTream(teamName);
    }

    @Override
    public List<TeamStatsDto> getTeamStats() {
        return iplStatsDao.selectTeamStats();
    }

    @Override
    public List<RoleStatsDto> getRoleStats(String teamName) {
        return iplStatsDao.selectRoleStats(teamName);
    }

    @Override
    public List<Player> getTopPaidPlayersOfEachTeam() {
        return null;
    }
}
