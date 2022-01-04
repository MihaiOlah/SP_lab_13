package Spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class References {
    private boolean hasParent_ = false;
    @Id
    @GeneratedValue
    private int id_;

    public void setParent(boolean hasParent)
    {
        hasParent_ = hasParent;
    }

    public boolean getParent()
    {
        return hasParent_;
    }
}
