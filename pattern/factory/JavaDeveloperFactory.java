package pattern.factory;

public class JavaDeveloperFactory implements DeveloperFactoryInterface {

    @Override
    public Developer create() {
        return new JavaDeveloper();
    }
}
