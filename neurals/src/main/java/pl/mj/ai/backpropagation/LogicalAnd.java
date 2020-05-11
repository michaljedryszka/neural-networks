package pl.mj.ai.backpropagation;

public class LogicalAnd {

    public static void main(String[] args) {
        float trainingData[][] = new float[][]{
                new float[]{0, 0},
                new float[]{0, 1},
                new float[]{1, 0},
                new float[]{1, 1}
        };

        float trainingResult[][] = new float[][]{
                new float[]{0},
                new float[]{0},
                new float[]{0},
                new float[]{1}
        };

        Network network = new Network(2, 3, 1);
        for (int iteration = 0; iteration < Config.ITERATIONS; iteration++) {
            for (int i = 0; i < trainingResult.length; i++) {
                network.train(trainingData[i], trainingResult[i], Config.LEARNING_RATE, Config.MOMENTUM);
            }
            System.out.println();
            for (int i = 0; i < trainingResult.length; i++) {
                float[] row = trainingData[i];
                System.out.println("Num of iterations: " + iteration);
                System.out.println(String.format("%.1f, %.1f --> %.3f", row[0], row[1], network.run(row)[0]));
            }
        }
    }
}
