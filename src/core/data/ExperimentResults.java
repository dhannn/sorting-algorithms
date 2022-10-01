package core.data;

import lombok.Getter;

@Getter
public class ExperimentResults 
{
    private Runtime[] runtimes;
    private AverageRuntime[] averages;

    private int currentRuntime = 0;
    private int currentAverage = 0;

    private final int SAMPLE_SIZE;

    public ExperimentResults(int sampleSize) 
    {
        SAMPLE_SIZE = sampleSize;
        runtimes = new Runtime[sampleSize];
        averages = new AverageRuntime[sampleSize];
    }

    public void add(int sampleNum, int inputSize, float runtime) 
    {
        Runtime temp = new Runtime(sampleNum, inputSize, runtime);
        runtimes[currentRuntime] = temp;
        currentRuntime++;
    }

    public void calculateAverage()
    {
        int currentInputSize = this.runtimes[0].inputSize();
        float sum = 0;
        for(Runtime runtime: this.runtimes)
        {
            if(currentInputSize == runtime.inputSize())
            {
                sum += runtime.runtime();
            } else 
            {
                addAverage(currentInputSize, sum);
                
                currentInputSize = runtime.inputSize();
                sum = runtime.runtime();
            }
        }

        addAverage(currentInputSize, sum);
    }
    
    private void addAverage(int currentInputSize, float sum)
    {
        float average = sum / SAMPLE_SIZE;
        
        AverageRuntime temp = new AverageRuntime(currentInputSize, average);
        this.averages[currentAverage] = temp;

        currentAverage++;
    }
}
