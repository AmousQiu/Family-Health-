public class PlayerRecord {
    private String name;
    private String team;
    private int GP;//Games played
    private int G;//Goals Scored
    private int A;//Assists
    private int P;
    private int Rating;
    private int PPG;//power play goals
    private int PPP;//power play points
    private double PTSG;//points per game
    private int SHG;//short handed goals
    private int SHP;//short handed points
    private int GWG;//game winning goals
    private int PIM;//penalty minutes
    private int SOG;//shots on goal
    private double SP;//shooting percentage
    private String ATOI;//average time on ice

    //constructor create a player record
    public PlayerRecord(String name, String team, int GP, int g, int a, int p, int rating, int PPG, int PPP, double PTSG, int SHG, int SHP, int GWG, int PIM, int SOG, double SP, String ATOI) {
        this.name = name;
        this.team = team;
        this.GP = GP;
        G = g;
        A = a;
        P = p;
        Rating = rating;
        this.PPG = PPG;
        this.PPP = PPP;
        this.PTSG = PTSG;
        this.SHG = SHG;
        this.SHP = SHP;
        this.GWG = GWG;
        this.PIM = PIM;
        this.SOG = SOG;
        this.SP = SP;
        this.ATOI = ATOI;
    }


    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGP() {
        return GP;
    }

    public void setGP(int GP) {
        this.GP = GP;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public int getPPG() {
        return PPG;
    }

    public void setPPG(int PPG) {
        this.PPG = PPG;
    }

    public int getPPP() {
        return PPP;
    }

    public void setPPP(int PPP) {
        this.PPP = PPP;
    }

    public double getPTSG() {
        return PTSG;
    }

    public void setPTSG(double PTSG) {
        this.PTSG = PTSG;
    }

    public int getSHG() {
        return SHG;
    }

    public void setSHG(int SHG) {
        this.SHG = SHG;
    }

    public int getSHP() {
        return SHP;
    }

    public void setSHP(int SHP) {
        this.SHP = SHP;
    }

    public int getGWG() {
        return GWG;
    }

    public void setGWG(int GWG) {
        this.GWG = GWG;
    }

    public int getPIM() {
        return PIM;
    }

    public void setPIM(int PIM) {
        this.PIM = PIM;
    }

    public int getSOG() {
        return SOG;
    }

    public void setSOG(int SOG) {
        this.SOG = SOG;
    }

    public double getSP() {
        return SP;
    }

    public void setSP(double SP) {
        this.SP = SP;
    }

    public String getATOI() {
        return ATOI;
    }

    public void setATOI(String ATOI) {
        this.ATOI = ATOI;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }
}




