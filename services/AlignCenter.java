package services;

import Spring.models.Context;

public class AlignCenter implements AlignStrategy {
    public String render(String paragraph, Context context)
    {
        StringBuilder alignedContent = new StringBuilder();
        int width = context.getWidth();
        int currentLineLength;

        currentLineLength = 0;
        alignedContent.append("\t\t\t\t\t\t");
        for (int i = 0; i < paragraph.length(); i++)
        {
            alignedContent.append(paragraph.charAt(i));
            currentLineLength++;

            if (width == currentLineLength)
            {
                currentLineLength = 0;
                alignedContent.append("\n\t\t\t\t\t\t");
            }
        }

        return alignedContent.toString();
    }
}
