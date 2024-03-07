package app;

import app.config.MYSQLConnection;
import app.controller.AdminController;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        AdminController adminController = new AdminController();

        boolean run = true;
        //while (run) {
        try {
            //run = runApplication();
            Connection con = MYSQLConnection.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //}
        System.out.print("deteniendo la aplicacion");
//
        while (true) {
            try {
                adminController.createUser();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        //
    }
}
