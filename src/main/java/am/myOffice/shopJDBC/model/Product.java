package am.myOffice.shopJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private double price;
    private String category;
    private boolean isExists;

    @Override
    public String toString() {
        return "Product |  " +
               "id: " + id +
               ", name: " + name +
               ", category: " + category +
               ", isExists: " + isExists;
    }
}
