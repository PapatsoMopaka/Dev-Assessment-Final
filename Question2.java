import java.util.ArrayList;
import java.util.Comparator;
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

public class Question2 {

  private static int waiter1_capacity;
  private static int waiter2_capacity;


  public class Order{

   private int waiter1_tip;
    private int waiter2_tip;
    private int tip_diff;

    Order(int waiter1_tip, int waiter2_tip,int tip_diff){
      this.waiter1_tip=waiter1_tip;
      this.waiter2_tip=waiter2_tip;
      this.tip_diff= tip_diff;
    }


    public int getWaiter1_tip() {
      return waiter1_tip;
    }

    public int getWaiter2_tip() {
      return waiter2_tip;
    }

    public int getTip_diff() {
      return tip_diff;
    }
  }


  public static void main(String[] args) {
    Question2 maximumTip = new Question2();

    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();

    while (testcases > 0) {
      sc.nextLine();
      int numOrders = Integer.parseInt(sc.next()) * 2;
      waiter1_capacity = Integer.parseInt(sc.next());
      waiter2_capacity = Integer.parseInt(sc.next());

      ArrayList<Integer> tips = new ArrayList<>();

      for (int i = 0; i < numOrders; i++) {
        tips.add(sc.nextInt());
      }
      int maxTip = maximumTip.findMaxTip(maximumTip.sortTips(tips));
      System.out.println(maxTip);
      testcases--;
    }

  }

  private int findMaxTip(ArrayList<Order> sortedOrders) {
    int maxTip=0;
    for (Order order : sortedOrders) {
      if ((waiter1_capacity > 0) && (waiter2_capacity > 0)) {
        if (order.getTip_diff() > 0) {
          maxTip = maxTip + order.getWaiter1_tip();
          waiter1_capacity--;
        } else {
          maxTip = maxTip + order.getWaiter2_tip();
          waiter2_capacity--;
        }
      } else {
        if (waiter1_capacity == 0) {
          maxTip = maxTip + order.getWaiter2_tip();
          waiter2_capacity--;
        } else {
          maxTip = maxTip + order.getWaiter1_tip();
          waiter1_capacity--;
        }
      }
    }
    return maxTip;
  }

  private ArrayList<Order> sortTips(ArrayList<Integer>tips){
    
        int numOfTips= tips.size()/2;

        ArrayList<Order> orders = new ArrayList<>();
        for(int i=0;i<numOfTips;i++){
          int tip1= tips.get(i);
          int tip2 =tips.get(i+numOfTips);
          orders.add(new Order(tip1,tip2,tip1-tip2));
        }
        Comparator<Order> comparator=Comparator.comparing( o->Math.abs(o.getTip_diff()));
        orders.sort(comparator.reversed());
    return orders;
  }

}





