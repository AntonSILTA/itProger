package com.itProger;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        System.out.print("Incert title: ");
//        String t = input.nextLine();
//        System.out.print("Incert text: ");
//        String tx = input.nextLine();
//        System.out.print("Incert date (yyyy-dd-mm): ");
//        String d = input.nextLine();
//        System.out.print("Incert author: ");
//        String av = input.nextLine();

        DB db = new DB();

        try {
            db.deleteSomething();
//            db.incertArticle(t, tx, d, av);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // write your code here
    }
}
