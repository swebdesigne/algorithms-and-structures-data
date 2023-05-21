package pattern.factory;

public interface Developer {
    boolean accept(String val);
    Developer create();
}
