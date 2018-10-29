public class PlayerStats {
    private List<PlayerRecord> playerlist;

    public PlayerStats() {
        playerlist = new List<PlayerRecord>();
    }

    public void addPlayer(PlayerRecord player) {
        playerlist.add(player);
    }

    //display the player's name and team's name when he get the most GWG
    public void maxGWG() {
        double max = 0, amt;
        PlayerRecord player = playerlist.first();
        //go through the whole list
        while (player != null) {
            amt = player.getGWG();
            if (amt > max) {
                max = amt;
            }
            player = playerlist.next();
        }
        //now we get the max amount
        player = playerlist.first();
        while (player != null) {
            amt = player.getGWG();
            if (amt == max) {
                System.out.println(player.getName() + " " + player.getTeam());
            }
            player = playerlist.next();
        }
    }

    //display the player's name and team's name when he spent the most time on ice
    public void maxTime() {
        double max = 0;
        String[] amount;
        PlayerRecord player = playerlist.first();
        //go through the whole list
        while (player != null) {
            //get a comparable number of number,transform the clock to minutes form
            amount = player.getATOI().split(":");
            double amt = Double.parseDouble(amount[0]) + Double.parseDouble(amount[1]) / 60;
            if (amt > max) {
                max = amt;
            }
            player = playerlist.next();
        }
        player = playerlist.first();
        while (player != null) {
            amount = player.getATOI().split(":");
            double amt = Double.parseDouble(amount[0]) + Double.parseDouble(amount[1]) / 60;
            if (amt == max) {
                System.out.println(player.getName() + " " + player.getTeam());
            }
            player = playerlist.next();
        }
    }

    //display the player's name and team's name when he had the maximum number of penalty minutes
    public void mostAggresive() {
        double max = 0, amt;
        PlayerRecord player = playerlist.first();
        while (player != null) {
            amt = player.getPIM();
            if (amt > max) {
                max = amt;
            }
            player = playerlist.next();
        }
        player = playerlist.first();
        while (player != null) {
            amt = player.getPIM();
            if (amt == max) {
                System.out.println(player.getName() + " " + player.getTeam());
            }
            player = playerlist.next();
        }
    }

    //display the player's name and team's name when he had the maximum number of shots on goal
    public void mostPromising() {
        double max = 0, amt;
        PlayerRecord player = playerlist.first();
        while (player != null) {
            amt = player.getSOG();
            if (amt > max) {
                max = amt;
            }
            player = playerlist.next();
        }
        player = playerlist.first();
        while (player != null) {
            amt = player.getSOG();
            if (amt == max) {
                System.out.println(player.getName() + " " + player.getTeam());
            }
            player = playerlist.next();
        }
    }

    //display the player's name and team's name when he had the maximum number of assists
    public void mostAssists() {
        double max = 0, amt;
        PlayerRecord player = playerlist.first();
        while (player != null) {
            amt = player.getA();
            if (amt > max) {
                max = amt;
            }
            player = playerlist.next();
        }
        player = playerlist.first();
        while (player != null) {
            amt = player.getA();
            if (amt == max) {
                System.out.println(player.getName() + " " + player.getTeam());
            }
            player = playerlist.next();
        }
    }
//get the first,would be used in main method for team stats
    public PlayerRecord first() {
        return playerlist.first();
    }
//get the next ,would be used in main method for team stats
    public PlayerRecord next() {
        return playerlist.next();
    }
}
