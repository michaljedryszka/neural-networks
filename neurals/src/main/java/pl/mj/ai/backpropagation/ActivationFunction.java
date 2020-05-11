package pl.mj.ai.backpropagation;

public class ActivationFunction {

    public float sigmoid(float x) {
        return (float) (1 / (x + Math.exp(-x)));
    }

    public float dSigmoid(float x) {
        return x * (1 - x);
    }
}
