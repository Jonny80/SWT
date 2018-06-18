/**
 * Created by jonny on 14.06.17.
 */

////FERTIG///////
public class JValuation  extends JContent{
    JValuation(String title, String description) {
        super(title, description);
    }

    @Override
    public String toString() {
        return "Valuation: "+ getTitle() +"\n" + getDescription();
    }
}
