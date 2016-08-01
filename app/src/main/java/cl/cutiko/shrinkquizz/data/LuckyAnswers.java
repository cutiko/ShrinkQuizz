package cl.cutiko.shrinkquizz.data;

import java.util.Date;

/**
 * Created by cutiko on 01-08-16.
 */
public class LuckyAnswers {

    private boolean day, happy;

    public LuckyAnswers(boolean happy) {
        day = new LuckyDay().verification();
        this.happy = happy;
    }

    public boolean isDay() {
        return day;
    }

    public boolean isHappy() {
        return happy;
    }

    private class LuckyDay {

        private Date today = new Date();

        private boolean verification() {
            int day = today.getDay();
            int month = today.getMonth();
            int year = today.getYear();
            int sum = day+month+year;

            if (sum%2 == 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
