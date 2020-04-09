package wolfPub.menu;

import wolfPub.crud.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;


public class DistributorOperations {

    public static void distributorOperationsUI(BufferedReader reader) throws NumberFormatException, IOException {
        Integer did, orderid;
        Float price, shipping_cost, total_pay;
        String placement_date, deadline_date;
        String[] args;
        System.out.println("1.Input Orders");
        System.out.println("2.Bill a Distributor for Order");
        System.out.println("3.Change Balance of Distributor");
        System.out.println("4.exit");
        String input = reader.readLine();
        switch (Integer.parseInt(input)) {
            case 1:
                System.out.println("Enter | separated Integer DID");
                args = reader.readLine().split("[|]");
                did = Integer.valueOf(Integer.parseInt(args[0]));
                System.out.println("Enter | separated Integer OrderID, String Deadline_Date, String Placement_Date,Float Shipping Cost,float price,float total_payment");
                args = reader.readLine().split("[|]");
                orderid = Integer.valueOf(Integer.parseInt(args[0]));
                deadline_date = args[1];
                placement_date = args[2];
                shipping_cost = Float.valueOf(Float.parseFloat(args[3]));
                price = Float.valueOf(Float.parseFloat(args[4]));
                total_pay = Float.valueOf(Float.parseFloat(args[5]));
                System.out.println("Enter | separated PUBLICATION ID AND NUMBER OF COPIES");
                args = reader.readLine().split("[|]");
                Integer pid = Integer.valueOf(Integer.parseInt(args[0]));
                Integer noc = Integer.valueOf(Integer.parseInt(args[1]));




                InputOrders.insertOrder(orderid,deadline_date,placement_date,shipping_cost,price,total_pay);

                InputOrders.insertPlaces(orderid,did);
                InputOrders.insertConsistsOf(orderid,pid,noc);
                return;

            case 2:

                // insertion required

            case 3:
                System.out.println("Enter | separated Integer DID and Balance for updation");
                args = reader.readLine().split("[|]");
                Integer did1 = Integer.valueOf(Integer.parseInt(args[0]));
                Float balance = Float.valueOf(Float.parseFloat(args[1]));
                if(DistributorCRUD.updateDistributorBalance(did1,balance)){
                    System.out.println("Operation Successful");
                } else {
                    System.out.println("Operation Failed");
                }

            default:
                throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                }


        }
    }