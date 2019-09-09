package matching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vijay.hathimare on 4/29/19.
 */
public class MatchingCriteria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("size of array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        System.out.println("inputs to array : ");
        for(int i = 0; i< size ; i ++){
            int number = sc.nextInt();
            arr[i] = number;
        }
        System.out.println("sum : ");
        sum = sc.nextInt();


        System.out.println("Size : "+ size);
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Sum : " + sum);


        Map<Integer, Integer> sumOfTwo = new HashMap<Integer, Integer>();
        Map<Integer, Integer> sumOfThree = new HashMap<Integer, Integer>();
    }
}
