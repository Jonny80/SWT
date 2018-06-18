import java.io.File;

/**
 * Created by jonny on 14.06.17.
 */

////////FERTIG//////////
public class JAttachment extends JContent{
    private File file;

    JAttachment(String title, String description,File file) {
        super(title, description);
        if (file == null){
            throw new NullPointerException("");
        }
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        if (file == null){
            throw new NullPointerException("");
        }
        this.file = file;
    }

    @Override
    public String toString() {
        return "Attachment: "+ getTitle() +"\n" + getDescription();
    }
}
