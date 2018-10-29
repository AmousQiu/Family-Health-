public class TeamStats {
    private List<Team> teamList;
public TeamStats(){
    teamList=new List<Team>();
}
//get the most penalty minutes from the whole league
    public void mostPenaltyMinutes() {
        double max = 0, amt;
        Team team = teamList.first();
        //go through the whole list to see the maximum number
        while (team != null) {
            amt = team.getTotalPIM();
            if (amt > max) {
                max = amt;
            }
            team = teamList.next();
        }
        team = teamList.first();
        //go through the whole list to see the team has maximum number
        while (team != null) {
            amt = team.getTotalPIM();
            if (amt == max) {
                System.out.println(team.getName());
            }
            team = teamList.next();
        }
    }
//get the team who has the most game winning goals
    public void mostgameWinningGoals() {
        double max = 0, amt;
        Team team = teamList.first();
        while (team != null) {
            amt = team.getTotalGWG();
            if (amt > max) {
                max = amt;
            }
            team = teamList.next();
        }
        team = teamList.first();
        while (team != null) {
            amt = team.getTotalGWG();
            if (amt == max) {
                System.out.println(team.getName());
            }
            team = teamList.next();
        }
    }

    public Team first() {
        return teamList.first();
    }

    public Team next() {
        return teamList.next();
    }

    //to see if there is already the team through the whole team lists
    //put it here to reduce the work in the main method
    public boolean containTeam(String tName) {
        Team team = teamList.first();
        if (team == null) {
            return false;
        } else {
            while (team != null) {
                if (tName.equals(team.getName())) {
                    return true;
                } else {
                    team = teamList.next();
                }
            }
        }
        return false;
    }

    public void addTeam(Team team){
        teamList.add(team);
    }
}
