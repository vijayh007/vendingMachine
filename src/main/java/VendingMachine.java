import java.util.List;

/**
 * Created by vijay.hathimare on 4/29/19.
 */

public interface VendingMachine {
    ReturnItems selectProductInsertCoin(Product product, List<Integer> coins) throws  Exception;
    List<Integer> returnCoins(int productPrice, List<Integer> coins) throws Exception;
    String addMoreProduct(List<Product> products);
    List<TotalProduct> inStock();
}
