package wolfPub.menu;

import java.io.BufferedReader;
import java.io.IOException;

public class DistributorMenuUI {
    public static void distributorMenuUI(BufferedReader reader) throws NumberFormatException, IOException {

        String[] main_args = null;
        boolean exit_val = true;
        while (exit_val) {
            System.out.println("DISTRIBUTOR MENU");
            System.out.println("1. View Information");
            System.out.println("2. Back to Main Menu");

            String input = reader.readLine();
            String[] str = null;

            switch (Integer.parseInt(input)) {
                case 1:
                    PublicationUI.publicationUI(reader);
                    //System.out.println("Test Admin-Publication");
                    break;
                case 2:
                    Main.main(str);
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
