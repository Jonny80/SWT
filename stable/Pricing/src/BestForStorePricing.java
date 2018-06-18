import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jonny on 12.06.17.
 */
public class BestForStorePricing extends ComplexPricing {
    LinkedList<ISalePricing> liste = new LinkedList<ISalePricing>();

    private ISalePricing pricing;

    public BestForStorePricing(ISalePricing pricing) {
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
        long highest = 0;
        Iterator<ISalePricing> iterator = liste.iterator();
        if (sale == null) {
            throw new NullPointerException("");
        }
        while (iterator.hasNext()){
            ISalePricing isale = iterator.next();
            if (highest < isale.getTotal(sale)){
                highest = isale.getTotal(sale);
            }
        }
        return highest;
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
