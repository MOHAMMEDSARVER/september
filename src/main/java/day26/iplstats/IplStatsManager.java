package day26.iplstats;

public class IplStatsManager {
    public static void main(String[] args) {
        IplStatsServiceImpl iplStatsService = new IplStatsServiceImpl();
        System.out.println(iplStatsService.getAllPlayers().size());
        System.out.println("__________________TEAM NAMES_____________________");
        System.out.println(iplStatsService.getTeamNames());
        System.out.println("__________________PLATER BY TEAM NAMES_____________________");
        System.out.println(iplStatsService.playersByTeam("MI"));
        System.out.println("__________________PLATER BY ROLE_____________________");
        System.out.println(iplStatsService.playersByRole("Batsman"));

        System.out.println("__________________PLATER BY playersByTeamAndRole _____________________");
        System.out.println(iplStatsService.playersByTeamAndRole("MI", "Batsman"));


        System.out.println("__________________getRoleNames_____________________");
        System.out.println(iplStatsService.getRoleNames());


        System.out.println("__________________totalAmountByTeam_____________________");
        System.out.println(iplStatsService.totalAmountByTeam("MI"));

    }
}
