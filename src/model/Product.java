package model;

public class Product {
    private Long id;
    private String name;
    private String category;
    private boolean isExists;

    public Product() {
    }

    public Product(Long id, String name, String category, boolean isExists) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isExists = isExists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isExists() {
        return isExists;
    }

    public void setExists(boolean exists) {
        isExists = exists;
    }

    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", category='" + category + '\'' +
               ", isExists=" + isExists +
               '}';
    }
}
