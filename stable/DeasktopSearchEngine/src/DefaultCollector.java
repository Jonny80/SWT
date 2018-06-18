import java.util.HashSet;
import java.util.Set;

public class DefaultCollector implements KeywordCollector {
    @Override
    public Set<String> getKeywords(Resource res) {
        if (res == null){
            throw new NullPointerException();

        }
        Set<String> set = new HashSet<>();
        set.add(res.getName());
        return set;
    }
}
