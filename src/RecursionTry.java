/**
 * Created by admin on 2/14/17.
 */
public class RecursionTry {
    public int recursionRun(int result) {
        result = 1 + result;

        if (result < 100) {
            result = recursionRun(result);
        }
        return result;
    }
}
