/**
 * Created by jonny on 10.06.17.
 */
public class Appointee extends Employee {
    private int hoursPerMonth;
    private int dayOfMonth;
    private double payPerHour;




    public Appointee(String id, int dayOfMonth, int hoursPerMonth, double payPerHour) {
        super(id);
        if (payPerHour <= 0){
            throw new IllegalArgumentException("");
        }else {
        this.payPerHour = payPerHour;
        }
        if (hoursPerMonth <= 0){
            throw new IllegalArgumentException("");
        }else {
            this.hoursPerMonth = hoursPerMonth;
        }if (dayOfMonth <= 0|| dayOfMonth >31){
            throw new IllegalArgumentException("");
        }else {
            this.dayOfMonth = dayOfMonth;
        }
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if (this.dayOfMonth == dayOfMonth){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        return (hoursPerMonth*payPerHour);
    }

    @Override
    public double calculateDeductions() {
        return (hoursPerMonth*payPerHour)*0.4;
    }
}
