package pl.mj.ai.backpropagation;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.arraycopy;

public class Layer {

    private float[] output;
    private float[] input;
    private float[] weigths;//weigths could be two dimensional, instead we are using offset
    private float[] dWeigths;
    private Random random = new Random();
    private ActivationFunction activationFunction = new ActivationFunction();

    public Layer(int inputSize, int outputSize) {
        output = new float[outputSize];
        input = new float[inputSize + 1]; // +1 bias node (node connected to output, not input)
        weigths = new float[input.length * output.length];
        dWeigths = new float[weigths.length];
        initWeigths();
    }

    private void initWeigths() {
        for (int i = 0; i < weigths.length; i++) {
            weigths[i] = (random.nextFloat() - 0.5f) * 4f; //[-2,2] // somehow standard values
        }
    }

    public float[] run(float[] inputArray) {
        arraycopy(inputArray, 0, input, 0, inputArray.length);
        input[inputArray.length - 1] = 1; //bias node
        int offset = 0;
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < input.length; j++) {
                output[i] += weigths[offset + j] * input[j];
            }
            output[i] = activationFunction.sigmoid(output[i]);
            offset += input.length;
        }
        return Arrays.copyOf(output, output.length);
    }

    public float[] train(float[] error, float learningRate, float momentum) {
        int offset = 0;
        float[] nextError = new float[input.length];
        for (int i = 0; i < output.length; i++) {
            float delta = error[i] * activationFunction.dSigmoid(output[i]);
            for (int j = 0; j < input.length; j++) {
                int weightIndex = offset + j;
                nextError[j] = nextError[j] + weigths[weightIndex] * delta;

                float deltaWeight = input[j] * delta * learningRate;

                weigths[weightIndex] += dWeigths[weightIndex] * momentum + deltaWeight;
                dWeigths[weightIndex] = deltaWeight;
            }
            offset += input.length;
        }
        return nextError;
    }
}
