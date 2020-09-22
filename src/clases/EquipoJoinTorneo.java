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
public class EquipoJoinTorneo {
    
    private int idTorneoEquipo;
    private int idEquipo;
    private int idTorneo;
    private String nombreEquipo;
    
    public EquipoJoinTorneo(){
        
    }

    public EquipoJoinTorneo(int idTorneoEquipo, int idEquipo, int idTorneo, String nombreEquipo) {
        this.idTorneoEquipo = idTorneoEquipo;
        this.idEquipo = idEquipo;
        this.idTorneo = idTorneo;
        this.nombreEquipo = nombreEquipo;
    }

    public int getIdTorneoEquipo() {
        return idTorneoEquipo;
    }

    public void setIdTorneoEquipo(int idTorneoEquipo) {
        this.idTorneoEquipo = idTorneoEquipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    
}
