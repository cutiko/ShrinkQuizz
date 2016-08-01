package cl.cutiko.shrinkquizz.data;

/**
 * Created by cutiko on 01-08-16.
 */
public class LuckyResult extends LuckyAnswers{

    public LuckyResult(boolean happy) {
        super(happy);
    }

    public String detaisl() {
        return happyDetails() + dayDetails();
    }

    private String happyDetails() {
        return (isHappy()) ? "Mantente positivo, " : "El buen animo es lo primero que necesitas, ";
    }

    private String dayDetails() {
        return (isDay()) ? "y hoy es tu día de suerte!" : "pero hoy no es tu día de suerte :( trata mañana";
    }
}
