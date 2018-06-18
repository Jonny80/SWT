import java.util.*;

public class TextFileIterator implements Iterator{

    Resource res;
    String[] expected;
    Iterator<String> iterator;

    public TextFileIterator(Resource res) {
        if (res == null){
            throw new NullPointerException();
        }
        this.res = res;
        this.expected = "We wish you good luck in this exam We hope you are well prepared".split(" ");
        List<String> liste = new LinkedList<>();
        liste.addAll(Arrays.asList(expected));
        this.iterator = liste.iterator();
    }

    @Override
    public boolean hasNext() {
        if (iterator.hasNext()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object next() {
        if (!iterator.hasNext()){
            throw new NoSuchElementException();
        }
        return iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
