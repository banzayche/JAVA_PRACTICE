import java.math.*;

/**
 * Created by admin on 2/13/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n Try Collections:");
        TryKaracubaMethod newTryKaracubaMethod = new TryKaracubaMethod();

//        newTryKaracubaMethod.calculateThisShit(2242, 5624);
//        System.out.println("RESULT = " + newTryKaracubaMethod.calculateThisShit(1234, 5678));
        BigDecimal value1 = new BigDecimal("1685287499328328297814655639278583667919355849391453456921116729");
        BigDecimal value2 = new BigDecimal("7114192848577754587969744626558571536728983167954552999895348492");
        newTryKaracubaMethod.calculateThisShit(value1, value2);
//        System.out.println(newTryKaracubaMethod.devide(value1, value2));
    }
}
