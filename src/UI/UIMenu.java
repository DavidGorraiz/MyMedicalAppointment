package UI;

import java.util.Scanner;

public class UIMenu {

//    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    public static void showMenu() {
        // Mensajes de bienvenida e instrucción
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");
        // Variable para almacenar la respuesta del usuario
        int response = 0;
        // do while para mantener corriendo el menu hasta que el usuario digite 0
        do {
            // Imprime las opciones
            System.out.println("1. model.Doctor");
            System.out.println("2. model.Patient");
            System.out.println("0. Salir");

            // Lee la entrada del usuario
            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            // Procedimiento de acuerdo a que elija el usuario
            switch (response) {
                case 1:
                    System.out.println("model.Doctor");
                    break;
                case 2:
                    response = 0;
                    showPatientMenu();
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }
    static void showPatientMenu() {
        // Almacenar la respuesta del usuario
        int response = 0;
        // Mantener corriendo el menu hasta que el paciente digite 0
        do {
            // Imprimir opciones de menu
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment ");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            // Leer la entrada del paciente
            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            // Procedimiento de acuerdo a la respuesta
            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    int count = 1;
                    for (Month month : Month.values()) {
                        System.out.println(count + ". " + month.getSpanish());
                        count++;
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while(response != 0);
    }
}
