	/**
 * Created by jonny on 05.06.17.
 */
public class Flooring extends Material {
    private static double limit = 0.02;
    double widthOfFlooring;

    public Flooring(String name, double price, double widthOfFlooring) {
        super(name, price);
        if (widthOfFlooring <= 0) {
            throw new IllegalArgumentException("Heal pls");
        } else {
            this.widthOfFlooring = widthOfFlooring;
        }
    }

    public double getWidth() {
        return widthOfFlooring;
    }


    @Override
    public int getMaterialReq(Surface s) {
        if (s == null) {
            throw new NullPointerException("mid or feed");
        }
        double erg = (s.getArea()/widthOfFlooring);
        if ((Math.round(100.0 * (erg - (int) erg)) / 100.0) >= limit){
            erg++;
            return (int) erg;
        }else {
            return (int) erg;
        }
    }
}
