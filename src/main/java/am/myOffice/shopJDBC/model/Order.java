package am.myOffice.shopJDBC.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private double totalPrice;
    private int totalCountOfProduct;

    public Order(Long userId, Long productId, double totalPrice, int totalCountOfProduct) {
        this.userId = userId;
        this.productId = productId;
        this.totalPrice = totalPrice;
        this.totalCountOfProduct = totalCountOfProduct;
    }


}