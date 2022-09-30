package core;

import java.util.Random;

import core.Sort.AbstractSort;
import lombok.Getter;

public class SuffixArray
{
    final private String ALPHABET;
    @Getter private AbstractSort sorter;
    @Getter private int inputSize;
    @Getter private String baseSequence = null;
    Suffix[] suffixes;

    public SuffixArray(AbstractSort sorter, String alphabet, int n)
    {
        this.sorter = sorter;
        this.ALPHABET = alphabet;
        this.inputSize = n;
        
        this.suffixes = new Suffix[this.inputSize];
        this.generateRandom();
        this.generateSuffix();
    }

    public void executeSort()
    {
        sorter.sort(this.suffixes);
    }

    public String get(int i)
    {
        return suffixes[i].getSuffix();
    }

    private void generateRandom()
    {
        StringBuilder strBuilder = new StringBuilder(this.inputSize);

        for(int i = 0; i < this.inputSize; i++)
        {
            char randomChar = getRandomChar();
            strBuilder.append(randomChar);
        }

        this.baseSequence = strBuilder.toString();
    }

    private char getRandomChar()
    {
        Random rnd = new Random();
        int index = rnd.nextInt(ALPHABET.length());

        return ALPHABET.charAt(index);
    }

    private void generateSuffix()
    {
        for(int i = 0; i < this.inputSize; i++)
        {
            Suffix suffix = new Suffix(this.baseSequence, i);
            this.suffixes[i] = suffix;
        }
    }
}
