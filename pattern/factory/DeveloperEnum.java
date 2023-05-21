package pattern.factory;

public enum DeveloperEnum {
    JAVA(new JavaDeveloperFactory()),
    CPP(new CppDeveloperFactory()),
    PHP(new PhpDeveloperFactory());

    final Developer developer;

    DeveloperEnum(DeveloperFactoryInterface javaDeveloperFactory) {
        this.developer = javaDeveloperFactory.create();
    }

    public Developer create(String lang) {
        for (DeveloperEnum dev : DeveloperEnum.values()) {
            if (dev.developer.accept(lang)) return dev.developer;
        }
        throw new RuntimeException(lang + " is not exists");
    }
}
