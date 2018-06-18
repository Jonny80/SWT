import java.util.Observable;
import java.util.Observer;

/**
 * Created by jonny on 11.06.17.
 */
public class Time extends Observable {
    private static Time instance;
    private int currentTime = 0;
    private int endOfTime = 100;
    private Simulation time;

    public static Time getInstance(){
        return instance;
    }

    Time(){
        instance = this.instance;
    }

    public void initEndOfTime(int seconds){
        currentTime = 0;
        if (seconds < 0){
            throw new IllegalArgumentException("");
        }
        endOfTime = seconds;
        setChanged();
    }


    public int getCurrentTime(){
        return currentTime;
    }

    public void run(){
        while (currentTime < endOfTime){
            currentTime++;
            setChanged();
            notifyObservers(currentTime);
        }
    }

}
