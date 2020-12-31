import java.util.*;

/**
 * CSE 17 Fall 2019
 * @author Dennis Kuzminer
 * Homework #2
 * Program: Team
 */

public class Team
{

  //weeksPlayed is actually public as the main methods attempt to access it directly
  private String locationName;
  private String teamName;
  public int[] weeksPlayed;
  private String[] dateList;


  /**
   * Builds a Team given a location, name, and a list of dates the team plays
   * @param locationName Initializes the location of the team
   * @param teamName Initializes the name of the team
   * @param dateList Initializes the 17 dates that the team plays
   */
  public Team(String locationName, String teamName, String[] dateList) {
    this.locationName = locationName;
    this.teamName = teamName;
    this.dateList = dateList;
    weekPlayed();
  }


  /**
   * Builds a Team given a location and a list of dates the team plays
   * teamName is set to "N/A" by default
   * @param locationName Initializes the location of the team
   * @param dateList Initializes the 17 dates that the team plays
   */
  public Team(String locationName, String[] dateList) {
    this.teamName = "N/A";
    this.locationName = locationName;
    this.dateList = dateList;
    weekPlayed();
  }


  /**
   * Builds a Team given a list of dates the team plays
   * teamName is set to "N/A" by default
   * locationName is set to "N/A" by default
   * @param dateList Initializes the 17 dates that the team plays
   */
  public Team(String[] dateList) {
    this.teamName = "N/A";
    this.locationName = "N/A";
    this.dateList = dateList;
    weekPlayed();
  }


  /**
   * Uses dateList to create a similar list, but instead of dates, it finds if an
   * element is "00/00," meaning a game is not played that week, and makes the corresponding
   * index in weeksPlayed 0.
   * @return weeksPlayed The same thing as dateList but represented as 1's and 0's
   */
  public int[] weekPlayed() {
    weeksPlayed = new int[17];
    // I know that it might be a bit dangerous to use 17 instead of weeksPlayed.length
    // But throughout the code I am trusting the user that he/she enters an array of 17
    for(int i = 0; i < 17; i++) {
      if(dateList[i].equals("00/00")) {
        weeksPlayed[i] = 0;
      }
      else {
        weeksPlayed[i] = 1;
      }
    }
    return weeksPlayed;
  }


  /**
   * Finds the week that the Team doesn't play (Pretty much just the index + 1 of "00/00")
   * @return Returns the week that is not played by the Team
   */
  public int byWeek() {
    for(int i = 0; i < 17; i++) {
      if(dateList[i].equals("00/00")) {
        // The week would be the index plus 1 because weeks start counting at 1
        return i + 1;
      }
    }
    // If the Team does not miss any games, it will return -1. Base case.
    return -1;
  }


  /**
   * Finds the estimated sales of a particular Team given some parameters
   * @param week The week that the Team will be playing
   * @param someTeam The Team that is playing
   * @param ticketPrice The price of 1 ticket
   * @param numSeats The number of seats in the stadium
   * @param percent The expected percentage of seats that will fill up between 0 and 1, inclusive
   * @return Returns the ticket price times the number of seats times the expected percent of sales (The total revenue)
   */
  public static double estimateSales(int week, Team someTeam, double ticketPrice, int numSeats, double percent) {
    // This if-statement makes sure that the Team actually plays on that day
    if(!someTeam.dateList[week-1].equals("00/00")) {
      // Revenue
      return ticketPrice * numSeats * percent;
    }
    // If the Team doesn't play that day the revenue will be 0
    return 0.00;
  }


  /**
   * Getter method for the dateList
   * @return Returns the dateList as it is private
   */
  public String[] getDateList() {
    return dateList;
  }


  /**
   * Checks to see if 2 (and only 2) teams play on the same day
   * @param teams An array of length 2 with the teams that are playing
   * @param date The date to look for
   * @return Returns true if 2 teams play on the same day and false otherwise
   */
  public static boolean checkSchedule(Team[] teams, String date) {
    // This could have probably been done with much less code but oh well :)
    // Initially assumes that team 1 does not play on the date
    boolean team1Plays = false;
    String[] team1DateList = teams[0].getDateList();
    for(int i = 0; i < 17; i++) {
      // If the date is found in in the date list, team1Plays is set to true
      // and it breaks from the for loop and moves onto the second half
      if(team1DateList[i].equals(date)){
        team1Plays = true;
        break;
      }
    }
    // Second half of the code is the same as the first but applies to the other Team in teams
    boolean team2Plays = false;
    String[] team2DateList = teams[1].getDateList();
    for(int i = 0; i < 17; i++) {
      if(team2DateList[i].equals(date)){
        team2Plays = true;
        break;
      }
    }
    // Will only return true if both teams play on the same day
    return team1Plays && team2Plays;
  }


  /**
   * Prints a table of the projected sales of a Team on a particulat week
   * @param teams An array of max 3 Teams
   * @param ticketPrice The price of one ticket
   * @param numSeats The number of seats in a stadium
   * @param week The week to varify when the Team plays
   */
  public static void printSales(Team[] teams, double ticketPrice, int numSeats, int week) {
    // This is some beefy code and can probably be reduced, but I mean, it gets the job done ¯\_(ツ)_/¯
    /* diffDaysPlayed123 determines how many different days are played
    It changes between 1-3 as the max number of teams can be 3
    By default all teams play on 1 day which means diffDaysPlayed123 = 1
    If any combination of 2 teams play on one day that means that diffDaysPlayed123 = 2
    If all teams play on different days diffDaysPlayed123 = 3
     */
    int diffDaysPlayed123 = 1;

    // This covers all the cases if there are only 2 teams to consider
    if(teams.length == 2) {
      String[] team1DateList = teams[0].getDateList();
      // Arrays.copyOfRange(teams, 0, 2) makes a new array with the first 2 elements of teams (probably redundant)
      // team1DateList[week-1] gives the date that needs to be checked for
      // If they don't play on the same day, diffDaysPlayed123 = 2
      if(!checkSchedule(Arrays.copyOfRange(teams, 0, 2), team1DateList[week-1])) {
        diffDaysPlayed123 = 2;
      }
    }

    // This covers all cases if there are only 3 teams to consider
    if(teams.length == 3) {
      // The next 4 lines are only there to consolidate some code
      String[] team1DateList = teams[0].getDateList();
      String[] team2DateList = teams[1].getDateList();
      String[] team3DateList = teams[2].getDateList();
      Team[] arrWithFirstAndLast = {teams[0], teams[2]};
      /* So, the next set of if-statements are all the same. There are only 2 things that vary:
      the not (!) and the value diffDaysPlayed123 is set to.
      Arrays.copyOfRange(teams, #, #) makes a subarray (kind of like substring)
      team1DateList[week-1] gives the date that needs to be checked for
            The first if-statement says if teams 1 and 2 don't play on the same day and teams 2
            and 3 don't play on the same day and teams 1 and 3 don't play on the same day,
            then that means that none of the teams play on the same day.
            The same methodology is followed throughtout the following if-statements
       All combinations that give 2 different days are here and
       the chance that they all play on the same day.
       */
      if(!checkSchedule(Arrays.copyOfRange(teams, 0, 2), team1DateList[week-1])
              && !checkSchedule(Arrays.copyOfRange(teams, 1, 3), team2DateList[week-1])
              && !checkSchedule(arrWithFirstAndLast, team3DateList[week-1])) {
        diffDaysPlayed123 = 3;
      }
      if(checkSchedule(Arrays.copyOfRange(teams, 0, 2), team1DateList[week-1])
              && !checkSchedule(Arrays.copyOfRange(teams, 1, 3), team2DateList[week-1])
              && !checkSchedule(arrWithFirstAndLast, team3DateList[week-1])) {
        diffDaysPlayed123 = 2;
      }
      if(!checkSchedule(Arrays.copyOfRange(teams, 0, 2), team1DateList[week-1])
              && checkSchedule(Arrays.copyOfRange(teams, 1, 3), team2DateList[week-1])
              && !checkSchedule(arrWithFirstAndLast, team3DateList[week-1])) {
        diffDaysPlayed123 = 2;
      }
      if(!checkSchedule(Arrays.copyOfRange(teams, 0, 2), team1DateList[week-1])
              && !checkSchedule(Arrays.copyOfRange(teams, 1, 3), team2DateList[week-1])
              && checkSchedule(arrWithFirstAndLast, team3DateList[week-1])) {
        diffDaysPlayed123 = 2;
      }
      if(checkSchedule(Arrays.copyOfRange(teams, 0, 2), team1DateList[week-1])
              && checkSchedule(Arrays.copyOfRange(teams, 1, 3), team2DateList[week-1])
              && checkSchedule(arrWithFirstAndLast, team3DateList[week-1])) {
        diffDaysPlayed123 = 1;
      }
    }

    /*
    This is actually where it prints the chart
    It loops over seven cases and calls estimateSales every time
    ((double) 70 + 5 * i) creates the percent values and goes from 70 to 100 and increments by 5
    estimateSales uses:
    the week that was played
    the first Team just for reference
    the ticket price
    the number of seats
    and the percent
    Lastly, it is multiplied by diffDaysPlayed123 to see how many different games are being played
    ***This is all assuming that each Team prices each ticket the same price***
     */
    System.out.println("\t\tSeats\t\tSold\t\tRevenue");
    System.out.println("\t\t_____\t\t____\t\t_______");
    for(int i = 0; i < 7; i++) {
      System.out.println("\t\t" + numSeats + "\t\t" + ((double) 70 + 5 * i) + "%" + "\t\t" + "$" + diffDaysPlayed123 * estimateSales(week, teams[0], ticketPrice, numSeats, ((double) 70 + 5 * i) / 100) + "0");
    }
  }
}
