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
        System.out.println("devide results is = " + devide(input).get("a") + "; b = " + devide(input).get("b") + ";");
    }

    // Simple solution for algorithm
    public int calculateThisShit(Map<String, Integer> numbers){
        // Define the length of integer
        Integer n = (String.valueOf(numbers.get("a"))+String.valueOf(numbers.get("b"))).length();

        // Get sum to define length of Integer
        Integer abSum = numbers.get("a") + numbers.get("b");
        Integer cdSum = numbers.get("c") + numbers.get("d");

        // Call recursion or not
        Integer a_plus_b_multiply_c_plus_d;
        if(String.valueOf(abSum).length() > 2 || String.valueOf(cdSum).length() > 2) {
            // TODO call recursion in right way !!!
            // a_plus_b_multiply_c_plus_d = calculateThisShit();
        } else{
            a_plus_b_multiply_c_plus_d = abSum * cdSum;
        }

        // Simple multiply
        Integer ac = numbers.get("a") * numbers.get("c");
        Integer bd = numbers.get("b") * numbers.get("d");

        // Karacuba method
        Double result = Math.pow(10, n) * ac + Math.pow(10, n/2) * Math.abs(a_plus_b_multiply_c_plus_d - ac - bd) + bd;

        return result.intValue();
    }


    public Map<String, Integer> devide(int newInteger){
        Map<String, Integer> newIntegers = new HashMap<>();
        String value = String.valueOf(newInteger);
        int length = value.length();

        if((length % 2) == 0) {

            String firstPart = value.substring(0, length/2);
            String secondPart = value.substring(length/2, length);

            newIntegers.put("a", Integer.valueOf(firstPart));
            newIntegers.put("b", Integer.valueOf(secondPart));

        } else if(length == 1) {

            newIntegers.put("a", Integer.valueOf(value));
            newIntegers.put("b", Integer.valueOf("0"));

        } else {
            int rightLength = length - (length % 2);

            String firstPart = value.substring(0, rightLength/2);
            String secondPart = value.substring(rightLength/2, length);

            newIntegers.put("a", Integer.valueOf(firstPart));
            newIntegers.put("b", Integer.valueOf(secondPart));

        }

        return newIntegers;
    }
}