package wolfPub.menu;

import wolfPub.crud.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import wolfPub.transactions.*;


public class DistributorOperations {

    public static void distributorOperationsUI(BufferedReader reader) throws NumberFormatException, IOException, SQLException {
        Integer did, orderid;
        Float price, shipping_cost, total_pay;
        String placement_date, deadline_date;
        String[] args;
        String[] main_args = null;
        boolean exit_val = true;
        while(exit_val) {
            System.out.println("1.Input Orders");
            System.out.println("2.Bill a Distributor for Order");
            System.out.println("3.Change Balance of Distributor");
            System.out.println("4.Back to Main");
            String input = reader.readLine();


            switch (Integer.parseInt(input)) {
                case 1:
                    System.out.println("Enter | separated Integer DID");
                    args = reader.readLine().split("[|]");
                    did = Integer.valueOf(Integer.parseInt(args[0]));
                    System.out.println("Enter | separated Integer OrderID, String Deadline_Date, String Placement_Date,Float Shipping Cost,float price,float total_payment(0)");
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


                    insertTransactions.insertOrder(orderid, deadline_date, placement_date, shipping_cost, price, total_pay,did,pid,noc);

                    //InputOrders.insertPlaces(orderid, did);
                    //InputOrders.insertConsistsOf(orderid, pid, noc);
                    return;

                case 2:

                    // insertion required

                    System.out.println("Enter | separated Integer DID and Order ID");
                    args = reader.readLine().split("[|]");
                    Integer did2 = Integer.valueOf(Integer.parseInt(args[0]));
                    Integer oid2 = Integer.valueOf(Integer.parseInt(args[1]));
                    if (InputOrders.updateOrderpayment(did2, oid2)) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;

                case 3:
                    System.out.println("Enter | separated Integer DID and Balance for updation");
                    args = reader.readLine().split("[|]");
                    Integer did3 = Integer.valueOf(Integer.parseInt(args[0]));
                    Float balance = Float.valueOf(Float.parseFloat(args[1]));
                    if (DistributorCRUD.updateDistributorBalance(did3, balance)) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
                case 4:
                    Main.main(main_args);
                default:

                    System.out.println("Enter a valid choice");

            }

        }


        }
    }