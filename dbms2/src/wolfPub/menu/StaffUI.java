package wolfPub.menu;



import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import wolfPub.crud.StaffCRUD;

public class StaffUI {
    public static void staffUI(BufferedReader reader) throws NumberFormatException, IOException {
        Integer id;
        String name, type;

        String[] args;
        System.out.println("1.viewAllStaff");
        System.out.println("2.viewStaffById");
        System.out.println("3.insertStaff");
        System.out.println("4.updateStaff");
        System.out.println("5.deleteStaff");
        System.out.println("6.exit");
        String input = reader.readLine();
        //String str1;
        switch (Integer.parseInt(input)) {
            case 1:

                StaffCRUD.viewStaff().forEach(System.out::println);
                return;
            case 2:

                System.out.println("Enter staffId");
                id = Integer.valueOf(Integer.parseInt(reader.readLine()));
                System.out.println(StaffCRUD.viewStaff(id));
                return;
            case 3:


                System.out.println("Enter | separated Integer StaffID, String Name, String Type");
                args = reader.readLine().split("[|]");
                System.out.println(Arrays.toString((Object[])args));
                id = Integer.valueOf(Integer.parseInt(args[0]));
                name = args[1];
                type = args[2];

                System.out.println("New staffId is");
                System.out.println(StaffCRUD.insertStaff(id,name,type));
                return;
            case 4:

                System.out.println("Enter | separated Integer StaffID, String Name, String Type");
                args = reader.readLine().split("[|]");
                id = Integer.valueOf(Integer.parseInt(args[0]));
                name = args[1];
                type = args[2];
                if (StaffCRUD.updateStaff(id, name, type).booleanValue()) {
                    System.out.println("Operation Successful");
                } else {
                    System.out.println("Operation Failed");
                }
                return;

        }
        System.out.println("Enter a valid choice");
    }
}