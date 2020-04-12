package wolfPub.menu;

import java.io.BufferedReader;
import java.io.IOException;

public class EditorUI {
    public static void editorUI(BufferedReader reader) throws NumberFormatException, IOException {

        String[] main_args = null;
        boolean exit_val = true;
        while (exit_val) {
            System.out.println("EDITOR/AUTHOR MENU");
            System.out.println("1. View Publication");
            System.out.println("2. Update Publication information");
            System.out.println("3. Add Article - Periodic Publication");
            System.out.println("5. Delete Article  - Periodic Publication");
            System.out.println("6. Add Chapter - Book");
            System.out.println("7. Delete Chapter - Book");
            System.out.println("8. Back to Main Menu");

            String input = reader.readLine();
            String[] str = null;

            switch (Integer.parseInt(input)) {
                case 1:
                    PublicationUI.publicationUI(reader);
                    //System.out.println("Test Admin-Publication");
                    break;
                case 2:
                    StaffUI.staffUI(reader);
                    break;
                case 3:
                    DistributorOperations.distributorOperationsUI(reader);
                    break;
                case 4:
                    DistributorUI.distributorUI(reader);
                    break;
                case 5:
                    PaymentUI.paymentUI(reader);
                    break;
                case 6:
                    ReportUI.reportUI(reader);
                    break;
                case 7:
                    Main.main(str);
                case 8:
                    Main.main(str);
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
