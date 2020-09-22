package clases;

public class Equipo {

    private int idEquipo;
    private String nombreEquipo;
    private String nombreEstadioEquipo;
    private String direccionEstadioEquipo;
    private int idUsuario;
    private String estadoEquipo;
    
    public Equipo(){
        
    }        
    
    @Override
    public String toString(){
        return getNombreEquipo();
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEstadioEquipo() {
        return nombreEstadioEquipo;
    }

    public void setNombreEstadioEquipo(String nombreEstadioEquipo) {
        this.nombreEstadioEquipo = nombreEstadioEquipo;
    }

    public String getDireccionEstadioEquipo() {
        return direccionEstadioEquipo;
    }

    public void setDireccionEstadioEquipo(String direccionEstadioEquipo) {
        this.direccionEstadioEquipo = direccionEstadioEquipo;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
