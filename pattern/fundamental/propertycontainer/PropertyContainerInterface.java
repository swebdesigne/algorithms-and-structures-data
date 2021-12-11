package pattern.fundamental.propertycontainer;

public interface PropertyContainerInterface<T> {
        void addProperty(String propertyName, T value);

        void updateProperty(String propertyName, T value);

        void deleteProperty(String propertyName);

        T getProperty(String propertyName);
}
