package pattern.behave.propertycontainer;

public class Main {
    public static void main(String[] args) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("Title article");
        System.out.println(blogPost.getTitle());
        blogPost.setCategoryId(10);
        System.out.println(blogPost.getCategoryId());
        blogPost.addProperty("view_count", 100);
        System.out.println(blogPost.getProperty("view_count"));
        blogPost.addProperty("last_update", "2030-02-01");
        System.out.println(blogPost.getProperty("last_update"));
        blogPost.updateProperty("last_update", "2030-02-02");
        blogPost.updateProperty("last_update_123", "2030-02-02");
        System.out.println(blogPost.getProperty("last_update"));
        blogPost.addProperty("read_only", true);
        System.out.println(blogPost.getProperty("read_only"));
        blogPost.deleteProperty("read_only");
        System.out.println(blogPost.getProperty("read_only"));
    }
}
