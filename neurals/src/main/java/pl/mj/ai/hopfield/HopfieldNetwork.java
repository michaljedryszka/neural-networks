package pl.mj.ai.hopfield;

public class HopfieldNetwork {
    private double[][] weightMatrix;

    public HopfieldNetwork(int dimension) {
        this.weightMatrix = new double[dimension][dimension];
    }

    public void train(double[] pattern) {
        double[] patternBipolar = Utils.transform(pattern);
        double[][] patternMatrix = Matrix.createMatrix(patternBipolar.length, patternBipolar.length);
        patternMatrix = Matrix.outerProduct(patternBipolar);
        patternMatrix = Matrix.clearDiagonals(patternMatrix);
        weightMatrix = Matrix.addMAtrixs(this.weightMatrix, patternMatrix);
    }

    public void recall(double[] pattern) {
        double[] patternBipolar = Utils.transform(pattern);
        double[] multiResult = Matrix.metricsVectorMultiplication(weightMatrix, patternBipolar);
        for (int i = 0; i < patternBipolar.length; i++) {
            multiResult[i] = ActivationFunction.stepFunction(multiResult[i]);
        }
        for (int i = 0; i < patternBipolar.length; i++) {
            if (patternBipolar[i] != multiResult[i]) {
                System.out.println("Pattern not recognized....");
                return;
            }
        }
        System.out.println("Pattern is recognized");
    }
}
