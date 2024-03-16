package app;

import app.config.MYSQLConnection;
import app.controller.AdminController;

import java.sql.Connection;
import java.util.Scanner;
import app.controller.LoginController;
import app.dao.PersonDao;
import app.dto.PersonDto;

public class App {


    private static Scanner reader = new Scanner(System.in);
    private static LoginController loginController = new LoginController();
    private static AdminController adminController = new AdminController();
    public static void main(String[] args) {
        AdminController adminController = new AdminController();


        boolean run = true;
        while (run) {
            try {
                run = runApplication();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("deteniendo la aplicacion");
        }
    }

    public static boolean runApplication() throws Exception {
        String menu = "1. Para iniciar sesion \n2. Para cerrar la aplicacion";
        System.out.println("==========INGRESE=============");
        System.out.println(menu);
        System.out.println("==============================");
        String option = reader.nextLine();

        switch (option) {
            case "1":{
                adminController.createUser();
                break;
            }
            case "2": {
                loginController.login();
                break;
            }
            case "3": {
                break;
            }
            default: {
                System.out.print("ingrese una opcion valida");
                break;
            }
        }
        return false;
    }
}
