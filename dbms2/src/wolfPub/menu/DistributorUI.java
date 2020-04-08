package wolfPub.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import wolfPub.crud.*;


public class DistributorUI {

    public static void distributorUI(BufferedReader reader) throws NumberFormatException, IOException {
        Integer did;
        Float balance;
        String name, type, phone,contact_person,street,city;
        String[] args;
        System.out.println("1.viewAllDistributor");
        System.out.println("2.insertDistributor");
        System.out.println("3.updateDistributor");
        System.out.println("4.deleteDistributor");
        System.out.println("5.exit");
        String input = reader.readLine();
        switch (Integer.parseInt(input)) {
            case 1:

                DistributorCRUD.viewDistributor().forEach(System.out::println);
                return;
            case 2:

                System.out.println("Enter | separated Integer DID, String Name, String Type,String phone,float balance,String contact Person, String street and String City");
                args = reader.readLine().split("[|]");
                System.out.println(Arrays.toString((Object[])args));
                did = Integer.valueOf(Integer.parseInt(args[0]));
                name = args[1];
                type = args[2];
                phone = args[3];
                balance = Float.valueOf(Float.parseFloat(args[4]));
                street = args[6];
                city = args[7];
                contact_person = args[5];

                System.out.println("New Distributor ID is");
                System.out.println(DistributorCRUD.insertDistributor(did,name,type,phone,balance,contact_person,street,city));
                return;
            case 3:

                System.out.println("Enter | separated Integer DID, String Name, String Type,String phone,float balance,String contact Person, String street and String City");
                args = reader.readLine().split("[|]");
                did = Integer.valueOf(Integer.parseInt(args[0]));
                name = args[1];
                type = args[2];
                phone = args[3];
                balance = Float.valueOf(Float.parseFloat(args[4]));
                street = args[6];
                city = args[7];
                contact_person = args[5];


                if (DistributorCRUD.updateDistributor(did, name, type, phone, balance,contact_person,street,city).booleanValue()) {
                    System.out.println("Operation Successful");
                } else {
                    System.out.println("Operation Failed");
                }
                return;

        }

    }
}