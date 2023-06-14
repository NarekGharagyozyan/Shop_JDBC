package sevice.order;

import model.Product;
import model.User;


public interface OrderService {
    void createOrder(Long userId, Long productId, int count) throws Exception;
}
