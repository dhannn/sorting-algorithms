package core.sequence;

import java.util.Random;

import lombok.Getter;

public class Sequence
{
    private final String ALPHABET;
    @Getter private int length;
    private String sequence;
    
    public Sequence(String alphabet, int n)
    {
        this.ALPHABET = alphabet;
        this.length = n;
    }

    public void generateRandom()
    {
        StringBuilder strBuilder = new StringBuilder(this.length);

        for(int i = 0; i < this.length; i++)
        {
            char randomChar = this.getRandomCharacter();
            strBuilder.append(randomChar);
        }

        this.sequence = strBuilder.toString();
    }

    public String getSuffix(int index)
    {
        return sequence.substring(index);
    }

    public int compareTo(int a, int b)
    {
        String suffixA = getSuffix(a);
        String suffixB = getSuffix(b);

        return suffixA.compareToIgnoreCase(suffixB);
    }
    
    private char getRandomCharacter()
    {
        Random random = new Random();
        int bound = this.ALPHABET.length();
        int index = random.nextInt(bound);

        return this.ALPHABET.charAt(index);
    }
}
