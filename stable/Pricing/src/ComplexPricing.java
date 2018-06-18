import java.util.LinkedList;

/**
 * Created by jonny on 12.06.17.
 */
public abstract class ComplexPricing implements ISalePricing {
    private ISalePricing pricing;

    public abstract void add(ISalePricing pricing);
    public abstract LinkedList<ISalePricing> getPricings();
}
