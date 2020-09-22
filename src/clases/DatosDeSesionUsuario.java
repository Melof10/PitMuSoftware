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
public class DatosDeSesionUsuario {
    
    private int idDatosDeSesion;
    private String fechaHoraInicioSesion;
    private String fechaHoraCierreSesion;
    private int idUsuario;
    
    public DatosDeSesionUsuario(){
        
    }

    public DatosDeSesionUsuario(int idDatosDeSesion, String fechaHoraInicioSesion, String fechaHoraCierreSesion, int idUsuario) {
        this.idDatosDeSesion = idDatosDeSesion;
        this.fechaHoraInicioSesion = fechaHoraInicioSesion;
        this.fechaHoraCierreSesion = fechaHoraCierreSesion;
        this.idUsuario = idUsuario;
    }

    public int getIdDatosDeSesion() {
        return idDatosDeSesion;
    }

    public void setIdDatosDeSesion(int idDatosDeSesion) {
        this.idDatosDeSesion = idDatosDeSesion;
    }

    public String getFechaHoraInicioSesion() {
        return fechaHoraInicioSesion;
    }

    public void setFechaHoraInicioSesion(String fechaHoraInicioSesion) {
        this.fechaHoraInicioSesion = fechaHoraInicioSesion;
    }

    public String getFechaHoraCierreSesion() {
        return fechaHoraCierreSesion;
    }

    public void setFechaHoraCierreSesion(String fechaHoraCierreSesion) {
        this.fechaHoraCierreSesion = fechaHoraCierreSesion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
