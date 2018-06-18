import java.util.LinkedList;
import java.util.List;

/**
 * Created by jonny on 14.06.17.
 */
public class JIdea extends JContent{
    private JState  state;
    private JAttachment attachment;
    public List<JAttachment> aList;

    JIdea(String title, String description) {
        super(title, description);
        aList =  new LinkedList<>();
    }

    public void discuss(String text){
        state.setCurrentDiscussion(text);
    }

    public void evaluate(JValuation valuation){
        state.evaluate(valuation);
    }

    public void  release(){
        isReleased();
    }

    public void decline(){
    }

    public void hold(){
    }

    public boolean isDeclined(){
        return false;
    }

    public boolean isReleased(){
        return true;
    }

    public String getCurrentDiscussion(){
        return state.getCurrentDiscussion();
    }

    public JValuation getValuation(){
        return state.getValuation();
    }

    public void addAttachment(JAttachment attachment){
        if (attachment == null){
            throw new NullPointerException("");
        }
        aList.add(attachment);
    }

    public List<JAttachment> getAttachments(){
        return aList;
    }

    public boolean removeAttachment(JAttachment attachment){
        if (attachment == null){
            throw new NullPointerException("");
        }
        if (aList.contains(attachment)){
            aList.remove(attachment);
            return true;
        }else {
            return false;
        }
    }

    public String toString(){
        return "Idea: "+ getTitle() +"\n" + getDescription();
    }
    abstract class JState {
        private String currentDiscussion;

        private JValuation valuation;

        public void discuss(String text){
            currentDiscussion = currentDiscussion + text;
        }

        public void evaluate(JValuation valuation){
            this.valuation = valuation;
        }

        public void hold() throws IllegalStateException{
            throw new IllegalStateException("");
        }

        public void release(){

        }

        public void decline(){
            throw new IllegalStateException("");

        }

        public String getCurrentDiscussion(){
            return currentDiscussion;
        }

        public void setCurrentDiscussion(String currentDiscussion){
            this.currentDiscussion = currentDiscussion;
        }

        public JValuation getValuation(){
            return valuation;
        }

        public void setValuation(JValuation valuation){
            this.valuation = valuation;
        }
    }


    class Draft extends JState{
        public void hold(){

        }

        public void decline(){

        }
    }

    class ReleasedIdea extends JState{
        public void hold() throws IllegalStateException {
            IllegalStateException e = new IllegalStateException("");
            throw e;
        }

    }
    class DeclinedIdea extends JState{
        public void discuss(String text) {
            throw new IllegalArgumentException("");
        }

        public void evaluate(JValuation valuation) {
            throw new IllegalStateException("");
        }

        public void hold() {
            throw new IllegalStateException("");
        }

        public void release() {
            throw new IllegalStateException("");
        }

        public void decline() {
            throw new IllegalStateException("");
        }

    }

    class OpenDraft extends JState{
        public void discuss(String text){

        }

        public void evaluate(JValuation valuation){

        }

        public void hold(){

        }

        public void decline(){

        }
    }

    public class ApprovedIdea extends JState{
        public void release(){
            throw new IllegalStateException("");

        }
    }





}
