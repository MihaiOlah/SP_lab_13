package Spring.models;

import java.util.Objects;

public class TableOfContents extends Element implements Visitee {
    private final String title_;

    public TableOfContents(String title)
    {
        if (title != null)
            title_ = title;
        else
            title_ = "";
    }

    public TableOfContents(TableOfContents tableOfContents)
    {
        title_ = tableOfContents.title_;
    }

    public String getTitle() { return title_; }

    @Override
    public boolean add(Element element)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public boolean remove(Element element)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public Element get(int index)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public <T> T accept(Visitor<T> visitor) {

        return visitor.visitTableOfContents(this);
    }

//    @Override
//    public void accept(BookStatistics bookStatistics) {
//        throw new UnsupportedOperationException();
//    }
}
