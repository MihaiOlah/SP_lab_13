package Spring.models;

import javax.persistence.Entity;

@Entity
public abstract class Element extends References {
    public abstract boolean add(Element element);
    public abstract boolean remove(Element element);
    public abstract Element get(int index);
    public abstract void setNewValue(String newValue);
}
