package log;

import java.io.IOException;

public interface Logger 
{
    public abstract String getFilename();
    public abstract void print() throws IOException;
}
