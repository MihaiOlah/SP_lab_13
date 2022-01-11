package Spring.models;

import services.Observer;

import javax.persistence.Entity;

//@Entity
public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
