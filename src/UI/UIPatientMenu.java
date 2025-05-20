package UI;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMenu.patientLogged);
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println(":: Select date");
            //Numeración de la lista de fechas
            //Indice de fecha seleccionada
            //[doctors]
            // 1.- doctor1
                // - 1 fecha1
                // - 2 fecha2
            // 2.- doctor2
            // 3.- doctor3
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointment.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointment.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(j,UIDoctorMenu.doctorsAvailableAppointment.get(i));
                    doctors.put(k, doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = sc.nextInt();
            Map<Integer, Doctor> doctorsAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer, Doctor> doc : doctorsAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. Yes\n2. Change Data");
            response = sc.nextInt();

            if (response == 1) {
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                );

                showBookAppointmentMenu();
            }

        }while (response != 0);
    }
    private static void showPatientMyAppointments() {
        int response = 0;
        do {
            System.out.println(":: My Appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().isEmpty()){
                System.out.println("Don´t have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(j).getDate() +
                        "Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(j).getTime() +
                        "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(j).getDoctor().getName());
            }

            System.out.println("0. Return");
        }while (response != 0);
    }
}
