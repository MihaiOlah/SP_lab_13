package Spring.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Book extends Section implements Visitee{
    @ManyToMany
    private List<Author> authors_;

    public Book()
    {
        super("");
        authors_ = new ArrayList<>();
    }

    public Book(String title)
    {
        super(title);
        authors_ = new ArrayList<>();
    }

    public Book(Book book)
    {
        super(book.title_, book.content_);
        authors_ = new ArrayList<>(book.authors_);
    }

    public Book(String title, List<Element> content, List<Author> authors)
    {
        super(title, content);
        authors_ = new ArrayList<>(authors);
    }

    public boolean addContent(Element element)
    {
        return super.add(element);
    }

    public boolean removeContent(Element element)
    {
        return super.remove(element);
    }

    public boolean addAuthor(Author author)
    {
        return authors_.add(author);
    }

    public boolean removeAuthor(Author author)
    {
        return authors_.remove(author);
    }

    private <T> boolean checkCollectionSubsetOfAnother(List<T> collection_1, List<T> collection_2)
    {
        for (T obj : collection_1)
        {
            if (!collection_2.contains(obj))
            {
                return false;
            }
        }

        return true;
    }

    // Compare the contents of two collections
    private <T> boolean compareList(List<T> collection_1, List<T> collection_2)
    {
        return collection_1.size() == collection_2.size() && checkCollectionSubsetOfAnother(collection_1, collection_2)
                && checkCollectionSubsetOfAnother(collection_2, collection_1);
    }

    public List<Author> getAuthors()
    {
        return Collections.unmodifiableList(authors_);
    }
    @Override
    public boolean equals(Object book)
    {
        if (book == this)
            return true;

        if (!(book instanceof Book))
            return false;

        return title_.equalsIgnoreCase(((Book)book).title_) && compareList(content_, ((Book)book).content_)
                && compareList(authors_, ((Book)book).authors_);
    }

    @Override
    public Element get(int index)
    {
        return super.get(index);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitBook(this);
    }

//    @Override
//    public void accept(BookStatistics bookStatistics) { bookStatistics.visitBook(this); }
}
