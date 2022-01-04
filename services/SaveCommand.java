package services;

import Spring.models.Book;

public class SaveCommand implements Command{
    private Book book_;

    public SaveCommand(Book book)
    {
        book_ = new Book(book);
    }

    @Override
    public void execute() {
        try {
            (new FileExporter()).export(book_, "fisier.json", new JsonVisitor());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
