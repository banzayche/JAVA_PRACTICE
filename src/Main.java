import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2/13/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n Try Collections:");
        Map<String, String> newIntegers = new HashMap<>();
        TryKaracubaMethod newTryKaracubaMethod = new TryKaracubaMethod();
        newIntegers.put("a", "1");
        newIntegers.put("b", "2");
        newIntegers.put("c", "3");
        newIntegers.put("d", "4");
//
        System.out.println(newTryKaracubaMethod.calculateThisShit(newIntegers));
//        System.out.println(newTryKaracubaMethod.devide(15223));
    }
}
