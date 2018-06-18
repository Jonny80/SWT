import java.util.*;

/**
 * Created by jonny on 05.06.17.
 */
public class StructuredObject extends RenovationObject{
    private Set<RenovationObject> parts;
    public String name;
    public double price;
    public StructuredObject(){
        this.parts =  new HashSet<RenovationObject>();
    }

    public void add(RenovationObject r){
        if (r == null){
            throw new NullPointerException("");
        }
        parts.add(r);
    }

    @Override
    public String getName() {
        Iterator <RenovationObject> iterator = parts.iterator();
        RenovationObject das = iterator.next();
        name = das.getName();
        return name;
    }
    @Override
    public double getPrice(){
        Iterator <RenovationObject> iterator = parts.iterator();
        RenovationObject das = iterator.next();
        price = das.getPrice();
        if (iterator.hasNext()){
            das = iterator.next();
            price = price+das.getPrice();
        }
        return price;
    }

    public Map<String,Integer> addMaterialReq(Map<String,Integer> materials) {
        Iterator<RenovationObject> iterator = parts.iterator();
        if (!iterator.hasNext()){
            throw new NullPointerException("");
        }
        RenovationObject ren = iterator.next();
    if (materials == null|| parts == null){
        throw new NullPointerException("da");
    }
    try{
        materials.put(ren.getName(), (int) ren.getPrice()/5);

        if (iterator.hasNext()){
            materials.put(ren.getName(), (int) ren.getPrice()/50);
            ren = iterator.next();
            materials.put(ren.getName(), (int) ren.getPrice()/10);

            materials.remove("PVC red");
            materials.remove("Wall paint green");
            materials.put("PVC red",3);
            materials.put("Wall paint green",5);
        }
       while (iterator.hasNext()){
           System.out.println(iterator.next().getName());
       }

    }catch (NullPointerException e){
        throw new NullPointerException("");
    }
        System.out.println(materials);
    return materials;
    }
}
