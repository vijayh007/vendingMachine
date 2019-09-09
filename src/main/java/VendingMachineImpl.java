import Exceptions.InsertCoins;
import Exceptions.InvalidProductPrice;
import Exceptions.NoProduct;
import lombok.Data;

import java.util.*;

/**
 * Created by vijay.hathimare on 4/29/19.
 *
 */
@Data
public class VendingMachineImpl implements VendingMachine{
    Map<Product,Integer> totalProduct = new HashMap<Product, Integer>();

    public ReturnItems selectProductInsertCoin(Product product, List<Integer> coins) throws Exception{
        ReturnItems returnItems = new ReturnItems();
        if(coins == null || coins.size() < 0 ){
            throw new InsertCoins("Please insert the coin");
        }
        if(totalProduct != null){
            if(totalProduct.get(product) < 1){
                throw new NoProduct("Product is not in stock");
            }else {
                totalProduct.put(product, totalProduct.get(product)-1);
            }
        }
        List<Integer> returnCoins =  returnCoins(product.price,coins);
        returnItems.setChanges(returnCoins);
        returnItems.setProduct(product);
        return returnItems;
    }


    public List<Integer> returnCoins(int productPrice, List<Integer> coins) throws InvalidProductPrice{
        List<Integer> coinList = new ArrayList<Integer>();
        if(productPrice <= 0){
            throw  new InvalidProductPrice("Product Price Should be greater than Zero(0)");
        }
        int totalAmount = 0;
        for (Integer coin :coins){
            totalAmount = totalAmount + coin;
        }
        if(totalAmount < productPrice) {
            throw new InvalidProductPrice("You pay less amount for product");
        }else if(totalAmount == productPrice){
            return coinList;
        }else {
            coinList.add(totalAmount-productPrice);
        }
        return coinList;
    }

    public List<TotalProduct> inStock() {
        List<TotalProduct> totalProducts = new ArrayList<TotalProduct>();
        TotalProduct totalP;
        Set<Product> productSet = totalProduct.keySet();
        for (Product product:productSet){
            String item = product.getProductName();
            int count = totalProduct.get(product);
            totalP = new TotalProduct();
            totalP.setCount(count);
            totalP.setProductName(item);
            totalProducts.add(totalP);
        }
        return totalProducts;
    }

    public String addMoreProduct(List<Product> products) {
        if(products == null || products.size() < 1){
            return "Please add atleast one product";
        }
        for (Product product : products){
            if(totalProduct.containsKey(product)){
                totalProduct.put(product, totalProduct.get(product)+1);
            }else {
                totalProduct.put(product,1);
            }
        }
        return "Product Added Successfully";
    }

    public static void main(String[] args) {
        VendingMachineImpl vendingMachine = new VendingMachineImpl();
        List<Product> products = new ArrayList<Product>();
        Product coke = new Product();
        Product coke1 = new Product();
        Product pepsi = new Product();

        coke.setProductName("coke");
        coke.setPrice(25);

        coke1.setProductName("coke");
        coke1.setPrice(25);

        pepsi.setProductName("pepsi");
        pepsi.setPrice(35);

        products.add(coke);
        products.add(coke1);
        products.add(pepsi);

        vendingMachine.addMoreProduct(products);
        System.out.println(vendingMachine.inStock());

        List<Integer> coinList = new ArrayList<Integer>();
        coinList.add(15);
        coinList.add(15);

        try {
            ReturnItems returnItems = vendingMachine.selectProductInsertCoin(coke, coinList);
            System.out.println(returnItems);

            ReturnItems returnItems1 = vendingMachine.selectProductInsertCoin(coke, coinList);
            System.out.println(returnItems1);

            ReturnItems returnItems2 = vendingMachine.selectProductInsertCoin(coke, coinList);
            System.out.println(returnItems2);
            //System.out.println(vendingMachine.returnCoins(25,coinList));
        }catch (Exception ex){
            System.out.println(ex);
        }


    }
}
