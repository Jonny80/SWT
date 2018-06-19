import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class PredicateIterator<T extends String> implements Iterator<T> {
    private Predicate<String> predicate;
    private Iterator<T> iterator;
    private T argument;
    private List<T> liste;

    public PredicateIterator(Iterator<T> iterator, Predicate<String> predicate, T argument) {
        this.predicate = predicate;
        this.iterator = iterator;
        this.argument = argument;
        liste = new LinkedList<>();
        while(iterator.hasNext()){
            T t = iterator.next();
            if (predicate.predicate(t,argument)){
                liste.add(t);
            }
        }
        System.out.println(liste);
    }

    @Override
    public boolean hasNext() {
        if (liste.isEmpty()){
            return false;
        }else {
            return true;
        }
    }


    @Override
    public T next() {
        if (liste.isEmpty()){
            throw new NoSuchElementException();
        }else {
            T t = liste.get(0);
            liste.remove(0);
            return t;
        }
    }

}
