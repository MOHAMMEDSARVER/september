package org.example.jdbc.basics;

import org.example.jdbc.domain.Player;
import org.example.jdbc.dto.TeamStatsDto;
import org.example.jdbc.util.ConnectionUtil;

import javax.print.CancelablePrintJob;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

record Student(String name, int age) {
}

public class JdbcManager {
    public static void main(String[] args) {
       /* List<Player> players = getPlayers();
        System.out.println(players.size());
        System.out.println(players.get(1));
*/
        // Team stats
      /*  TeamStatsDto teamStatsDto = getTeamStats("RCB");
        System.out.println(teamStatsDto);*/

        // Players by team,role,country
      /*  List<Player> playersByTeamRoleCountry = getPlayers("RCB", "Batsman");
        playersByTeamRoleCountry.forEach(System.out::println);*/

        /*  createTable();*/

//        insertData();
        /* alterTable();*/
        // addMultipleRecords();
        //updateAge();
        List<Student> students = getStudent();
        System.out.println(students.size());
    }

    private static List<Student> getStudent() {
        String sql = "select name,age from sample_1";
        List<Student> stlist = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        ConnectionUtil util = ConnectionUtil.getInstance();
        try {
            con = util.getConnectio();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Student student = new Student(name, age);
                stlist.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, st, con);
        }
        return stlist;
    }

    private static void addMultipleRecords() {
        List<Student> std = List.of(new Student("manju", 25),
                new Student("suresh", 30),
                new Student("rajesh", 45));

        String sql = "insert into sample_1(name,age) values(?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        ConnectionUtil util = ConnectionUtil.getInstance();
        try {
            con = util.getConnectio();
            pst = con.prepareStatement(sql);
            for (Student s : std) {
                pst.setString(1, s.name());
                pst.setInt(2, s.age());
                pst.addBatch();
            }
            int[] arr = pst.executeBatch();
            System.out.println(arr.length + " number of records are added.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(pst, con);
        }
    }

    private static void updateAge() {
        String sql = "update sample_1 set age = age + 1 where age >= 20";
        Connection con = null;
        Statement st = null;
        ConnectionUtil util = ConnectionUtil.getInstance();

        try {
            con = util.getConnectio();
            st = con.createStatement();
            st.execute(sql);

            System.out.println("Table updated successfully..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(st, con);
        }
    }

    private static void alterTable() {
        String sql = "alter table sample_1 add column age int default 20";
        Connection con = null;
        Statement st = null;
        ConnectionUtil util = ConnectionUtil.getInstance();

        try {
            con = util.getConnectio();
            st = con.createStatement();
            st.execute(sql);

            System.out.println("table is alerd...");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(st, con);
        }
    }

    private static void insertData() {
        String sql = "insert into sample_1(name) values(?)";
        Connection con = null;
        PreparedStatement st = null;
        ConnectionUtil util = ConnectionUtil.getInstance();

        try {
            con = util.getConnectio();
            st = con.prepareStatement(sql);
            st.setString(1, "manju");
            int count = st.executeUpdate();
            System.out.println(count + " number of records are inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(st, con);
        }
    }

    private static void createTable() {
        String sql = "create table sample_1(id serial,name varchar(50))";
        Connection con = null;
        Statement st = null;
        ConnectionUtil util = ConnectionUtil.getInstance();
        try {
            con = util.getConnectio();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Table Created successfull..");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(st, con);
        }

    }

    private static List<Player> getPlayers(String team_name, String player_role) {

        String sql = "select * from player where team_name =? and role=?";
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Player> players = new ArrayList<>();
        ConnectionUtil util = ConnectionUtil.getInstance();
        try {
            con = util.getConnectio();
            st = con.prepareStatement(sql);
            st.setString(1, team_name);
            st.setString(2, player_role);
            rs = st.executeQuery();

            while (rs.next()) {
                String team = rs.getString("team_name");
                String name = rs.getString("name");
                String role = rs.getString("role");
                double amount = rs.getDouble("amount");

                Player player = Player.builder()
                        .team_name(team)
                        .name(name)
                        .role(role)
                        .amount(amount)
                        .build();
                players.add(player);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, st, con);
        }

        return players;

    }

    private static TeamStatsDto getTeamStats(String rcb) {
        String sql = "select team_name ,count(*) as count,sum(amount) as total,max(amount) as max,min(amount) as min,avg(amount) as avg from player where team_name =? group by team_name ";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        TeamStatsDto teamStatsDto = null;

        ConnectionUtil util = ConnectionUtil.getInstance();
        try {
            conn = util.getConnectio();
            st = conn.prepareStatement(sql);
            st.setString(1, rcb);
            rs = st.executeQuery();
            while (rs.next()) {
                String team = rs.getString("team_name");
                int count = rs.getInt("count");
                Double total = rs.getDouble("total");
                Double max = rs.getDouble("max");
                Double min = rs.getDouble("min");
                Double avg = rs.getDouble("avg");
                teamStatsDto = TeamStatsDto.builder().teamName(team)
                        .maxAmount(max)
                        .playerCount(count)
                        .minAmount(min)
                        .avgAmount(avg)
                        .totalAmount(total)
                        .build();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, st, conn);
        }
        return teamStatsDto;

    }

    private static List<Player> getPlayers() {
        String sql = "select name,role,amount,team_name  from player";
        Connection conn;
        Statement st = null;
        ResultSet rs = null;


        List<Player> players = new ArrayList<>();
        ConnectionUtil util = ConnectionUtil.getInstance();
        try {
            conn = util.getConnectio();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                Double amount = rs.getDouble("amount");
                String team = rs.getString("team_name");
                Player player = Player.builder()
                        .name(name)
                        .role(role)
                        .amount(amount)
                        .team_name(team)
                        .build();
                players.add(player);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return players;
    }
}
