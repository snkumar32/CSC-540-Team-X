package wolfPub.menu;

import wolfPub.crud.PaymentOperations;
import wolfPub.crud.StaffCRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class PaymentUI {

    public static void paymentUI(BufferedReader reader) throws NumberFormatException, IOException {
        String startDate, endDate;

        String[] args;
        System.out.println("1.View Payment for all Staff");
        System.out.println("2. View Total Payment");
        System.out.println("3.View Total Payment by Date range for Editor");
        System.out.println("4.View Total Payment by Date range for Author(Book)");
        System.out.println("5.View Total Payment by Date range for Author(Article)");
        String input = reader.readLine();
        //String str1;
        switch (Integer.parseInt(input)) {
            case 1:
                PaymentOperations.viewStaffPaymnet().forEach(System.out::println);
                return;
            case 2:
                System.out.println("Enter | separated Start Date and endDate");
                args = reader.readLine().split("[|]");
                startDate = args[0];
                endDate = args[1];
                PaymentOperations.viewStaffTotalPaymnet(startDate,endDate);
                return;
            case 3:
                System.out.println("Enter | separated Start Date and endDate");
                args = reader.readLine().split("[|]");
                startDate = args[0];
                endDate = args[1];
                PaymentOperations.viewEditorTotalPaymnet(startDate,endDate);
                return;
            case 4:
                System.out.println("Enter | separated Start Date and endDate");
                args = reader.readLine().split("[|]");
                startDate = args[0];
                endDate = args[1];
                PaymentOperations.viewBookAuthorTotalPaymnet(startDate,endDate);
                return;
            case 5:
                System.out.println("Enter | separated Start Date and endDate");
                args = reader.readLine().split("[|]");
                startDate = args[0];
                endDate = args[1];
                PaymentOperations.viewArticleAuthorTotalPaymnet(startDate,endDate);
                return;
        }
        System.out.println("Enter a valid choice");
    }

}
