package core.data;

import lombok.Getter;

public enum NanoConverter 
{
    TO_MILLISECOND(1e-6f),
    TO_SECOND(1e-9f);

    @Getter
    private final float conversionFactor;
    
    private NanoConverter(float conversionFactor)
    {
        this.conversionFactor = conversionFactor;
    }
}
