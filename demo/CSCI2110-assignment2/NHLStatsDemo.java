import java.io.*;
import java.util.Scanner;

public class NHLStatsDemo {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        Scanner input = new Scanner(System.in);
        PlayerStats pList = new PlayerStats();
        TeamStats tList = new TeamStats();
        String name;
        String team;
        String GP;//Games played
        String G;//Goals Scored
        String A;//Assists
        String P;
        String Rating;
        String PPG;//power play goals
        String PPP;//power play points
        String PTSG;//points per game
        String SHG;//short handed goals
        String SHP;//short handed points
        String GWG;//game winning goals
        String PIM;//penalty minutes
        String SOG;//shots on goal
        String SP;//shooting percentage
        String ATOI;//average time on ice
        PlayerRecord player = null;
        boolean flag = true;//used to judge if there is already a team created
        //input from the file stats
        while (inputFile.hasNext()) {
            name = inputFile.nextLine();
            team = inputFile.nextLine();
            GP = inputFile.nextLine();
            G = inputFile.nextLine();
            A = inputFile.nextLine();
            P = inputFile.nextLine();
            Rating = inputFile.nextLine();
            PPG = inputFile.nextLine();
            PPP = inputFile.nextLine();
            PTSG = inputFile.nextLine();
            SHG = inputFile.nextLine();
            SHP = inputFile.nextLine();
            GWG = inputFile.nextLine();
            PIM = inputFile.nextLine();
            SOG = inputFile.nextLine();
            SP = inputFile.nextLine();
            ATOI = inputFile.nextLine();
            player = new PlayerRecord(name, team, Integer.parseInt(GP), Integer.parseInt(G), Integer.parseInt(A), Integer.parseInt(P), Integer.parseInt(Rating), Integer.parseInt(PPG), Integer.parseInt(PPP), Double.parseDouble(PTSG), Integer.parseInt(SHG), Integer.parseInt(SHP), Integer.parseInt(GWG), Integer.parseInt(PIM), Integer.parseInt(SOG), Double.parseDouble(SP), ATOI);
            pList.addPlayer(player);
        }
        inputFile.close();
        //create a list of teams and put the players into each team
        PlayerRecord p = pList.first();
        while (p != null) {//start from the start from player list
            Team t1 = tList.first();//start form the start of team list
            if (t1 == null) {//if there is no team exits
                Team newTeam = new Team(p.getTeam(), 0, 0);//set a new team and initial the stats to 0
                newTeam.addPlayer(p);//put the player into the team
                tList.addTeam(newTeam);//put the team to the list
            } else {
                flag = false;//if the team find its name on the list yet
                while (t1 != null) {
                    if (t1.getName().equals(p.getTeam())) {//if there is already a team
                        t1.addPlayer(p);
                        flag = true;//means already found the team
                    }
                    t1 = tList.next();
                }
                if (!flag) {//if there is not a team that the player should belong to ,create a new team with the team name
                    Team newTeam = new Team(p.getTeam(), 0, 0);
                    newTeam.addPlayer(p);
                    tList.addTeam(newTeam);
                }
            }
            p = pList.next();
        }
        System.out.println("NHL Results Summary:");
        System.out.println("Players with the highest game winning goals and their teams:");
        pList.maxGWG();
        System.out.println("Players with the highest average time on ice and their team:");
        pList.maxTime();
        System.out.println("Players that have maximum number of penalty minutes and their teams:");
        pList.mostAggresive();
        System.out.println("Players that have the maximum number of shots on goal and their teams");
        pList.mostPromising();
        System.out.println("Players that have the maximum number of assists and their teams:");
        pList.mostAssists();
        System.out.println("Teams that had the most number of penalty minutes: ");
        tList.mostPenaltyMinutes();
        System.out.println("Teams had the most number of game winning goals:");
        tList.mostgameWinningGoals();
    }
}
