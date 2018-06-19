public class PredicateStartsWith<T extends String>  implements Predicate<String> {
    @Override
    public boolean predicate(String element, String argument) {
        if (element == null){
            return false;
        }
        if (argument == null){
            return false;
        }
        if (element.startsWith(argument)){
            return true;
        }else {
            return false;
        }
    }
}
