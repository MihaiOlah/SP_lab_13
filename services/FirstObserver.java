package services;

public class FirstObserver implements Observer{
    private String value_;

    public FirstObserver()
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
