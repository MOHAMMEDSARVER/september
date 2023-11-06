package org.example.iplstats;

import org.example.iplstats.domain.Player;
import org.example.iplstats.dto.RoleStatsDto;
import org.example.iplstats.dto.TeamStatsDto;
import org.example.iplstats.service.IplStatsService;
import org.example.iplstats.service.IplStatsServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class IplStatsManager {
    public static void main(String[] args) {
        IplStatsService iplStatsService = new IplStatsServiceImpl();
        // Get players of team -> CSK
        List<Player> players = iplStatsService.getPlayersOfTeam("CSK");
        System.out.println("total numbe of playes in the team are: " + players.size());
        //get all team names

        List<String> teamNaMes = iplStatsService.getTeamNames();
        System.out.println(teamNaMes);

        //get roles
        List<String> role = iplStatsService.getRoles();
        System.out.println("Roles in the IPL team: " + role);
        //get team stats(min,max,avg,totalAmount,team name , total player)
        List<TeamStatsDto> teamstats = iplStatsService.getTeamStats();
        System.out.println("Team Stats:  " + teamstats);


        //get rolestas(team)
        List<RoleStatsDto> roleStasList=iplStatsService.getRoleStats("MI");
        System.out.println("Role stats of the team : MI is "+roleStasList);
        //gettoppaidplayer of each team
    }
}
