package services;

import Spring.models.Book;

public class DocumentManager {
    private static DocumentManager instance_ = null;
    public static Book book_;

    private DocumentManager()
    {

    }

    public static DocumentManager getInstance()
    {
        if (instance_ == null)
        {
            instance_ = new DocumentManager();
        }

        return instance_;
    }

    public static Book getBook()
    {
        return book_;
    }

    public static void setBook(Book book)
    {
        book_ = new Book(book);
    }
}
