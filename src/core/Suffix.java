package core;
import lombok.Getter;

@Getter
public class Suffix implements Comparable<Suffix>
{
    private int start;
    private String suffix;

    public Suffix(String base, int start)
    {
        this.start = start;
        this.suffix = base.substring(start);
    }

    @Override
    public int compareTo(Suffix o) 
    {
        return this.suffix.compareTo(o.suffix);
    }

    public void swap(Suffix a)
    {
        int start = this.start;
        String suffix = this.suffix;

        this.start = a.start;
        this.suffix = a.suffix;

        a.start = start;
        a.suffix = suffix;
    }
}