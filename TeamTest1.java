import java.util.*;
// Tests some default cases
public class TeamTest1{
    public static void main(String[] args){
        // Build one team
        String[] team1Schedule = {"01/03","01/08","02/03","02/08","03/01","03/08","04/01","04/08",
                "05/01","05/08","06/01","06/08","07/01","07/08","08/01","08/08","09/01"};
        Team team1 = new Team("Philadelphia","Eagles", team1Schedule);
        System.out.println("Weeks played by team 1: " + Arrays.toString(team1.weeksPlayed));


        // Build a second team
        String[] team2Schedule = {"01/03","01/08","02/03","02/08","03/01","03/08","04/01","04/08",
                "05/01","05/08","06/01","06/08","07/01","07/08","08/01","08/08","09/01"};
        Team team2 = new Team("Giants", team2Schedule);
        System.out.println("Weeks played by team 2: " + Arrays.toString(team2.weeksPlayed));


        // Build a third team
        String[] team3Schedule = {"01/03","01/08","02/03","02/08","03/01","03/08","04/01","04/08",
                "05/01","05/08","06/01","06/08","07/01","07/08","08/01","08/08","09/01"};
        Team team3 = new Team(team3Schedule);
        System.out.println("Weeks played by team 3: " + Arrays.toString(team3.weeksPlayed));


        // Find byweeks for all
        System.out.println("Team 1 byweek: " + team1.byWeek());
        System.out.println("Team 2 byweek: " + team2.byWeek());
        System.out.println("Team 3 byweek: " + team3.byWeek());

        // Print Sales for various combinations of the teams
        Team[] matchup1 = {team1,team2,team3};
        System.out.println("Teams 1, 2, 3 Total Sales During Week 2:");
        Team.printSales(matchup1, 20, 100, 2);
        System.out.println();
        System.out.println();

        System.out.println("Teams 1, 3 Total Sales During Week 2:");
        Team[] matchup2 = {team1,team3};
        Team.printSales(matchup2, 20, 100, 2);
        System.out.println();
        System.out.println();

        System.out.println("Team 2 Total Sales During Week 2:");
        Team[] matchup3 = {team2};
        Team.printSales(matchup3, 20, 100, 2);
    }


}
