package fi.arcada.codechallenge;

public class movingAvg {
    public static double[] calculateSMA(double[] values, int windowSize) {

        if (values == null || values.length < windowSize) {
            throw new IllegalArgumentException("Datamängden måste ha minst " + windowSize + " värden.");
        }

        double[] sma = new double[values.length - windowSize + 1];

        for (int i = 0; i <= values.length - windowSize; i++) {
            double sum = 0.0;
            for (int j = 0; j < windowSize; j++) {
                sum += values[i + j];
            }
            sma[i] = sum / windowSize;
        }

        return sma;
    }
}
