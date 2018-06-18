package java.util;

/**
 * Created by jonny on 12.06.17.
 */
public interface Observer {
    void update(Observable o, Object arg);
}
