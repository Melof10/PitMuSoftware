package clases;

public class Goleadores {

    private int idGoleador;
    private int idTorneo;
    private int idEquipo;
    private int idJugador;
    private int golesJugador;
    
    public Goleadores(){
        
    }

    public Goleadores(int idGoleador, int idTorneo, int idEquipo, int idJugador, int golesJugador) {
        this.idGoleador = idGoleador;
        this.idTorneo = idTorneo;
        this.idEquipo = idEquipo;
        this.idJugador = idJugador;
        this.golesJugador = golesJugador;
    }

    public int getIdGoleador() {
        return idGoleador;
    }

    public void setIdGoleador(int idGoleador) {
        this.idGoleador = idGoleador;
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

    public int getGolesJugador() {
        return golesJugador;
    }

    public void setGolesJugador(int golesJugador) {
        this.golesJugador = golesJugador;
    }
    
}
