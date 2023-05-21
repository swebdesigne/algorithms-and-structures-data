package pattern.factory;

public class PhpDeveloper implements Developer {

    public boolean accept(String val) {
        return "PHP".equals(val);
    }

    @Override
    public Developer create() {
        System.out.println("Php developer has been created...");
        return null;
    }
}
