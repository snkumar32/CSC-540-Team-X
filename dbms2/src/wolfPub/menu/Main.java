package wolfPub.menu;

import wolfPub.connection.DbConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        do {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                ReportUI.reportUI(br);
            } catch (IOException e) {
        //28|2020-03-03|2020-03-01|30.0|150.0|450.0
            }
        }while(true);
    }


}

