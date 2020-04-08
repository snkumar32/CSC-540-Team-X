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
                DistributorUI.distributorUI(br);
            } catch (IOException e) {

            }
        }while(true);
    }


}

