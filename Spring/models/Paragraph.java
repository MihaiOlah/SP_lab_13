package Spring.models;

import services.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paragraph extends Element implements Visitee, Observable {
    private String text_;
    private ParagraphAlignment align_;
    protected transient List<Observer> observers_;

    public Paragraph(String text)
    {
        if (text != null)
            text_ = text;
        else
            text_ = "";

        align_ = ParagraphAlignment.LEFT;
        observers_ = new ArrayList<>();
    }

    public Paragraph(Paragraph paragraph)
    {
        text_ = paragraph.text_;
    }

    public void setAlignStrategy(ParagraphAlignment alignStrategy) throws Exception
    {
        if (alignStrategy == null)
        {
            throw new Exception("Alignment cannot be null");
        }
        else
        {
            align_ = alignStrategy;
        }
    }

    public String getText()
    {
        return text_;
    }

    public ParagraphAlignment getAlignStrategy() { return align_; }

    public void setText(String text)
    {
        text_ = text;
    }

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

        return visitor.visitParagraph(this);
    }

    public void setNewValue(String newValue)
    {
        text_ = newValue;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null)
            observers_.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers_.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs : observers_)
        {
            obs.update(text_);
        }
    }
}
