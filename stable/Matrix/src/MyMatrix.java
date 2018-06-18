import java.util.*;
import java.awt.Point;

public class MyMatrix<T> implements Matrix {
    private Map<Point,T> matrixEntries;

    public MyMatrix() {
        matrixEntries=new HashMap<Point, T>();
    }

    @Override
    public int getRowCount() {
        Set<Point> set = matrixEntries.keySet();
        List<Integer> list = new LinkedList<>();
        for (Point p : set){
            list.add(p.x);
        }
        if (list.isEmpty()){
            return 0;
        }
        int x = Collections.max(list);
        x++;
        return x;
    }

    @Override
    public int getColumnCount() {
        Set<Point> set = matrixEntries.keySet();
        List<Integer> list = new LinkedList<>();
        for (Point p : set){
            list.add(p.y);
        }
        if (list.isEmpty()){
            return 0;
        }
        int x = Collections.max(list);
        x++;
        return x;
    }

    @Override
    public int getObjectCount() {
        List<T> set = new LinkedList<>();
        for (Point p : matrixEntries.keySet()){
            set.add(matrixEntries.get(p));
        }
        return set.size();
    }

    @Override
    public int getDistinctObjectCount() {
        Set<T> set = new HashSet<>();
        for (Point p : matrixEntries.keySet()){
            set.add(matrixEntries.get(p));
        }
        return set.size();
    }

    @Override
    public Iterator iterator() {
        Iterator<T> iterator = new DepthFirstIterator();
        return iterator;
    }

    @Override
    public Object get(int row, int column) {
        Point p = new Point(row,column);
        int r = getRowCount()-1;
        int c = getColumnCount()-1;
        if (row > r || column > c){
            throw new IllegalArgumentException();
        }
        System.out.println(row+" "+column);
        System.out.println(getRowCount());
        System.out.println(matrixEntries);
        return matrixEntries.get(p);
    }


    @Override
    public Object put(int row, int column, Object value) {
        Point p = new Point(row,column);
        if (matrixEntries.containsKey(p)){
            T value2 = matrixEntries.get(p);
            matrixEntries.replace(p,(T)value);
            return value2;
        }
        matrixEntries.put(p,(T) value);
        return null;
    }

    @Override
    public boolean contains(Object value) {
        T t = (T) value;
        List<T> set = new LinkedList<>();
        for (Point p : matrixEntries.keySet()){
            set.add(matrixEntries.get(p));
        }
        if (set.contains(t)){
            return true;
        }else {
            return false;
        }
    }

    class DepthFirstIterator implements Iterator<T>{
        Iterator<T> iterator;
        public DepthFirstIterator() {
            List<T> list = new LinkedList<>();
            for (int i = 0; i < getRowCount();i++){
                for (int j=0;j<getColumnCount();j++){
                    Point p = new Point(j,i);
                    if (matrixEntries.containsKey(p)){
                        System.out.println(matrixEntries.get(p));
                        list.add(matrixEntries.get(p));
                    }
                }
            }
            System.out.println(list);
            iterator = list.iterator();

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
        public T next() {
            if (!iterator.hasNext()){
                throw new NoSuchElementException();
            }
           return iterator.next();
        }

        public void remove(){
            throw new UnsupportedOperationException();

        }
    }
}
