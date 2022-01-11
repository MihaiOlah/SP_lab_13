package Spring.models;

import services.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Table extends Element implements Visitee, Observable {
    private String title_;
    protected transient List<Observer> observers_;

    public Table(String title)
    {
        if (title != null)
            title_ = title;
        else
            title_ = "";

        observers_ = new ArrayList<>();
    }

    public Table(Table table)
    {
        title_ = table.title_;
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
        return visitor.visitTable(this);
    }

    public void setNewValue(String newValue)
    {
        title_ = newValue;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
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
            obs.update(title_);
        }
    }
}
