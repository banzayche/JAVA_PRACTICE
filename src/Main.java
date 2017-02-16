import java.math.BigDecimal;

/**
 * Created by admin on 2/13/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n Try Karacuba Method:");
        TryKaracubaMethod newTryKaracubaMethod = new TryKaracubaMethod();

        BigDecimal value1 = new BigDecimal("1685287499328328297814655639278583667919355849391453456921116729");
        BigDecimal value2 = new BigDecimal("7114192848577754587969744626558571536728983167954552999895348492");
        newTryKaracubaMethod.calculateThisShit(value1, value2);

        System.out.println("\n Try parse xml");
        HowToWorkWithParser newHowToWorkWithParser = new HowToWorkWithParser();
        newHowToWorkWithParser.parseXml();
    }
}
