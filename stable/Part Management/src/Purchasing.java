/**
 * Created by jonny on 13.06.17.
 */
public class Purchasing implements Observation {
    private ReceivingStock stock;

    Purchasing(ReceivingStock receivingStock){
        if (receivingStock == null){
            throw new NullPointerException("");
        }
        this.stock = receivingStock;
    }
    @Override
    public void alarm(Part part) {
        if (stock.inventar.get(part) < stock.getMinStockItems()){
            getStock().inventar.replace(part,stock.getMaxStockItems());
        }
    }

    public void buy(Part part,int count){
        if (part == null){
            throw new NullPointerException("");
        }
        if (count <= 0){
            throw new IllegalArgumentException("");
        }
        stock.insert(part,count);
    }
    public ReceivingStock getStock(){
        return stock;
    }
}
