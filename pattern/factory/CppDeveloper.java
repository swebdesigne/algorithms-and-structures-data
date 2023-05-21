package pattern.factory;

public class CppDeveloper implements Developer {
    public boolean accept(String val) {
        return "CPP".equals(val);
    }

    @Override
    public Developer create() {
        System.out.println("C++ developer has been create...");
        return null;
    }
}
