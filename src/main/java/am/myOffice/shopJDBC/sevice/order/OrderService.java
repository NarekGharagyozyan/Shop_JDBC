package am.myOffice.shopJDBC.sevice.order;

public interface OrderService {
    void createOrder(Long userId, Long productId, int count) throws Exception;
}
