import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;
import br.com.codenation.service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class mainTest {

    public static void main(String[] args) {
        ProductRepository productsMockedData = new ProductRepositoryImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        List<Long> ids = new ArrayList<>();
        ids.add(1l);
        ids.add(2l);

        System.out.println(productsMockedData.findById(2l).get().getValue());
        orderService.findProductsById(ids).forEach(product -> System.out.println(product.getValue()));
    }
}
