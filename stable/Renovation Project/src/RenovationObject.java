import java.util.Map;
/**
 * Created by jonny on 05.06.17.
 */
abstract class RenovationObject {
    abstract public String getName();
    abstract public double getPrice();

    abstract public Map<String, Integer> addMaterialReq(Map<String, Integer> materials);

}
