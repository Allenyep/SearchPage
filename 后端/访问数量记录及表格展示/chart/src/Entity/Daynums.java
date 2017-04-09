package Entity;

/**
 * Created by allen on 2017/4/9.
 */

public class Daynums {
   private String day;
   private int daynums;
   public Daynums(){}

    public Daynums(String day, int daynums) {
        this.day = day;
        this.daynums = daynums;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDaynums() {
        return daynums;
    }

    public void setDaynums(int daynums) {
        this.daynums = daynums;
    }
}
