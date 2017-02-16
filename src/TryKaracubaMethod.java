import java.util.*;
import java.math.*;

/**
 * Created by serhiiprokopchuk on 2/13/17.
 */

//Нижче наводяться приклади вхідних та вихідних даних для практичного завдання №1.
//
//        Опис даних:
//        X - перший доданок
//        Y - другий доданок
//        Z - добуток XY
//
//        Після "Value counter" йдуть рядки "p -> [k1,k2,k3]", де:
//        p - деякий коефіцієнт (ad+bc), який було отримано протягом
//        роботи алгоритму
//        [k1,k2,k3] - скільки разів таке значення p коефіцієнту (ad+bc) зустрілось
//        під час роботи алгоритму. Значень наводиться декілька, адже
//        при різних реалізація алгоритму (з вирівнюванням чи ні), можна
//        отримати різну кількість.
//
//        - Число k1 відповідає методу з вирінюванням всіх чисел в процесі роботи алгоритму
//        по ступенях двійки.
//        - Число k2 відповідає методу з вирінюванням всіх чисел в процесі роботи алгоритму,
//        щоб вони були кратні 2.
//        - Число k3 відповідає методу без вирівнювання.
//
//        Наприклад, в першому прикладі значення коефіцієнту (ad+bc) = 8 зустрілось 5 разів,
//        а (ad+bc) = 7 - 4 рази для методу з вирівнюванням за ступенями 2 та 4 і 2 рази
//        відповідно для методу з вирівнюванням кратним 2.

public class TryKaracubaMethod {
    public void getResult(int input){
//        Map<String, Integer> notUniqueIntegers = new HashMap<>();
//        int product = 0;
//        notUniqueIntegers.put("product", product);
//
//        return notUniqueIntegers;
//        System.out.println("devide results is = " + devide(input).get("a") + "; b = " + devide(input).get("b") + ";");
    }

    // Simple solution for algorithm
    public BigDecimal calculateThisShit(BigDecimal numberOne, BigDecimal numberTwo){
        // Devide numbers a, b, c, d.
        Map<String, String> numbers = devide(numberOne, numberTwo);
        System.out.println("numbers(devided) = " + numbers);

        // return result.intValue();
        BigDecimal a = new BigDecimal(numbers.get("a"));
        BigDecimal b = new BigDecimal(numbers.get("b"));
        BigDecimal c = new BigDecimal(numbers.get("c"));
        BigDecimal d = new BigDecimal(numbers.get("d"));

        // Get sum to define length of Integer
        BigDecimal abSum = a.add(b);
        BigDecimal cdSum = c.add(d);

        BigDecimal abcd;
        // Call recursion or not
        if(String.valueOf(abSum).length() > 1 || String.valueOf(cdSum).length() > 1) {
            abcd = calculateThisShit( abSum, cdSum);
        } else{
            abcd = abSum.multiply(cdSum);
        }


        // Simple multiply
        BigDecimal ac = a.multiply(c);
        BigDecimal bd = b.multiply(d);

        // Karacuba method
        int n = (numbers.get("a") + numbers.get("b")).length();

        BigDecimal firstLog = new BigDecimal(String.valueOf(Math.pow(10, n)));
        BigDecimal secondLog = new BigDecimal(String.valueOf(Math.pow(10, n/2)));

        BigDecimal result = firstLog.multiply(ac).add(secondLog.multiply(abcd.subtract(ac).subtract(bd).abs()).add(bd));
        System.out.println("\n Results");
        System.out.println("Show The n = " + n);
        System.out.println("Show The Result = " + result);
        return result;
    }


    public Map<String, String> devide(BigDecimal newIntegerOne, BigDecimal newIntegerTwo){
        System.out.println("\n DEVIDE");
        System.out.println("newIntegerOne = " + newIntegerOne);
        System.out.println("newIntegerTwo = " + newIntegerTwo);

        String smalSizeInt   = String.valueOf(newIntegerOne.compareTo(newIntegerTwo) == 1 ? newIntegerTwo : newIntegerOne);
        String normalSizeInt = String.valueOf(newIntegerOne.compareTo(newIntegerTwo) == 1 ? newIntegerOne : newIntegerTwo);

        while (smalSizeInt.length() != normalSizeInt.length()) {
            smalSizeInt = "0" + smalSizeInt;
        }
        System.out.println("\n RESULT AFTER FIRST UPDATING");
        System.out.println("smalSizeInt = " + smalSizeInt);
        System.out.println("normalSizeInt = " + normalSizeInt);

        if(smalSizeInt.length() % 2 != 0) {
            while (smalSizeInt.length() % 2 != 0) {
                smalSizeInt = "0" + smalSizeInt;
                normalSizeInt = "0" + normalSizeInt;
            }
        }
        System.out.println("\n RESULT AFTER SECOND UPDATING");
        System.out.println("smalSizeInt = " + smalSizeInt);
        System.out.println("normalSizeInt = " + normalSizeInt);

        Map<String, String> newIntegers = new HashMap<>();
        int length = normalSizeInt.length();

        String a = smalSizeInt.substring(0, length/2);
        String b = smalSizeInt.substring(length/2, length);
        System.out.println("firstPart = " + a);
        System.out.println("secondPart = " + b);

        String c = normalSizeInt.substring(0, length/2);
        String d = normalSizeInt.substring(length/2, length);
        System.out.println("thirdPart = " + c);
        System.out.println("fourthPart = " + d);

        newIntegers.put("a", a);
        newIntegers.put("b", b);
        newIntegers.put("c", c);
        newIntegers.put("d", d);

        return newIntegers;
    }
}