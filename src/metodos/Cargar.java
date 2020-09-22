package metodos;

import clases.DatosDeSesionUsuario;
import clases.Equipo;
import clases.GoleadorJoinEquipo;
import clases.Jugador;
import clases.Partidos;
import clases.PosicionesJoinEquipo;
import clases.Torneo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cargar {
          
    public JTable cargarJugador(JTable tabla, Jugador [] miJugador, String [] titulos){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(titulos);
        
        tabla.setModel(objTable);
        
        String datosJugador [] = new String[titulos.length];
        
        for(int i = 0; i < miJugador.length; i++){                      
            datosJugador[0] = String.valueOf(miJugador[i].getIdJugador());
            datosJugador[1] = miJugador[i].getNombreJugador();            
            datosJugador[2] = miJugador[i].getApellidoJugador();            
            datosJugador[3] = String.valueOf(miJugador[i].getDniJugador());            
            datosJugador[4] = miJugador[i].getDomicilioJugador();
            datosJugador[5] = String.valueOf(miJugador[i].getTelefonoJugador());
            datosJugador[6] = String.valueOf(miJugador[i].getEstaturaJugador());
            datosJugador[7] = miJugador[i].getPosicionJugador();
            
            objTable.addRow(datosJugador);
        }
        
        return tabla;       
    }
    
    public JTable cargarEquipos(JTable tabla, Equipo miEquipo [], String [] titulos){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(titulos);
        
        tabla.setModel(objTable);
        
        String datosEquipo [] = new String[titulos.length];
        
        for(int i = 0; i < miEquipo.length; i++){                      
            datosEquipo[0] = String.valueOf(miEquipo[i].getIdEquipo());
            datosEquipo[1] = miEquipo[i].getNombreEquipo();            
            datosEquipo[2] = miEquipo[i].getNombreEstadioEquipo();
            datosEquipo[3] = miEquipo[i].getDireccionEstadioEquipo();            
            
            objTable.addRow(datosEquipo);
        }
        
        return tabla;       
    }
    
    public JTable cargarEquiposDinamicamente(JTable tabla, Equipo miEquipo [], String [] titulos){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(titulos);
        
        tabla.setModel(objTable);
        
        String datosEquipo [] = new String[titulos.length];
        
        for(int i = 0; i < miEquipo.length; i++){                      
            datosEquipo[0] = String.valueOf(miEquipo[i].getIdEquipo());
            datosEquipo[1] = miEquipo[i].getNombreEquipo();            
            datosEquipo[2] = miEquipo[i].getNombreEstadioEquipo();
            datosEquipo[3] = miEquipo[i].getDireccionEstadioEquipo();            
            
            objTable.addRow(datosEquipo);
        }
        
        return tabla;       
    }                
    
    public JTable cargarTorneos(JTable tabla, Torneo miTorneo [], String [] titulos){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(titulos);
        
        tabla.setModel(objTable);
        
        String torneos [] = new String[titulos.length];
        
        for(int i = 0; i < miTorneo.length; i++){                      
            torneos[0] = String.valueOf(miTorneo[i].getIdTorneo());
            torneos[1] = miTorneo[i].getNombreTorneo();            
            torneos[2] = String.valueOf(miTorneo[i].getCantidadEquipos());
            torneos[3] = String.valueOf(miTorneo[i].getCantidadFechas());
            torneos[4] = miTorneo[i].getFormatoTorneo();            
            
            objTable.addRow(torneos);
        }
        
        return tabla;       
    }  
    
    public JTable cargarTorneosDinamicamente(JTable tabla, Torneo miTorneo [], String [] titulos){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(titulos);
        
        tabla.setModel(objTable);
        
        String torneos [] = new String[titulos.length];
        
        for(int i = 0; i < miTorneo.length; i++){                      
            torneos[0] = String.valueOf(miTorneo[i].getIdTorneo());
            torneos[1] = miTorneo[i].getNombreTorneo();            
            torneos[2] = String.valueOf(miTorneo[i].getCantidadEquipos());
            torneos[3] = String.valueOf(miTorneo[i].getCantidadFechas());
            torneos[4] = miTorneo[i].getFormatoTorneo();            
            
            objTable.addRow(torneos);
        }
        
        return tabla;       
    }  
    
    public JTable cargarPartidosPorFecha(JTable tabla, Partidos miPartido [], String [] titulos, String equipoLocal[], String equipoVisitante[]){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(titulos);  

        tabla.setModel(objTable);
        
        String partido [] = new String[titulos.length];
        
        for(int i = 0; i < miPartido.length; i++){                      
            partido[0] = String.valueOf(miPartido[i].getIdPartido()); 
            
            if(miPartido[i].getFechaPartido() != null){
                partido[1] = miPartido[i].getFechaPartido();
            }else{
                partido[1] = "";
            }
            
            if(miPartido[i].getHoraPartido() != null){
                partido[2] = miPartido[i].getHoraPartido();
            }else{
                partido[2] = "";
            }
            
            partido[3] = miPartido[i].getNombreEstadio();
            partido[4] = equipoLocal[i];
            partido[5] = String.valueOf(miPartido[i].getIdEquipoLocal());
            
            if(miPartido[i].getGolesEquipoLocal() >= 0){                                
                partido[6] = String.valueOf(miPartido[i].getGolesEquipoLocal());                                
            }else if(miPartido[i].getGolesEquipoLocal() < 0){                
                partido[6] = "";                
            }
            
            if(miPartido[i].getGolesEquipoVisitante() >= 0){
                partido[7] = String.valueOf(miPartido[i].getGolesEquipoVisitante());                
            }else if(miPartido[i].getGolesEquipoVisitante() < 0){
                partido[7] = "";
            }
            
            partido[8] = equipoVisitante[i];
            partido[9] = String.valueOf(miPartido[i].getIdEquipoVisitante());
            
            objTable.addRow(partido);
        }
        
        return tabla;       
    }  
    
    public JTable cargarNombrePartidosPorFecha(JTable tabla, String equipoLocal[], String equipoVisitante[], String [] titulos){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(titulos);  

        tabla.setModel(objTable);
        
        String partido [] = new String[titulos.length];
        
        for(int i = 0; i < equipoLocal.length; i++){                      
            partido[1] = String.valueOf(equipoLocal[i]);                      
            partido[5] = String.valueOf(equipoVisitante[i]);            
            
            objTable.addRow(partido);
        }
        
        return tabla;       
    }  
    
    public DefaultComboBoxModel cargarFechasTorneo(Partidos [] miFechasTorneos){
        
        DefaultComboBoxModel miObjCombo = new DefaultComboBoxModel();
        
        for(int i = 0; i < miFechasTorneos.length; i++){                   
            miObjCombo.addElement(miFechasTorneos[i]);
        }
        
        return miObjCombo;        
    }
    
    public DefaultComboBoxModel cargarJugadorTorneo(Jugador [] miJugador){
        
        DefaultComboBoxModel miObjTable = new DefaultComboBoxModel();  
        
        for(int i = 0; i < miJugador.length; i++){
            miObjTable.addElement(miJugador[i]);
        }
        
        return miObjTable;       
    }
    
    public JTable cargarDatosSesion(JTable tabla, DatosDeSesionUsuario [] datosSesion, String [] titulos){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(titulos);  

        tabla.setModel(objTable);
        
        String datosSesionUsuario [] = new String[titulos.length];
        
        for(int i = 0; i < datosSesion.length; i++){                      
            datosSesionUsuario[0] = datosSesion[i].getFechaHoraInicioSesion()+" Hrs.";
            datosSesionUsuario[1] = datosSesion[i].getFechaHoraCierreSesion()+" Hrs.";            
            
            objTable.addRow(datosSesionUsuario);
        }
        
        return tabla;       
    }     
    
    public JTable cargarTablaPosiciones(JTable tabla, PosicionesJoinEquipo [] miPosicionesJoinEquipo, String [] tituloTablaPosiciones){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(tituloTablaPosiciones);  

        tabla.setModel(objTable);
        
        String posiciones [] = new String[tituloTablaPosiciones.length];
        
        for(int i = 0; i < miPosicionesJoinEquipo.length; i++){                      
            posiciones[0] = miPosicionesJoinEquipo[i].getNombreEquipo();
            posiciones[1] = String.valueOf(miPosicionesJoinEquipo[i].getPartidosJugados());
            posiciones[2] = String.valueOf(miPosicionesJoinEquipo[i].getPartidosGanados());
            posiciones[3] = String.valueOf(miPosicionesJoinEquipo[i].getPartidosEmpatados());
            posiciones[4] = String.valueOf(miPosicionesJoinEquipo[i].getPartidosPerdidos());
            posiciones[5] = String.valueOf(miPosicionesJoinEquipo[i].getGolesFavor());
            posiciones[6] = String.valueOf(miPosicionesJoinEquipo[i].getGolesContra());
            posiciones[7] = String.valueOf(miPosicionesJoinEquipo[i].getDiferenciaGoles());
            posiciones[8] = String.valueOf(miPosicionesJoinEquipo[i].getPuntos());
                        
            objTable.addRow(posiciones);
        }
        
        return tabla;       
    } 
    
    public JTable cargarTablaGoleadores(JTable tabla, GoleadorJoinEquipo [] miGoleadorJoinEquipo, String [] tituloTablaGoleadores){
        
        DefaultTableModel objTable = new DefaultTableModel();  
        
        objTable.setColumnCount(0);
        objTable.setRowCount(0);
        objTable.setColumnIdentifiers(tituloTablaGoleadores);  

        tabla.setModel(objTable);
        
        String posiciones [] = new String[tituloTablaGoleadores.length];
        
        for(int i = 0; i < miGoleadorJoinEquipo.length; i++){                      
            posiciones[0] = String.valueOf(miGoleadorJoinEquipo[i].getIdJugador());
            posiciones[1] = miGoleadorJoinEquipo[i].getApellidoJugador()+", "+miGoleadorJoinEquipo[i].getNombreJugador();
            posiciones[2] = miGoleadorJoinEquipo[i].getNombreEquipo();
            posiciones[3] = String.valueOf(miGoleadorJoinEquipo[i].getGolesJugador());
                        
            objTable.addRow(posiciones);
        }
        
        return tabla;       
    }
    
}


