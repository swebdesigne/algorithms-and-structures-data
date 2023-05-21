package pattern.factory;

public class JavaDeveloper implements Developer {
    private final String LNG = "JAVA";

    public boolean accept(String val) {
        return LNG.equals(val);
    }

    @Override
    public Developer create() {
        System.out.println("The class JavaDeveloper has been create...");
        return null;
    }
}
