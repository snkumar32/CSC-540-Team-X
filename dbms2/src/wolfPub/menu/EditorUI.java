package wolfPub.menu;

import wolfPub.crud.ArticleCRUD;
import wolfPub.crud.ChapterCRUD;
import wolfPub.crud.EditsOperation;
import wolfPub.crud.PublicationCRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

public class EditorUI {
    public static void editorUI(BufferedReader reader) throws NumberFormatException, IOException, SQLException {

        String[] main_args = null;
        boolean exit_val = true;
        while (exit_val) {
            System.out.println("EDITOR");
            System.out.println("1. View Publication");
            System.out.println("2. Add Article - Periodic Publication");
            System.out.println("3. Update Article - Periodic Publication");
            System.out.println("3. Delete Article  - Periodic Publication");
            System.out.println("4. Add Chapter - Book");
            System.out.println("5. Update Chapter - Book");
            System.out.println("5. Delete Chapter - Book");
            System.out.println("6. Back to Main Menu");

            String input = reader.readLine();
            String[] str = null;
            String args;
            Integer PID,ArticleID, ChapterID;
            String Text, Title;

            switch (Integer.parseInt(input)) {
                case 1:
                    System.out.println("Enter Staff ID");
                    args = reader.readLine();
                    EditsOperation.viewEditorPubInfo(Integer.parseInt(args));
                    break;
                case 2:
                    System.out.println("Enter | separated Integer PID,Integer ArticleID,String Text");
                    str = reader.readLine().split("[|]");
                    PID = Integer.parseInt(str[0]);
                    ArticleID = Integer.parseInt(str[1]);
                    Text = str[2];
                    ArticleCRUD.insertArticle(PID,ArticleID,Text);
                    break;
                case 3:
                    System.out.println("Enter | separated Integer PID,Integer ArticleID,String Text");
                    str = reader.readLine().split("[|]");
                    PID = Integer.parseInt(str[0]);
                    ArticleID = Integer.parseInt(str[1]);
                    Text = str[2];
                    if (ArticleCRUD.updateArticle(PID,ArticleID,Text)) {
                        System.out.println(" Operation Successful");
                    } else {
                        System.out.println(" Operation Failed");
                    }

                    break;
                case 4:
                    System.out.println("Enter | separated Integer PID,Integer ArticleID");
                    str = reader.readLine().split("[|]");
                    PID = Integer.parseInt(str[0]);
                    ArticleID = Integer.parseInt(str[1]);
                    ArticleCRUD.deleteArticle(PID,ArticleID);
                    break;
                case 5:
                    System.out.println("Enter | separated Integer PID,Integer ChapterID,String Title");
                    str = reader.readLine().split("[|]");
                    PID = Integer.valueOf(Integer.parseInt(str[0]));
                    ChapterID = Integer.valueOf(Integer.parseInt(str[1]));
                    Title = str[2];
                    ChapterCRUD.insertChapter(PID, ChapterID, Title);
                    return;

                case 6:
                    System.out.println("Enter | separated Integer PID,Integer ChapterID,String Title");
                    str = reader.readLine().split("[|]");
                    PID = Integer.valueOf(Integer.parseInt(str[0]));
                    ChapterID = Integer.valueOf(Integer.parseInt(str[1]));
                    Title = str[2];
                    if (ChapterCRUD.updateChapter(PID, ChapterID, Title)) {
                        System.out.println(" Operation Successful");
                    } else {
                        System.out.println(" Operation Failed");
                    }
                    //ChapterCRUD.updateChapter(PID, ChapterID, Title);
                    return;

                case 7:
                    System.out.println("Enter | separated Integer PID and Integer ChapterID");
                    str = reader.readLine().split("[|]");
                    PID = Integer.valueOf(Integer.parseInt(str[0]));
                    ChapterID = Integer.valueOf(Integer.parseInt(str[1]));
                    ChapterCRUD.deleteChapter(PID, ChapterID);
                    return;
                case 8:
                    Main.main(str);
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
