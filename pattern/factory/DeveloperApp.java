package pattern.factory;

public class DeveloperApp {
    public static void main(String[] args) {
        Developer dev = DeveloperEnum.PHP.create("PHP");
        dev.create();
//        Developer developer = developerFactory.create();
//        developerFactory;
    }
    static DeveloperFactoryInterface createDeveloper(String dev) {
       if(dev.equals("java")) {
            return new JavaDeveloperFactory();
       } else if (dev.equals("Cpp")) {
          return new CppDeveloperFactory();
       } else {
           throw new RuntimeException(dev + " is not exists...");
       }
    }
}
