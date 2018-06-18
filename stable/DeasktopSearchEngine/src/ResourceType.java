public class ResourceType {
    private String description;
    private KeywordCollector collector;


    public ResourceType(String description, KeywordCollector collector) {
        if (description.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (description == null|| collector == null){
            throw new NullPointerException();
        }
        this.description = description;
        this.collector = collector;

    }

    public String getDescription() {
        return description;
    }
    public KeywordCollector getCollector() {
        return collector;
    }

}
