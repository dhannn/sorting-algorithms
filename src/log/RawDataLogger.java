package log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import core.data.Experiment;
import core.sequence.SuffixArray;

public class RawDataLogger extends BasicLogger
{
    private String sortDir;
    private int currentSample = 0;

    public RawDataLogger(Experiment experiment)
    {
        this.experiment = experiment;
        this.results = experiment.getResults();
    }

    @Override
    public void print() throws IOException 
    {   
        for(SuffixArray suffixArray: experiment.getSuffixArrays())
        {
            writer = new FileWriter(getFilename());

            writer.append("Base Sequence: \n");
            writer.append(suffixArray.getBaseSequence().getSuffix(0) + "\n");

            writer.append("\nRuntime: " + results.getRuntimes()[currentSample - 1].runtime() + "ms\n");
            writer.append("\nSuffix Array: \n");
            writer.append(suffixArray.toString() + "\n");;
            writer.close();
        }
    }

    @Override
    public String getFilename() 
    {
        makeDirectory();

        FORMAT = sortDir + "/N%d_Sample%d.txt";
        int inputSize = results.getRuntimes()[currentSample].inputSize();
        int sampleNum = currentSample % results.getSAMPLE_SIZE() + 1;
        
        String temp = String.format(FORMAT, inputSize, sampleNum);
        currentSample++;

        return temp;
    }
    
    private void makeDirectory()
    {
        sortDir = DAT_DIR + "raw_data/" + getSortName();
        new File(sortDir).mkdir();
    }
}
