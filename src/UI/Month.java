package UI;

public enum Month {
    JANUARY("Enero"),
    FEBRUARY("Febrero"),
    MARCH("Marzo"),
    APRIL("Abril"),
    MAY("Mayo"),
    JUNE("Junio"),
    JULY("Julio"),
    AUGUST("Agosto"),
    SEPTEMBER("Septiembre"),
    OCTOBER("Octubre"),
    NOVEMBER("Noviembre"),
    DECEMBER("Diciembre");

    private String spanish;
    private Month(String spanish) {
        this.spanish = spanish;
    }
    public String getSpanish() {
        return spanish;
    }
}
