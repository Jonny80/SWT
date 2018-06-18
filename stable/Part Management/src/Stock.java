import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonny on 13.06.17.
 */
public class Stock {

    public Map<Part,Integer> inventar;
    private Observation observer;

    Stock(){
        inventar = new HashMap<Part,Integer>();
        this.observer = new Observation() {
            @Override
            public void alarm(Part part) {

            }
        };
    }

    public int get(Part part) {
        if (part == null){
            throw new NullPointerException("");
        }
        if (!inventar.containsKey(part)){
            return -1;
        }else {
            return inventar.get(part);
        }
    }

    public boolean set(Part part, int count) {
        if (part == null){
            throw new NullPointerException("");
        }
        if (count < 0){
            return false;
        }
        if (!inventar.containsKey(part)){
            return false;
        }
        inventar.replace(part,count);
        notify(part);
        if (inventar.get(part) == count){
            return true;
        }else {
            return true;

        }

    }

    public void insert(Part part, int count) {
        if (part == null){
            throw new NullPointerException("");
        }
        if (count < 1){
            throw new IllegalArgumentException("");
        }
        if (!inventar.containsKey(part)){
            inventar.put(part,count);
        }else {
            inventar.replace(part,inventar.get(part)+count);
            notify(part);
        }


    }

    public boolean delete(Part part, int count) {
        if (part == null){
            throw new NullPointerException("");
        }
        if (!inventar.containsKey(part)){
            return false;
        }
        if (count < 0 || count > inventar.get(part)){
            return false;
        }

        inventar.replace(part,inventar.get(part)- count);
        notify(part);
        if (inventar.containsValue(inventar.get(part))){
            return true;
        }else {
            return false;
        }



    }

    public void register(Observation observer) {
        this.observer = observer;
    }

    public void notify(Part part) {
        observer.alarm(part);
    }
}
