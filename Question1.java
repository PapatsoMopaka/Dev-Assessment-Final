
import java.math.BigInteger;
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
public class Question1 {
    public static void main(String[] args)
    {
        int T;
        
        //Get number of iterations
        Scanner sc = new Scanner(System.in);
        T=sc.nextInt();
        BigInteger[] n = new BigInteger[T];
        for(int i=1;i<=T;i++) {
            n[i-1]=sc.nextBigInteger();
        }
        
        for(int i=1;i<=T;i++) {
            System.out.println(isDivisible(n[i-1]));
        }
        
        
    }
    
    public static int isDivisible(BigInteger n)
    {
        int ans;
        if(n.mod(BigInteger.valueOf(8)).equals(BigInteger.ZERO))
            ans = 1;
        else
            ans = -1;
        return ans;
    }
}
