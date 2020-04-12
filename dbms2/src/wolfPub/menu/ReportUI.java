package wolfPub.menu;

import wolfPub.crud.PaymentOperations;
import wolfPub.crud.ReportOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class ReportUI {
    public static void reportUI(BufferedReader reader) throws NumberFormatException, IOException {
        String city, location;
        String args;
        String[] str;

        Integer DID, Month, Year;
        boolean exit_val = true;
        String[] main_args = null;
        while (exit_val) {

            System.out.println("1.View number of copies sold per distributor per month");
            System.out.println("2.View number of copies sold per distributor per month - Input DID, Month, Year");
            System.out.println("3. View total Revenue");
            System.out.println("4.View Total Expense");
            System.out.println("5.View Total number of Distributors");
            System.out.println("6.View Total Revenue generated per city");
            System.out.println("7.View Total Revenue generated per city - Input City");
            System.out.println("8.View Total revenue generated per Distributor");
            System.out.println("9.View Total revenue generated per Distributor - Input Distributor");
            System.out.println("10.View Total Revenue generated per Location");
            System.out.println("11.View Total Revenue generated per Location - Input Location");
            System.out.println("12.Back to Main");
            String input = reader.readLine();

            switch (Integer.parseInt(input)) {
                case 1:
                    ReportOperations.viewTotalNumberOFCopiesPerDistributorPerMonth();
                    return;
                case 2:
                    System.out.println("Enter | separated DID, Month and Year)");
                    str = reader.readLine().split("[|]");
                    DID = Integer.valueOf(Integer.parseInt(str[0]));
                    Month = Integer.valueOf(Integer.parseInt(str[1]));
                    Year = Integer.valueOf(Integer.parseInt(str[2]));
                    ReportOperations.viewTotalNumberOFCopiesPerDistributorPerMonth(DID, Month, Year);
                    return;
                case 3:
                    ReportOperations.viewTotalRevenue();
                    return;
                case 4:
                    ReportOperations.viewTotalExpense();
                    return;
                case 5:
                    ReportOperations.viewTotalNumberOfDistributors();
                    return;
                case 6:
                    ReportOperations.viewTotalRevenuePerCity();
                    return;
                case 7:
                    System.out.println("Enter City");
                    city = reader.readLine();
                    ReportOperations.viewTotalRevenuePerCity(city);
                    return;
                case 8:
                    ReportOperations.viewTotalRevenuePerDistributor();
                    return;
                case 9:
                    System.out.println("Enter DID");
                    args = reader.readLine();
                    DID = Integer.valueOf(Integer.parseInt(args));
                    ReportOperations.viewTotalRevenuePerDistributor(DID);
                    return;
                case 10:
                    ReportOperations.viewTotalRevenuePerLocation();
                    return;
                case 11:
                    System.out.println("Enter Location");
                    location = reader.readLine();
                    ReportOperations.viewTotalRevenuePerLocation(location);
                    return;
                case 12:
                    Main.main(main_args);
                default:
                    System.out.println("Enter a valid choice");
            }
            System.out.println("Enter a valid choice");
        }
    }
}
