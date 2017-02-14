import java.util.*;
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
    public int calculateThisShit(int numberOne, int numberTwo){
//        // Devide numbers a, b, c, d.
        Map<String, String> numbers = devide(numberOne, numberTwo);
        System.out.println("numbers(devided) = " + numbers);

        // return result.intValue();
        int a = Integer.parseInt(numbers.get("a"));
        int b = Integer.parseInt(numbers.get("b"));
        int c = Integer.parseInt(numbers.get("c"));
        int d = Integer.parseInt(numbers.get("d"));

        // Get sum to define length of Integer
        int abSum = a + b;
        int cdSum = c + d;

        int abcd = 0;
        // Call recursion or not
        if(String.valueOf(abSum).length() > 1 || String.valueOf(cdSum).length() > 1) {
            abcd = calculateThisShit(abSum, cdSum);
        } else{
            abcd = abSum * cdSum;
        }


        // Simple multiply
        int ac = a * c;
        int bd = b * d;

        // Karacuba method
        int n = (numbers.get("a") + numbers.get("b")).length();
        // TODO n calculating problem
        Double result = Math.pow(10, n) * ac + Math.pow(10, n/2) * Math.abs(abcd - ac - bd) + bd;
        System.out.println("\n Results");
        System.out.println("Show The n = " + n);
        System.out.println("Show The Result = " + result);
        return result.intValue();
    }


    public Map<String, String> devide(int newIntegerOne, int newIntegerTwo){
        System.out.println("\n DEVIDE");
        Map<String, String> newIntegers = new HashMap<>();
        String value = String.valueOf(newIntegerOne)+String.valueOf(newIntegerTwo);

        if((value.length() % 4) != 0) {
            while (value.length() % 4 != 0) {
                value = "0" + value;
            }
        }
        int length = value.length();

        String generalFirstPart = value.substring(0, length/2);

        String firstPart = generalFirstPart.substring(0, generalFirstPart.length()/2);
        String secondPart = generalFirstPart.substring(generalFirstPart.length()/2, generalFirstPart.length());
        System.out.println("firstPart = " + firstPart);
        System.out.println("secondPart = " + secondPart);

        String generalSecondPart = value.substring(length/2, length);

        String thirdPart = generalSecondPart.substring(0, generalSecondPart.length()/2);
        String fourthPart = generalSecondPart.substring(generalSecondPart.length()/2, generalSecondPart.length());
        System.out.println("thirdPart = " + thirdPart);
        System.out.println("fourthPart = " + fourthPart);

        newIntegers.put("a", firstPart);
        newIntegers.put("b", secondPart);
        newIntegers.put("c", thirdPart);
        newIntegers.put("d", fourthPart);

        return newIntegers;
    }
}