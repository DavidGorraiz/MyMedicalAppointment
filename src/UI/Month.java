package UI;

public enum Month {
    JANUARY("Enero", 1),
    FEBRUARY("Febrero", 2),
    MARCH("Marzo", 3),
    APRIL("Abril", 4),
    MAY("Mayo", 5),
    JUNE("Junio", 6),
    JULY("Julio", 7),
    AUGUST("Agosto", 8),
    SEPTEMBER("Septiembre", 9),
    OCTOBER("Octubre", 10),
    NOVEMBER("Noviembre", 11),
    DECEMBER("Diciembre", 12);

    private String spanish;
    private int number;
    private Month(String spanish, int number) {
        this.spanish = spanish;
        this.number = number;
    }
    public String getSpanish() {
        return spanish;
    }
    public int getNumber() {
        return number;
    }
}
