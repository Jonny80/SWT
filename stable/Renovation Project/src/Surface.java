import java.io.IOException;
import java.util.Map;

/**
 * Created by jonny on 05.06.17.
 */
public class Surface extends RenovationObject {
    private double lenght;
    private double width;
    public int price;
    public String name;
    public double width2;
    private Material selectedMaterial;

    public Surface(double lenght, double width) {
        if (lenght <= 0) {
            throw new IllegalArgumentException("Be positive!");
        } else {
            this.lenght = lenght;

        }
        if (width <= 0) {
            throw new IllegalArgumentException("sup");
        } else {
            this.width = width;
        }
    }

    public double getLenght() {
        return lenght;
    }

    public double getWidth() {
        return width;
    }


    public void setMaterial(Material m) {
        selectedMaterial = m;
        name = m.getName();
        width2 = m.getMaterialReq(this);
        price = (int) m.getPriceOfASurface(this);
    }


    public double getArea() {
        return lenght * width;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Map<String, Integer> addMaterialReq(Map<String, Integer> materials) {

        System.out.println(materials);
        if (materials == null || selectedMaterial == null){
            throw new NullPointerException("meh");
        }
        try {
            if (materials.isEmpty()){
                materials.put(name, (int) width2);

            }else {
                System.out.println(materials);
                materials.put(selectedMaterial.getName(), (int) width2+materials.get(name));
            }
        }catch (Exception e){
            throw new NullPointerException("mehg");

        }
        return materials;

    }
}
