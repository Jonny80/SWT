import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jonny on 11.06.17.
 */
public class VehicleQueue implements Observer {
    private double entryDelay;
    private double exitDelay;
    private int trafficLightRate;
    private boolean greenLight;
    private LinkedList<Vehicle> queue = new LinkedList<>();
    private VehicleGenerator generator;
    double lenght=0;
    double entryTimer = 0;
    double exitTimer = 0;

    VehicleQueue(double entryDelay,double exitDelay, int trafficLightRate,VehicleGenerator generator){
        if (trafficLightRate <= 0){
            throw new IllegalArgumentException("");
        }else {
            this.trafficLightRate = trafficLightRate;
        }
        if (entryDelay <= 0){
            throw new IllegalArgumentException("");
        }else {
            this.entryDelay = entryDelay;
        }
        if (exitDelay <= 0){
            throw new IllegalArgumentException("");
        }else {
            this.exitDelay = exitDelay;
        }
        if (generator == null){
            throw new NullPointerException("");
        }else {
            generator = new VehicleGenerator();
            this.generator = generator;
        }
    }

    public void enter() {
        Vehicle ve = generator.createVehicle();
        queue.add(ve);
    }

    public boolean change(boolean light){
        if (light == false){
            return true;
        }
        if (light == true){
            return false;

        }
        return false;
    }

    public void leave(){
        if (!queue.isEmpty()){
            queue.removeFirst();
        }
    }

    public double getLength(){
        double sum = 0;
        for (Vehicle v : queue) {
            sum += v.getLength();
        }
        return sum;
    }


    public int getSize(){
        return queue.size();

    }

    @Override
    public void update(Observable o, Object arg) {
        int currentTime = (int) arg;
        greenLight = currentTime % (2*trafficLightRate) >= trafficLightRate;
        if (currentTime == 1) {
            entryTimer = 1;
        }

        for (int i = 0; i < Math.floor(entryTimer / entryDelay);i++){
            enter();
        }
        for  (int i = 0; i < Math.floor(exitTimer / exitDelay);i++) {
            leave();
        }
        entryTimer = exitTimer % exitDelay;
        exitTimer = exitTimer % exitDelay;
        entryTimer++;
        if (greenLight){
            exitTimer++;
        }else {
            exitTimer = 0;
        }
    }
}


