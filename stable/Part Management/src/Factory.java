/**
 * Created by jonny on 13.06.17.
 */
public class Factory {
    private ReceivingStock stock;
    private Purchasing purchasing;

    Factory(Purchasing purchasing,ReceivingStock stock ){
        if (purchasing == null|| stock == null){
            throw new NullPointerException("");
        }

        this.stock = stock;
        this.purchasing = purchasing;
    }

    public ReceivingStock getStock() {
        return stock;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public static Part create(PartType partType, String id,String name){
        if (partType == null){
            throw new NullPointerException("");
        }
        if (partType.equals(PartType.COMPONENTS)){
            return new Components(id,name);
        }else if (partType.equals(PartType.RESOURCE)){
            return new Resource(id,name);
        }else {
            return new SingleComponent(id, name);
        }
    }
}