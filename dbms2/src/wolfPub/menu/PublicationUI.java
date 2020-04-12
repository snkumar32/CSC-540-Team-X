package wolfPub.menu;
import wolfPub.crud.*;
import wolfPub.dbclasses.Edits;

import java.io.BufferedReader;
import java.io.*;
import java.sql.SQLException;
import java.sql.SQLOutput;


public class PublicationUI {

    public static void publicationUI(BufferedReader reader) throws NumberFormatException, IOException, SQLException {


        Integer PID, Edition, StaffID, ArticleID, ChapterID;
        String topic, title, pub_no, PublicationDate, ISBN, Type, IssueDate, Periodicity, Text, Title;

        String[] args;
        boolean exit_val = true;
        String[] main_args = null;
        while (exit_val) {

        System.out.println("1. Enter Book information");
        System.out.println("2. Enter Periodic Publication information");
        System.out.println("3. Update Book information");
        System.out.println("4. Update Periodic Publication information");
        System.out.println("5. Assign Editors to Publication");
        System.out.println("6. View Publication based on Editor(Staff ID)");
        System.out.println("7. Assign Author to Book");
        System.out.println("8. Assign Author to Article");
        System.out.println("9. Insert Articles");
        System.out.println("10. Update Articles");
        System.out.println("11. Delete Articles");
        System.out.println("12. Insert Chapters");
        System.out.println("13. Update Chapters");
        System.out.println("14. Delete Chapters");
        System.out.println("15. Back to Main");

        String input = reader.readLine();

        switch(Integer.parseInt(input)){
            case 1:
                System.out.println("Enter | separated Integer PID,String topic,String title, String pub_no,String PublicationDate,String ISBN, Integer Edition");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                topic = args[1];
                title = args[2];
                pub_no = args[3];
                PublicationDate = args[4];
                ISBN = args[5];
                Edition = Integer.valueOf(Integer.parseInt(args[6]));


//                BookCRUD.insertBook(PID, PublicationDate, ISBN, Edition);
                if (PublicationCRUD.insertPublication(PID, topic, title, pub_no, PublicationDate, ISBN, Edition)) {
                    System.out.println("Operation Successful");
                } else {
                    System.out.println("Operation Failed");
                }
                return;

            case 2:
                System.out.println("Enter | separated Integer PID,String topic,String title, String pub_no, String PPtype,String IssueDate, String Periodicity ");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                topic = args[1];
                title = args[2];
                pub_no = args[3];
                Type = args[4];
                IssueDate = args[5];
                Periodicity = args[6];

                PublicationCRUD.insertPublication(PID, topic, title, pub_no);
                PeriodicPublicationCRUD.insertPeriodicPublication(PID, Type, IssueDate, Periodicity);

                return;

            case 3:
                System.out.println("Enter | separated Integer PID,String topic,String title, String pub_no,String PublicationDate,String ISBN, Integer Edition");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                topic = args[1];
                title = args[2];
                pub_no = args[3];
                PublicationDate = args[4];
                ISBN = args[5];
                Edition = Integer.valueOf(Integer.parseInt(args[6]));

                PublicationCRUD.updatePublication(PID, topic, title, pub_no);
                BookCRUD.updateBook(PID, PublicationDate, ISBN, Edition);
                return;


            case 4:
                System.out.println("Enter | separated Integer PID,String topic,String title, String pub_no, String PPtype,String IssueDate, String Periodicity ");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                topic = args[1];
                title = args[2];
                pub_no = args[3];
                Type = args[4];
                IssueDate = args[5];
                Periodicity = args[6];
                PublicationCRUD.updatePublication(PID, topic, title, pub_no);
                PeriodicPublicationCRUD.updatePeriodicPublication(PID, Type, IssueDate, Periodicity);
                return;

            case 5:
                System.out.println("Enter | separated Integer StaffID and Integer PID");
                args = reader.readLine().split("[|]");
                StaffID = Integer.valueOf(Integer.parseInt(args[0]));
                PID = Integer.valueOf(Integer.parseInt(args[1]));
                if (EditsOperation.insertEdits(StaffID, PID)) {
                    System.out.println("Operation Successful");
                } else {
                    System.out.println("Operation Failed");
                }
                return;

            case 6:
                System.out.println("Enter the Editor's Staff ID:");
                StaffID = Integer.valueOf(Integer.parseInt(reader.readLine()));

                EditsOperation.viewEditorPubInfo(StaffID);

                return;


            case 7:
                System.out.println("Enter | separated Integer StaffID and Integer PID");
                args = reader.readLine().split("[|]");
                StaffID = Integer.valueOf(Integer.parseInt(args[0]));
                PID = Integer.valueOf(Integer.parseInt(args[1]));

                if(WritesBookOperations.insertWritesBook(StaffID, PID)){
                    System.out.println("Operation Sucessful");
                }else{
                    System.out.println("Operation Failed");
                }
                return;

            case 8:
                System.out.println("Enter | separated Integer StaffID, Integer PID and Integer ArticleID");
                args = reader.readLine().split("[|]");
                StaffID = Integer.valueOf(Integer.parseInt(args[0]));
                PID = Integer.valueOf(Integer.parseInt(args[1]));
                ArticleID = Integer.valueOf(Integer.parseInt(args[2]));

                if(WritesArticleOperations.insertWritesArticle(StaffID, PID, ArticleID)){
                    System.out.println("Operation Sucessful");
                }else{
                    System.out.println("Operation Failed");
                }
                return;

            case 9:
                System.out.println("Enter | separated Integer PID,Integer ArticleID,String Text");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                ArticleID = Integer.valueOf(Integer.parseInt(args[1]));
                Text = args[2];
                if (ArticleCRUD.insertArticle(PID, ArticleID, Text)) {
                    System.out.println("Operation Successful");
                } else {
                    System.out.println("Operation Failed");
                }
                return;

            case 10:
                System.out.println("Enter | separated Integer PID,Integer ArticleID,String Text");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                ArticleID = Integer.valueOf(Integer.parseInt(args[1]));
                Text = args[2];
                ArticleCRUD.updateArticle(PID, ArticleID, Text);
                return;

            case 11:
                System.out.println("Enter | separated Integer PID and Integer ArticleID");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                ArticleID = Integer.valueOf(Integer.parseInt(args[1]));

                if (ArticleCRUD.deleteArticle(PID, ArticleID)) {
                    System.out.println("Delete Operation Successful");
                } else {
                    System.out.println("Delete Operation Failed");
                }
                return;

            case 12:
                System.out.println("Enter | separated Integer PID,Integer ChapterID,String Title");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                ChapterID = Integer.valueOf(Integer.parseInt(args[1]));
                Title = args[2];

                if (ChapterCRUD.insertChapter(PID, ChapterID, Title)) {
                    System.out.println(" Operation Successful");
                } else {
                    System.out.println(" Operation Failed");
                }
                return;

            case 13:
                System.out.println("Enter | separated Integer PID,Integer ChapterID,String Title");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                ChapterID = Integer.valueOf(Integer.parseInt(args[1]));
                Title = args[2];
                ChapterCRUD.updateChapter(PID, ChapterID, Title);
                return;

            case 14:
                System.out.println("Enter | separated Integer PID and Integer ChapterID");
                args = reader.readLine().split("[|]");
                PID = Integer.valueOf(Integer.parseInt(args[0]));
                ChapterID = Integer.valueOf(Integer.parseInt(args[1]));
                if (ChapterCRUD.deleteChapter(PID, ChapterID)) {
                    System.out.println("Delete Operation Successful");
                } else {
                    System.out.println("Delete Operation Failed");
                }
                return;
            case 15:
                Main.main(main_args);
            default:
                System.out.println("Enter a valid choice");


        }

        System.out.println("Enter a valid choice");

    }
}
}

