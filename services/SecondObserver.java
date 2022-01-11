package services;

public class SecondObserver implements Observer {
    private String value_;

    public SecondObserver()
    {
        value_ = "";
    }

    @Override
    public void update(String newValue) {
        System.out.println("SecondObserver\nOld value: " + value_);
        value_ = newValue;
        System.out.println("New value: " + value_);
    }
}
