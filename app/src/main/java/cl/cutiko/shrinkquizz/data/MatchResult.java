package cl.cutiko.shrinkquizz.data;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import cl.cutiko.shrinkquizz.R;

/**
 * Created by cutiko on 02-08-16.
 */
public class MatchResult extends MatchAnswers {

    public MatchResult(String userName, String loverName, String quarter, Context context) {
        super(userName, loverName, quarter, context);
    }

    public String details() {
        return resolver();
    }

    private String resolver() {
        int sum = new QuarterDetails().quarterResult() + new NamesResult().nameResult();
        if (sum >= 100) {
            if (sum % 2 == 0) {
                return "Son la pareja perfecta";
            } else {
                return "Son la pareja casi perfecta";
            }
        } else {
            if (sum % 2 == 0) {
                return "Podrían mejorar";
            } else {
                return "Evalua tu relación";
            }
        }
    }

    private class QuarterDetails {

        private Map<String, Integer> map = new HashMap<>();

        private void setMap(){
            String[] quarters = getContext().getResources().getStringArray(R.array.quarters);
            for (int i = 0; i < quarters.length; i++) {
                map.put(quarters[i], i);
            }
        }

        private int quarterResult() {
            setMap();
            return map.get(getQuarter());
        }
    }

    private class NamesResult {
        int userSize = getUserName().length();
        int loverSize = getLoverName().length();

        private int nameResult() {
            int dif = userSize - loverSize;
            if (dif <= 0) {
                return 100;
            } else {
                return 10;
            }
        }
    }

}
