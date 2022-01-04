package services;

import Spring.models.*;

import java.util.ArrayList;
import java.util.List;

public class BookSaveVisitor implements Visitor<Void> {
    private List<Image> images_;
    private List<ImageProxy> imageProxies_;
    private List<Table> tables_;
    private List<TableOfContents> tableOfContents_;
    private List<Paragraph> paragraphs_;
    private List<Book> books_;

    public BookSaveVisitor()
    {
        images_ = new ArrayList<>();
        imageProxies_ = new ArrayList<>();
        tables_ = new ArrayList<>();
        tableOfContents_ = new ArrayList<>();
        paragraphs_ = new ArrayList<>();
        books_ = new ArrayList<>();
    }

    @Override
    public Void visitBook(Book book) {
        books_.add(book);

        return null;
    }

    @Override
    public Void visitSection(Section section) {

        for (Element element : section.getContent())
        {
            ((Visitee)element).accept(this);
        }



        return null;
    }

    @Override
    public Void visitTableOfContents(TableOfContents tableOfContents) {
        tableOfContents_.add(tableOfContents);

        return null;
    }

    @Override
    public Void visitParagraph(Paragraph paragraph) {
        paragraphs_.add(paragraph);

        return null;
    }

    @Override
    public Void visitImageProxy(ImageProxy imageProxy) {
        imageProxies_.add(imageProxy);

        return null;
    }

    @Override
    public Void visitImage(Image image) {
        images_.add(image);

        return null;
    }

    @Override
    public Void visitTable(Table table) {
        tables_.add(table);

        return null;
    }
}
