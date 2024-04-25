import java.time.LocalDateTime;

public class Historial {

    private String historial;
    private LocalDateTime tiempo;

    public void Historial (String historial, LocalDateTime tiempo) {
        this.historial = historial;
        this.tiempo = tiempo;
    }

    public String getHistorial() {
        return historial;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }
}
