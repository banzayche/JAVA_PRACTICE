/**
 * Created by admin on 2/14/17.
 */
public class RecursiveTest {
    public int recursiveRun(int result) {
        result = 1 + result;

        if (result < 100) {
            result = recursiveRun(result);
        } else{
            result = result - 5;
        }
        return result;
    }
}
