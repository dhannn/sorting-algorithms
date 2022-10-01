package core.data;

public record AverageRuntime(int inputSize, float averageRuntime) {
    @Override
    public String toString()
    {
        String runtimeString = String.format(
            "%d,%.6f", inputSize, averageRuntime);
        return runtimeString;
    }
}
