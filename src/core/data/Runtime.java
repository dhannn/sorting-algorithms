package core.data;

public record Runtime(int sampleNum, int inputSize, float runtime) 
{
    @Override
    public String toString()
    {
        String runtimeString = String.format(
            "%d,%d,%.6f", sampleNum + 1, inputSize, runtime);
        return runtimeString;
    }
}
