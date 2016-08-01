package cl.cutiko.shrinkquizz.data;

import android.content.Context;

import cl.cutiko.shrinkquizz.R;

/**
 * Created by cutiko on 01-08-16.
 */
public class CoolResult extends CoolAnswers {

    public CoolResult(String userName, boolean party, int drinks) {
        super(userName, party, drinks);
    }

    public String details(Context context) {
        String start = String.format(context.getString(R.string.name_format), getUserName());
        return start + partyDetails() + drinkDetails();
    }

    private String partyDetails() {
        return (isParty()) ? "A todos les encanta salir contigo, " : "Deberías empezar a salir más, ";
    }

    private String drinkDetails() {
        return (getDrinks() < 5) ? "bebes como una nena!" :  "eres una bestia de las fiestas!";
    }
}
