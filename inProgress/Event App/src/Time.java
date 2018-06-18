/**
 * Created by jonny on 19.06.17.
 */
public class Time {
    private int hour;
    private int minute;

    Time(int hour,int minute){
        if (hour <= 0 || hour >= 24){
            throw new IllegalArgumentException("");
        }
        if (minute < 0 || minute >= 60){
            throw new IllegalArgumentException("");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
