/**
 * Created by jonny on 14.06.17.
 */
/////FERTIG///////
public class JTopic extends JContent {
    private int id;

    JTopic(String title,String description,int id){
        super(title,description);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Topic: "+ getTitle() +"\n" + getDescription();
    }
    public int getId(){
        return id;
    }
}
