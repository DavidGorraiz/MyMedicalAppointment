package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    // Atributos
    private String speciality;
    // Crea Lista de objetos tipo availableAppointment
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    //  Constructor sin argumentos
    public Doctor(){
        System.out.println("Construyendo el objeto model.Doctor");
    }

    // Constructor con argumentos
    public Doctor(String name, String email){
        super(name, email);
    }

    // Comportamientos
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    // Metodo que permite añadir una nueva cita para el doctor
    public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    // Devuelve la lista de citas del doctor
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "Speciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerología");
    }

    // Clase anidada static que representa las citas del doctor
    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public String getDateString() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "AvailableAppointment{" +
                    "id=" + id +
                    ", date=" + date +
                    ", time='" + time + '\'' +
                    '}';
        }
    }

}
