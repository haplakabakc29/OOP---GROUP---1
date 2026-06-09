package eCommerceData;

import java.util.LinkedList;

public class OrderData {

    public static class Order { // model
        private static int counter = 1;

        private int orderNumber; 
        private int itemCount;
        private int totalPrice;
        private String status; 

        public Order(int itemCount, int totalPrice) {
            this.orderNumber = counter++;
            this.itemCount = itemCount;
            this.totalPrice = totalPrice;
            this.status = "HUHU";
        }
   
        public String getStatus()   { 
            return status; 
        }

        public void markReceived()  { 
            this.status = "Received"; 
        }
 
        @Override
        public String toString() {
           String tag = "";
                if (status.equals("Received")) {
                tag = "                         ✓ Order Received";
            }
                
            return "    - Order " + orderNumber + "  |  " + itemCount + " item(s)  |  ₱ " + totalPrice + tag;
        }
    }

    // service
    private static final LinkedList<Order> orders = new LinkedList<>();

    public static void addOrder(int itemCount, int totalPrice) {
        orders.add(new Order(itemCount, totalPrice));
    }

    public static LinkedList<Order> getOrders() {
        return orders;
    }

    public static void removeOrder(Order order) {
        orders.remove(order);
    }
    
}