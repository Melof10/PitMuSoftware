package clases;

public class GoleadorPartido {

    private int idGoleadorPartido;
    private int idPartido;
    private int idTorneo;
    private int idEquipo;
    private int idJugador;
    private int cantidadGoles;
    
    public GoleadorPartido(){
        
    }

    public GoleadorPartido(int idGoleadorPartido, int idPartido, int idTorneo, int idEquipo, int idJugador, int cantidadGoles) {
        this.idGoleadorPartido = idGoleadorPartido;
        this.idPartido = idPartido;
        this.idTorneo = idTorneo;
        this.idEquipo = idEquipo;
        this.idJugador = idJugador;
        this.cantidadGoles = cantidadGoles;
    }

    public int getIdGoleadorPartido() {
        return idGoleadorPartido;
    }

    public void setIdGoleadorPartido(int idGoleadorPartido) {
        this.idGoleadorPartido = idGoleadorPartido;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }
    
}
