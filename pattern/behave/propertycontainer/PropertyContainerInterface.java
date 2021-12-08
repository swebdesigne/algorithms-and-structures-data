package pattern.behave.propertycontainer;

import java.util.Map;

public interface PropertyContainerInterface<T> {
        void addProperty(String propertyName, T value);

        void updateProperty(String propertyName, T value);

        void deleteProperty(String propertyName);

        T getProperty(String propertyName);
}
