package clases;

public class GoleadorJoinEquipo {
        
    private int idJugador;
    private int golesJugador;
    private String nombreJugador;
    private String apellidoJugador;
    private String nombreEquipo;
    
    public GoleadorJoinEquipo(){
        
    }

    public GoleadorJoinEquipo(int idJugador, int golesJugador,String apellidoJugador, String nombreJugador, String nombreEquipo) {
        this.idJugador = idJugador;
        this.golesJugador = golesJugador;
        this.apellidoJugador = apellidoJugador;
        this.nombreJugador = nombreJugador;
        this.nombreEquipo = nombreEquipo;
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

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }
    
}
