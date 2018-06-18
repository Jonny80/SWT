import java.util.Calendar;

public class Deliverable extends ProjectItem {


    private long materialCost;
    private double productionTime;
    private Calendar date;

    public Deliverable(String name, String details, double rate, long materialCost, double productionTime, Calendar date) {
        super(name, details, rate);
        this.materialCost = materialCost;
        this.productionTime = productionTime;
        this.date = date;
        if (date == null){
            throw new NullPointerException();
        }
        if (materialCost < 0 || productionTime <= 0||rate<0){
            throw new IllegalArgumentException();
        }
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public double getTimeRequired() {
        return productionTime;
    }

    @Override
    public long getMaterialCost() {
        return materialCost;
    }
}
