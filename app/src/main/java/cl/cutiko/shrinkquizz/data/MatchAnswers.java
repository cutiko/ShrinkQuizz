package cl.cutiko.shrinkquizz.data;

import android.content.Context;

/**
 * Created by cutiko on 02-08-16.
 */
public class MatchAnswers {

    private String userName, loverName, quarter;
    private Context context;

    public MatchAnswers(String userName, String loverName, String quarter, Context context) {
        this.userName = userName;
        this.loverName = loverName;
        this.quarter = quarter;
        this.context = context;
    }

    public String getUserName() {
        return userName;
    }

    public String getLoverName() {
        return loverName;
    }

    public String getQuarter() {
        return quarter;
    }

    public Context getContext() {
        return context;
    }
}
