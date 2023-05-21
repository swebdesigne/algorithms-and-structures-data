package pattern.factory;

public class CppDeveloperFactory implements DeveloperFactoryInterface{
    @Override
    public Developer create() {
        return new CppDeveloper();
    }
}
