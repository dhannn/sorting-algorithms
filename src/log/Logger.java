package log;

import java.io.FileWriter;
import java.io.IOException;

import core.Sort.SortTester;
import lombok.Getter;
import lombok.Setter;

public abstract class Logger 
{
    @Getter protected SortTester tester;
    @Setter protected FileWriter writer;
    
    public abstract String getFilename();
    public abstract void print() throws IOException;

    public Logger(SortTester tester) throws IOException
    {
        this.tester = tester;
        this.writer = new FileWriter(getFilename());
    }
}
