import java.util.Random;

/**
 * Created by jonny on 11.06.17.
 */
public class VehicleGenerator {
    private Random randomGenerator;

    VehicleGenerator(){
        randomGenerator = new Random();

    }

    public  Vehicle createVehicle(){
        int i = randomGenerator.nextInt(3);

        if (i == 1){
            return new Bicycle();
        }if (i == 2){
            return new Bus();
        }else {
            return new Car();
        }
    }

}
