package services;

import Spring.models.Book;

public class StatisticsCommand implements Command{
    private Book book_;

    public StatisticsCommand(Book book)
    {
        book_ = new Book(book);
    }

    @Override
    public void execute() {
        BookStatistics stats = new BookStatistics();
        book_.accept(stats);
        stats.printStatistics();
    }
}
