package wolfPub.menu;



import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import wolfPub.crud.StaffCRUD;

public class StaffUI {
    public static void staffUI(BufferedReader reader) throws NumberFormatException, IOException {
        Integer id, age;
        String name, type, gender;

        String[] args;
        boolean exit_val = true;
        String[] main_args = null;
        while (exit_val) {
            System.out.println("1.viewAllStaff");
            System.out.println("2.viewStaffById");
            System.out.println("3.insert");
            System.out.println("4.updateStaff");
            System.out.println("5.deleteStaff");
            System.out.println("6.Back to Main");
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
                    System.out.println(Arrays.toString((Object[]) args));
                    id = Integer.valueOf(Integer.parseInt(args[0]));
                    name = args[1];
                    type = args[2];
                    age = Integer.valueOf(Integer.parseInt(args[3]));
                    gender = args[4];

                    System.out.println("New staffId is");
                    System.out.println(StaffCRUD.insertStaff(id, name, type, age, gender));

                    return;
                case 4:
                    System.out.println("Enter | separated Integer StaffID, String Name, String Type, Integer age, String Gender ");
                    args = reader.readLine().split("[|]");
                    id = Integer.valueOf(Integer.parseInt(args[0]));
                    name = args[1];
                    type = args[2];
                    age = Integer.valueOf(Integer.parseInt(args[3]));
                    gender = args[4];


                    if (StaffCRUD.updateStaff(id, name, type, age, gender).booleanValue()) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
                case 5:
                    //To-DO
                case 6:
                    Main.main(main_args);
                default:
                    System.out.println("Enter a valid choice");

            }
            System.out.println("Enter a valid choice");
        }
    }
}