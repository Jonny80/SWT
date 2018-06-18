/**
 * Created by jonny on 14.06.17.
 */
////////FERTIG//////////
public  abstract class JContent {
    private String title;
    private String description;

    JContent(String title, String description){
        if (title.isEmpty() || description.isEmpty()){
            throw new IllegalArgumentException("");
        }else
        if (title==null|| description == null ){
            throw new NullPointerException("");
        }else {
            this.description = description;
            this.title = title;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null){
            throw new NullPointerException("");
        }
        if (title.isEmpty()){
            throw new IllegalArgumentException("");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null){
            throw new NullPointerException("");
        }
        if (description.isEmpty()){
            throw new IllegalArgumentException("");
        }
        this.description = description;
    }

    public abstract String toString();
}
