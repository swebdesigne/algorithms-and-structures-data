package pattern.factory;

public class PhpDeveloperFactory implements DeveloperFactoryInterface{
    @Override
    public Developer create() {
        return new PhpDeveloper();
    }
}
