package hopfield;

/**
 * @author Michal.Jedryszka on 12/19/2018
 */
public class Utils {

    public static double[] transform(double[] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == 0)
                pattern[i] = -1;
        }
        return pattern;
    }
}
