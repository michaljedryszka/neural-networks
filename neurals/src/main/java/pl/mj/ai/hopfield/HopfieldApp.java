package pl.mj.ai.hopfield;

public class HopfieldApp {
    public static void main(String[] args) {
        HopfieldNetwork hn = new HopfieldNetwork(4);

        hn.train(new double[]{0, 1, 0, 1});
        hn.train(new double[]{1, 0, 0, 1});

        hn.recall(new double[]{0, 1, 0, 1});
        hn.recall(new double[]{1, 0, 0, 1});
        hn.recall(new double[]{1, 0, 1, 0}); //reversed line 10
        hn.recall(new double[]{1, 1, 0, 1});
    }
}
