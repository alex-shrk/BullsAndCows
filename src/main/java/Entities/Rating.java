package Entities;

public class Rating {
    private String userName;
    private String avgCountTurns;

    public Rating() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvgCountTurns() {
        return avgCountTurns;
    }

    public void setAvgCountTurns(String avgCountTurns) {
        this.avgCountTurns = avgCountTurns;
    }
}
