package UI;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointment;

    public static void showDoctorMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My schedule appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void showAddAvailableAppointmentMenu() {
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");
            for (Month month : Month.values()) {
                System.out.println(month.getNumber() + ". " + month.getSpanish());
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            if (response > 0 && response <= 12) {
                //1,2,3,4,5,6,7,8,9,10,11,12
                int monthSelected = response;
                for (Month month : Month.values()) {
                    if (month.getNumber() == monthSelected) {
                        System.out.println(monthSelected + ". " + month.getSpanish());
                        break;
                    }
                }

                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is " + date + "\n1. Correct \n2. Change date");
                int responseDate = sc.nextInt();
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is " + time + "\n1. Correct \n2. Change time");
                    responseTime = sc.nextInt();

                }while (responseTime == 2);

                UIMenu.doctorLogged.addAvailableAppointment(date,time);
                checkDoctorAvailableAppointment(UIMenu.doctorLogged);

            }else if (response == 0){
                showDoctorMenu();
            }
        }while (response != 0);
    }

    private static void checkDoctorAvailableAppointment(Doctor doctor) {
        if (doctor.getAvailableAppointments().size() > 0
            && !doctorsAvailableAppointment.contains(doctor)) {
            doctorsAvailableAppointment.add(doctor);
        }
    }
}
