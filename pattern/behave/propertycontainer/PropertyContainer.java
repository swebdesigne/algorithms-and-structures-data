package pattern.behave.propertycontainer;

import java.util.HashMap;
import java.util.Map;

public class PropertyContainer<T> implements PropertyContainerInterface<T> {
    Map<String, T> propertyContainer = new HashMap<>();

    @Override
    public void addProperty(String propertyName, T value) {
        this.propertyContainer.computeIfAbsent(propertyName, v -> value);
    }

    @Override
    public void updateProperty(String propertyName, T value) {
        if (propertyContainer.containsKey(propertyName)) {
            propertyContainer.put(propertyName, value);
        } else {
            System.out.println("The property `" + propertyName + "` not found");
        }
    }

    @Override
    public void deleteProperty(String propertyName) {
         propertyContainer.remove(propertyName);
    }

    @Override
    public T getProperty(String propertyName) {
        return propertyContainer.get(propertyName);
    }
}
