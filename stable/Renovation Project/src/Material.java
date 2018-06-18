/**
 * Created by jonny on 05.06.17.
 */

//Fresh
public class Material {
    private String name;
    private double price;
    public double area;


    public Material(String name, double price){
        if (name == null){
            throw new NullPointerException("whatever");

        }else if (name == ""){
            throw new IllegalArgumentException("Fill se string ffs");
        }
        else {
            this.name = name;
        }
        if (price < 0){
            throw new IllegalArgumentException("must be positive");
        }else {
            this.price = price;
        }
    }

    public String getName(){
        return name;
    }

    public double getPricePerUnit(){
        return price;
    }


    public int getMaterialReq(Surface s){
        return (int) s.getArea();
    }
    public double getPriceOfASurface(Surface s){
        double priceofSurface = getPricePerUnit()*getMaterialReq(s);
        if (s == null){
            throw new NullPointerException("nerf reaper");
        }else{
        return priceofSurface;
        }
    }
}
