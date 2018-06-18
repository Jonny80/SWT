import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jonny on 12.06.17.
 */
public class BestForCustomerPricing extends ComplexPricing {
    LinkedList<ISalePricing> liste = new LinkedList<ISalePricing>();

    private ISalePricing pricing;

    public BestForCustomerPricing(ISalePricing pricing) {
        if (pricing == null){
            throw new NullPointerException("");
        }
        System.out.println(liste);
        add(pricing);
        this.pricing = pricing;
        System.out.println(liste);


    }

    @Override
    public long getTotal(Sale sale) {
        long lowest = pricing.getTotal(sale);
        Iterator<ISalePricing> iterator = liste.iterator();
        if (sale == null) {
            throw new NullPointerException("");
        }
        while (iterator.hasNext()){
            ISalePricing isale = iterator.next();
            if (lowest > isale.getTotal(sale)){
                lowest = isale.getTotal(sale);
            }
        }
        return lowest;
    }

    @Override
    public void add(ISalePricing pricing) {
        liste.add(pricing);
        //System.out.println(liste);

    }

    @Override
    public LinkedList<ISalePricing> getPricings() {
        return liste;
    }
}
