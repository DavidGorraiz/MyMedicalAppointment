package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    // Atributos
    private String speciality;

    //  Constructor sin argumentos
    public Doctor(){
        System.out.println("Construyendo el objeto model.Doctor");
    }

    // Constructor con argumentos
    public Doctor(String name, String email){
        super(name, email);
        System.out.println("El nombre del model.Doctor asignado es: " + name);
        this.speciality = speciality;
    }

    // Comportamientos
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // Crea Lista de objetos tipo availableAppointment
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    // Metodo que permite añadir una nueva cita para el doctor
    public void addAvailableAppointment(Date date, String time){
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

    // Clase anidada static que representa las citas del doctor
    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time){
           this.date = date;
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
