import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonny on 10.06.17.
 */
public class PayrollDispositionImpl implements PayrollDisposition {
    private Map<Employee,Double> payments;
    public int size;

    PayrollDispositionImpl(){
        this.payments = new HashMap<Employee,Double>();
    }


    public double getTotal(){
        double total = 0;
        for (double f : payments.values()){
            total +=f;
        }
        return total;
    }

    public double getAverage(){
        if (size == 0){
            return 0.0;
        }else {
        return getTotal()/size;
        }
    }

    public Map<Employee,Double> getPayments(){
        if (payments == null){
            System.out.println("nein");
        }
        return payments;
    }


    @Override
    public void sendPayment(Employee empl, double payment) {
        if (payment <= 0){
            throw new IllegalArgumentException("");
        }else if(empl == null){
            throw new NullPointerException("");
        }
        try {
            payments.put(empl, payment);
            size = payments.size();
        }catch (Exception e){
            System.out.println("nein");
        }

    }
}
