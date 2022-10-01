package core.data;

import lombok.Getter;

public class ExperimentResults 
{
    @Getter
    private Runtime[] runtimes;
    @Getter
    private AverageRuntime[] averages;
    
    private int currentRuntime = 0;
    private int currentAverage = 0;

    private int iterRuntime = 0;
    private int iterAverage = 0;
    
    @Getter
    private final int TOTAL_SAMPLE_SIZE;
    @Getter
    private final int SAMPLE_SIZE;
    @Getter
    private final int MAX_INPUT;

    public ExperimentResults(int sampleSize, int maxInput) 
    {
        SAMPLE_SIZE = sampleSize;
        MAX_INPUT = maxInput;
        TOTAL_SAMPLE_SIZE = SAMPLE_SIZE * MAX_INPUT;

        runtimes = new Runtime[TOTAL_SAMPLE_SIZE];
        averages = new AverageRuntime[MAX_INPUT];
    }

    public void add(int sampleNum, int inputSize, float runtime) 
    {
        Runtime temp = new Runtime(sampleNum, inputSize, runtime);
        runtimes[currentRuntime] = temp;
        currentRuntime++;
    }

    public boolean hasNextRuntime()
    {
        return iterRuntime < TOTAL_SAMPLE_SIZE;
    }

    public Runtime nextRuntime()
    {
        Runtime runtime = runtimes[iterRuntime];
        iterRuntime++;

        return runtime;
    }

    public boolean hasNextAverage()
    {
        return iterAverage < MAX_INPUT;
    }

    public AverageRuntime nextAverage()
    {
        AverageRuntime average = averages[iterAverage];
        iterAverage++;

        return average;
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
