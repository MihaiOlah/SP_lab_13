package services;

import Spring.models.ParagraphAlignment;

public class AlignmentStrategyFactory {
    public AlignmentStrategyFactory() {}

    public AlignStrategy create(ParagraphAlignment textAlingment)
    {
        if (textAlingment == null)
        {
            return null;
        }

        if (textAlingment.equals(ParagraphAlignment.LEFT))
        {
            return new AlignLeft();
        }
        else if (textAlingment.equals(ParagraphAlignment.CENTER))
        {
            return new AlignCenter();
        }
        else if (textAlingment.equals(ParagraphAlignment.RIGHT))
        {
            return new AlignRight();
        }
        else
        {
            return null;
        }
    }
}
