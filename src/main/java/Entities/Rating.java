package Entities;

/**
 * Rating entity
 *
 */
public class Rating {
    /**
     * User name
     */
    private String user;
    /**
     * Average of steps which spent for guessing right combination
     * See RatingView in CREATE.SQL file
     */
    private String result;

    public Rating() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
