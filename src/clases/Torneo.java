/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Federico
 */
public class Torneo {
    
    private int idTorneo;
    private String nombreTorneo;
    private int cantidadEquipos;
    private int cantidadFechas;    
    private String formatoTorneo;
    private String estadoTorneo;
    private int idUsuario;

    public Torneo(){
        
    }        

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }    

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public int getCantidadFechas() {
        return cantidadFechas;
    }

    public void setCantidadFechas(int cantidadFechas) {
        this.cantidadFechas = cantidadFechas;
    }

    public String getFormatoTorneo() {
        return formatoTorneo;
    }

    public void setFormatoTorneo(String formatoTorneo) {
        this.formatoTorneo = formatoTorneo;
    }

    public String getEstadoTorneo() {
        return estadoTorneo;
    }

    public void setEstadoTorneo(String estadoTorneo) {
        this.estadoTorneo = estadoTorneo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
