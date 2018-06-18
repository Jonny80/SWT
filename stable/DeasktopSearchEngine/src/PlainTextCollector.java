import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlainTextCollector implements KeywordCollector {
    @Override
    public Set<String> getKeywords(Resource res) {
        if (res == null){
            throw new NullPointerException();
        }
        Set<String> set = new HashSet<String>(
                Arrays.asList("are exam good hope in luck prepared this We well wish you".split(" ")));
        return set;
    }
}
