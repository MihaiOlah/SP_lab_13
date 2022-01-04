package Spring.models;

public interface Visitee {
    <T> T accept(Visitor<T> visitor);
}
