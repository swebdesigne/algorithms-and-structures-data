package solid.single_responsibility_principle;

public class Product {
    private Logger logger;

    public Product(Logger logger) {
        this.logger = logger;
    }

    public void setPrice(String price) {
        System.out.println(0.2 * Float.parseFloat(price));
    }

    public static void main(String[] args) {
        Product product = new Product(new Logger());
        try {
            product.setPrice("4f");
        } catch (NumberFormatException e) {
            product.logger.displayLog(e.getMessage());
        }
        System.out.println("done");
    }
}
