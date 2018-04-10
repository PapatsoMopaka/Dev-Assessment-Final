import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A222231
 */

public class Question3 {

  public static void main(String[] args) {
      
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    
    while (T > 0) {      
        int size = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> data = new ArrayList<>();
        for(int i=0;i<size;i++){
          data.add(sc.nextInt());
        }
        
        int i =0;
        int maxLevels= (int) Math.ceil(Math.log(data.size())/Math.log(2));
        
        while(i<maxLevels) {
            int start = (int) Math.pow(2,i)-1;
            int end = (int) Math.pow(2,i+1)-1;
            if(end>data.size()) end=data.size();
            List<Integer> templist= data.subList(start,end);
            templist.stream().sorted().forEach(n->System.out.print(n+" "));
            System.out.print("\n");
            i++;
        }
        T--;
    }
  }
  
}
