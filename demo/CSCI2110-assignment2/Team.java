
public class Team {
    private String name;
    private int totalGWG;
    private int totalPIM;
    private List<PlayerRecord> tList;

    public Team(String name, int totalGWG, int totalPIM) {
        tList=new List<PlayerRecord>();
        this.name = name;
        this.totalGWG = totalGWG;
        this.totalPIM = totalPIM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//get the total most game winning goals
    public int getTotalGWG() {
        //go the loop from the first player in the team
        PlayerRecord p = tList.first();
        int sum = 0;
        if (p == null) {
            return 0;
        } else {
            while (p != null) {
                sum += p.getGWG();
                p = tList.next();
            }
        }
        return sum;
    }

    public void setTotalGWG(int totalGWG) {
        this.totalGWG = totalGWG;
    }


    public void setTotalPIM(int totalPIM) {
        this.totalPIM = totalPIM;
    }
//get the total penalty time of the whole team
    public int getTotalPIM() {
        //go the loop form the first player in the team
        PlayerRecord p = tList.first();
        int sum = 0;
        if (p == null) {
            return 0;
        } else {
            while (p != null) {
                sum += p.getPIM();
                p = tList.next();
            }
        }
        return sum;
    }

    public void addPlayer(PlayerRecord player) {
        tList.add(player);
    }
}
