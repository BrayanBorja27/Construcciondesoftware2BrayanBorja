package app;

import app.controller.AdminController;

public class App {
    public static void main(String[] args) {
        AdminController adminController = new AdminController();
        while (true) {
            try {
                adminController.createUser();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
