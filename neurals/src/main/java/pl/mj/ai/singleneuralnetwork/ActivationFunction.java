package pl.mj.ai.singleneuralnetwork;

public class ActivationFunction implements pl.mj.ai.ActivationFunction<Float> {

    @Override
    public int stepFunction(Float activation) {
        if (activation >= 1) {
            return 1;
        }
        return 0;
    }
}
