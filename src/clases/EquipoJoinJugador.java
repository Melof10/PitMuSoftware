package clases;

public class EquipoJoinJugador {

    private int idEquipoJoinJugador;
    private int idEquipo;
    private int idJugador;
    private String estadoEquipoJoinJugador;
    
    public EquipoJoinJugador(){
        
    }    

    public int getIdEquipoJoinJugador() {
        return idEquipoJoinJugador;
    }

    public void setIdEquipoJoinJugador(int idEquipoJoinJugador) {
        this.idEquipoJoinJugador = idEquipoJoinJugador;
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

    public String getEstadoEquipoJoinJugador() {
        return estadoEquipoJoinJugador;
    }

    public void setEstadoEquipoJoinJugador(String estadoEquipoJoinJugador) {
        this.estadoEquipoJoinJugador = estadoEquipoJoinJugador;
    }
        
}
