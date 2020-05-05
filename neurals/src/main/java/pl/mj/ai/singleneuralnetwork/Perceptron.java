package pl.mj.ai.singleneuralnetwork;

public class Perceptron {

    private float[] weights;
    private float[][] input;
    private float[] output;
    private int numOfWeights;

    private ActivationFunction activationFunction = new ActivationFunction();

    public Perceptron(float[][] input, float[] output) {
        this.input = input;
        this.output = output;
        numOfWeights = input[0].length;
        weights = new float[numOfWeights];
        initializeWeight();
    }

    private void initializeWeight() {
        for (int i = 0; i < numOfWeights; i++) {
            weights[i] = 0;
        }
    }

    public void train(float learningRate) {
        float totalError = 1;
        while (totalError != 0) {
            totalError = 0;
            for (int i = 0; i < output.length; i++) {
                float calculatedOutput = calculateOutput(input[i]);
                float error = Math.abs(output[i] - calculatedOutput);
                totalError += error;
                for (int j = 0; j < numOfWeights; j++) {
                    weights[j] = weights[j] + learningRate * input[i][j] * error;
                    System.out.println("weight: " + weights[j]);
                }
            }
            System.out.println("Training network, error: " + totalError);
        }
    }

    public float calculateOutput(float[] input) {
        float sum = 0;
        for(int i =0; i < input.length; i++){
            sum += weights[i] * input[i];
        }
        return activationFunction.stepFunction(sum);
    }
}
