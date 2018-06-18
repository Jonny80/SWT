/**
 * Created by jonny on 05.06.17.
 */
public class Paint extends Material {


    private int noOfCoats;
    private double noOfSqMPerLiter;

    private static double limit = 0.02;

    public Paint(String name, double price,int noOfCoats,double noOfSqMPerLiter) {
        super(name,price);
        if (noOfCoats <= 0){
            throw new IllegalArgumentException("nope");
        }else {
            this.noOfCoats = noOfCoats;
        }
        if (noOfSqMPerLiter <= 0) {
            throw new IllegalArgumentException("nope");
        }else {
        this.noOfSqMPerLiter = noOfSqMPerLiter;
        }
    }

    public int getNoOfCoats() {
        return noOfCoats;
    }

    public double getNoOfSqMPerLiter() {
        return noOfSqMPerLiter;
    }

    @Override
    public int getMaterialReq(Surface s){
        if (s == null) {
            throw new NullPointerException("butWhy");
        }
        double erg = ((s.getArea()*noOfCoats)/noOfSqMPerLiter)*2;
        if ((Math.round(100.0 * (erg - (int) erg)) / 100.0) > limit){
            erg++;
            return (int) erg;
        }else {
            return (int) erg;
        }

    }
}
