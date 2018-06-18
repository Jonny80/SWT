public abstract class ProjectItem {
    private String name;
    private String details;
    private double rate;

    public ProjectItem(String name, String details, double rate) {
        this.name = name;
        this.details = details;
        this.rate = rate;
        if (name == null || details==null){
            throw new NullPointerException();
        }
        if (name.isEmpty() || details.isEmpty()||rate < 0){
            throw new IllegalArgumentException();
        }
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public abstract double getTimeRequired();

    public abstract long getMaterialCost();

    public long getCostEstimate(){
        double cost = getMaterialCost()+rate*getTimeRequired();
        return Math.round(cost);
    }

    public double getRate() {
        return rate;
    }
}
