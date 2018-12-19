package hopfield;

/**
 * @author Michal.Jedryszka on 12/19/2018
 */
public class ActivationFunction {
    public static int stepFunction(double x) {
        if (x >= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
