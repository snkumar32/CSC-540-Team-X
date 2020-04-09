package wolfPub.menu;

import wolfPub.crud.PaymentOperations;
import wolfPub.crud.ReportOperations;

import java.io.BufferedReader;
import java.io.IOException;

public class ReportUI {
    public static void reportUI(BufferedReader reader) throws NumberFormatException, IOException {
        String startDate, endDate;

        String[] args;
        System.out.println("1.View number of copies sold per distributor per month");
        System.out.println("2. View total Revenue");
        System.out.println("3.View Total Expense");
        System.out.println("4.View Total number of Distributors");
        System.out.println("5.View Total Revenue generated per city");
        System.out.println("6.View Total revenue generated per Distributor");
        System.out.println("7.View Total Revenue generated per Location");
        String input = reader.readLine();
        //String str1;
        switch (Integer.parseInt(input)) {
            case 1:
                ReportOperations.viewTotalNumberOFCopiesPerDistributorPerMonth();
                return;
            case 2:
                ReportOperations.viewTotalRevenue();
                return;
            case 3:
                ReportOperations.viewTotalExpense();
                return;
            case 4:
                ReportOperations.viewTotalNumberOfDistributors();
                return;
            case 5:
                ReportOperations.viewTotalRevenuePerCity();
                return;
            case 6:
                ReportOperations.viewTotalRevenuePerDistributor();
                return;
            case 7:
                ReportOperations.viewTotalRevenuePerLocation();
                return;
        }
        System.out.println("Enter a valid choice");
    }

}
