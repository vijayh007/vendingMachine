package Exceptions;

/**
 * Created by vijay.hathimare on 4/29/19.
 */
public class InvalidProductPrice extends  Exception{
    public InvalidProductPrice(String messge){
        super(messge);
    }
}
