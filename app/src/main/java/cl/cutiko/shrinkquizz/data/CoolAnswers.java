package cl.cutiko.shrinkquizz.data;

/**
 * Created by cutiko on 01-08-16.
 */
public class CoolAnswers {

    private String userName;
    private boolean party;
    private int drinks;

    public CoolAnswers(String userName, boolean party, int drinks) {
        this.userName = userName;
        this.party = party;
        this.drinks = drinks;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isParty() {
        return party;
    }

    public int getDrinks() {
        return drinks;
    }
}
