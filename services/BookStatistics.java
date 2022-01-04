package services;

import Spring.models.*;

public class BookStatistics implements Visitor<Void> {
    private int numberOfImages_;
    private int numberOfTables_;
    private int numberOfParagraphs_;

    public BookStatistics()
    {
        numberOfImages_ = numberOfTables_ = numberOfParagraphs_ = 0;
    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + numberOfImages_);
        System.out.println("*** Number of tables: " + numberOfTables_);
        System.out.println("*** Number of paragraphs: " + numberOfParagraphs_);
    }

    @Override
    public Void visitBook(Book book) {
        return visitSection(book);
    }

    @Override
    public Void visitSection(Section section) {
        numberOfImages_ = numberOfTables_ = numberOfParagraphs_ = 0;

        for (Element element : section.getContent())
        {
            if (element instanceof Image || element instanceof ImageProxy)
            {
                numberOfImages_++;
            }
            else if (element instanceof Paragraph)
            {
                numberOfParagraphs_++;
            }
            else if (element instanceof Table || element instanceof TableOfContents)
            {
                numberOfTables_++;
            }
            else if (element instanceof Section)
            {
                ((Section)element).accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visitTableOfContents(TableOfContents tableOfContents) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Void visitParagraph(Paragraph paragraph) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Void visitImageProxy(ImageProxy imageProxy) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Void visitImage(Image image) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Void visitTable(Table table) {
        throw new UnsupportedOperationException();
    }
}
