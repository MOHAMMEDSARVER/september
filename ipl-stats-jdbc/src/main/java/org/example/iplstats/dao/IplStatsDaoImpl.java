package org.example.iplstats.dao;

import org.example.iplstats.domain.Player;
import org.example.iplstats.dto.RoleStatsDto;
import org.example.iplstats.dto.TeamStatsDto;
import org.example.iplstats.util.ConnectionUtil;

import javax.management.relation.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IplStatsDaoImpl implements IplStatsDao {
    @Override
    public List<String> selectTeamNames() {
        String sql = "select distinct team_name from player";

        ConnectionUtil util = ConnectionUtil.getInstance();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<String> teanName = new ArrayList<>();

        try {
            con = util.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("team_name");
                teanName.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, con, st);
        }

        return teanName;
    }

    @Override
    public List<String> selectRoles() {
        String sql = "select distinct role from player";
        List<String> role = new ArrayList<>();
        ConnectionUtil util = ConnectionUtil.getInstance();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = util.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                role.add(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, con, st);
        }
        return role;
    }

    @Override
    public List<Player> selectPlayersOfTream(String teamName) {
        String sql = "select name,role,team_name,amount from player where team_name=?";
        List<Player> players = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ConnectionUtil util = ConnectionUtil.getInstance();
        try {
            con = util.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, teamName);
            rs = pst.executeQuery();

            while (rs.next()) {
                Player p = new Player();
                p.setName(rs.getString("name"));
                p.setRole(rs.getString("role"));
                p.setTeam_name(rs.getString("team_name"));
                p.setAmount(rs.getDouble("amount"));
                players.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, con, pst);
        }
        return players;
    }

    @Override
    public List<TeamStatsDto> selectTeamStats() {
        String sql = "select  team_name ,count(name) as totalPlayers,sum(amount) as totalamount,min(amount) as minamount,max(amount) as maxamount,avg(amount) as avgamount  from player p group by team_name";
        ConnectionUtil util = ConnectionUtil.getInstance();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<TeamStatsDto> teamStats = new ArrayList<>();
        try {
            con = util.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String teanmName = rs.getString("team_name");
                int totalPlayers = rs.getInt("totalPlayers");
                int sumAmount = rs.getInt("totalamount");
                int minAmount = rs.getInt("minamount");
                int maxAmount = rs.getInt("maxamount");
                int avgAmount = rs.getInt("avgamount");

                TeamStatsDto teamStatsDto = TeamStatsDto.builder()
                        .teamName(teanmName)
                        .totalPlayers(totalPlayers)
                        .totalAmount(sumAmount)
                        .maxAmount(maxAmount)
                        .minAmount(minAmount)
                        .avgAmount(avgAmount)
                        .build();
                teamStats.add(teamStatsDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, con, st);
        }

        return teamStats;
    }

    @Override
    public List<RoleStatsDto> selectRoleStats(String teamName) {
        String sql = "select role,count(name) as totalPlayers,sum(amount) as totalamount,min(amount) as minamount,max(amount) as maxamount,avg(amount) as avgamount  from player p where team_name = ? group by role";

        List<RoleStatsDto> roleStatsDtos = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ConnectionUtil util = ConnectionUtil.getInstance();
        try {
            con = util.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, teamName);
            rs = pst.executeQuery();
            while (rs.next()) {
                RoleStatsDto roleStatsDto = RoleStatsDto.builder()
                        .roleName(rs.getString("role"))
                        .totalPlayers(rs.getInt("totalPlayers"))
                        .totalAmount(rs.getDouble("totalamount"))
                        .avgAmount(rs.getDouble("avgamount"))
                        .maxAmount(rs.getDouble("maxamount"))
                        .minAmount(rs.getDouble("minamount"))
                        .build();
                roleStatsDtos.add(roleStatsDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, con, pst);
        }

        return roleStatsDtos;
    }

    @Override
    public List<Player> selectTopPaidPlayersOfEachTeam() {
        String sql="";
        return null;
    }
}
