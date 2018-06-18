/**
 * Created by jonny on 13.06.17.
 */
public abstract class Part {
    private String id;
    private String name;

    Part(String id, String name){
        if (id == null || name == null){
            throw new NullPointerException("");
        }
        if (id.isEmpty() || name.isEmpty()){
            throw new IllegalArgumentException("");
        }

        this.id = id;
        this.name = name;
    }

    public  String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
