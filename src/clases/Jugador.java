package clases;

public class Jugador {

    private int idJugador;
    private String nombreJugador;
    private String apellidoJugador;
    private long dniJugador;    
    private String domicilioJugador;
    private long telefonoJugador;
    private double estaturaJugador;
    private String posicionJugador;
    private int idUsuario;
    private String estadoJugador;
    
    public Jugador(){
        
    }
    
    @Override
    public String toString(){
        return getApellidoJugador()+", "+getNombreJugador();
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public long getDniJugador() {
        return dniJugador;
    }

    public void setDniJugador(long dniJugador) {
        this.dniJugador = dniJugador;
    }

    public String getDomicilioJugador() {
        return domicilioJugador;
    }

    public void setDomicilioJugador(String domicilioJugador) {
        this.domicilioJugador = domicilioJugador;
    }

    public long getTelefonoJugador() {
        return telefonoJugador;
    }

    public void setTelefonoJugador(long telefonoJugador) {
        this.telefonoJugador = telefonoJugador;
    }

    public double getEstaturaJugador() {
        return estaturaJugador;
    }

    public void setEstaturaJugador(double estaturaJugador) {
        this.estaturaJugador = estaturaJugador;
    }

    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstadoJugador() {
        return estadoJugador;
    }

    public void setEstadoJugador(String estadoJugador) {
        this.estadoJugador = estadoJugador;
    }
    
    
    
}
