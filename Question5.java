
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A222231
 */
public class Question5 {
    public static void main(String[] args) {
        
        //display menu
        System.out.println("---------------MENU--------------");
        for(int i=0;i<5;i++) {
            System.out.println(products(i));
        }
        
        //choose product between 0 and 4
        int prod_index;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose product 0-4");
        prod_index=sc.nextInt();
        
        System.out.println("Enter money eg: 1.00");
        double money = sc.nextDouble();
        
        System.out.println("Delivered product ->" + products(prod_index));
        
        double amount = prices(prod_index);
        
        System.out.println("Delivered Change ->" + (money-amount));
    }
    
    public static double prices(int index) {
        double[] prices = new double[]{1.00,2.00,3.00,4.00,5.00};
        return prices[index];
    }
    
    public static String products(int index) {
        String[] products = new String[]{"Kit Kat","Beef","candy","simba","cream"};
        return products[index];
    }
}
