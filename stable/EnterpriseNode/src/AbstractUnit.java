import java.util.LinkedList;
import java.util.List;

public abstract class AbstractUnit extends AbstractEnterpriseUnit {
    private List<AbstractEnterpriseUnit> childNodes;

    public AbstractUnit(String name) {

        super(name);
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (name == null){
            throw new NullPointerException();
        }
        childNodes = new LinkedList<>();
    }

    public boolean add(AbstractEnterpriseUnit childnode){
        if (childnode == null){
            throw new NullPointerException();
        }
        if (childNodes.contains(childnode)){
            return false;
        }
        childNodes.add(childnode);
        return true;
    }
    public boolean remove(AbstractEnterpriseUnit childnode){
        if (childnode == null){
            throw new NullPointerException();
        }
        if (!childNodes.contains(childnode)){
            return false;
        }
        childNodes.remove(childnode);
        return true;
    }

    public List<AbstractEnterpriseUnit> getChildNodes() {
        return childNodes;
    }
}
