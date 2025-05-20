package UI;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

//    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu() {
        // Mensajes de bienvenida e instrucción
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");
        // Variable para almacenar la respuesta del usuario
        int response = 0;
        // do while para mantener corriendo el menu hasta que el usuario digite 0
        do {
            // Imprime las opciones
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            // Lee la entrada del usuario
            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            // Procedimiento de acuerdo a que elija el usuario
            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    // Terminar el programa directamente
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez", "alejandro@mail.com"));
        doctors.add(new Doctor("Karen Sosa", "karen@mail.com"));
        doctors.add(new Doctor("Rocio Gomez", "rocio@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Anahi Salgado", "anahi@mail.com"));
        patients.add(new Patient("Roberto Rodriguez", "roberto@mail.com"));
        patients.add(new Patient("Carlos Sanchez", "carlos@mail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType == 1){
                for (Doctor doctor : doctors) {
                    if (doctor.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Obtener el usuario logeado
                        doctorLogged = doctor;
                        //showDoctorMenu
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }

            if (userType == 2){
                for (Patient patient : patients) {
                    if (patient.getEmail().equals(email)) {
                        emailCorrect = true;
                        //obtener usuario logeado
                        patientLogged = patient;
                        //showPatientMenu
                    }
                }
            }
        }while (!emailCorrect);
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
