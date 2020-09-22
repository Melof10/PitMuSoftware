package metodos;

import clases.Equipo;
import clases.EquipoJoinJugador;
import clases.GoleadorPartido;
import clases.Goleadores;
import clases.Jugador;
import clases.Posiciones;
import clases.Torneo;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Guardar {        
    
    public void guardarJugador(Jugador miJugador){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO jugador VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setString(1, miJugador.getNombreJugador());
            miConectar.psPrepararSentencias.setString(2, miJugador.getApellidoJugador());
            miConectar.psPrepararSentencias.setLong(3, miJugador.getDniJugador());                          
            miConectar.psPrepararSentencias.setString(4, miJugador.getDomicilioJugador());
            miConectar.psPrepararSentencias.setLong(5, miJugador.getTelefonoJugador());
            miConectar.psPrepararSentencias.setDouble(6, miJugador.getEstaturaJugador());
            miConectar.psPrepararSentencias.setString(7, miJugador.getPosicionJugador());
            miConectar.psPrepararSentencias.setInt(8, miJugador.getIdUsuario());            
            miConectar.psPrepararSentencias.setString(9, miJugador.getEstadoJugador());          
            miConectar.psPrepararSentencias.executeUpdate();                                                                    
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void guardarEquipo(Equipo miEquipo){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO equipo VALUES(null, ?, ?, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setString(1, miEquipo.getNombreEquipo());
            miConectar.psPrepararSentencias.setString(2, miEquipo.getNombreEstadioEquipo());
            miConectar.psPrepararSentencias.setString(3, miEquipo.getDireccionEstadioEquipo());            
            miConectar.psPrepararSentencias.setInt(4, miEquipo.getIdUsuario());
            miConectar.psPrepararSentencias.setString(5, miEquipo.getEstadoEquipo());            
            miConectar.psPrepararSentencias.executeUpdate();               
            
            new alertas.AlertSuccess(new javax.swing.JDialog(), true, "El equipo se ha registrado").setVisible(true);                                                                   
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void guardarEquipoJoinJugador(EquipoJoinJugador miEquipoJoinJugador){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO equiporelacionjugador VALUES(null, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setInt(1, miEquipoJoinJugador.getIdEquipo());
            miConectar.psPrepararSentencias.setInt(2, miEquipoJoinJugador.getIdJugador());                       
            miConectar.psPrepararSentencias.setString(3, "alta");                       
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void guardarTorneo(Torneo miTorneo){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO torneo VALUES(null, ?, ?, ?, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setString(1, miTorneo.getNombreTorneo());
            miConectar.psPrepararSentencias.setInt(2, miTorneo.getCantidadEquipos());                       
            miConectar.psPrepararSentencias.setInt(3, miTorneo.getCantidadFechas());                       
            miConectar.psPrepararSentencias.setString(4, miTorneo.getFormatoTorneo());                       
            miConectar.psPrepararSentencias.setString(5, miTorneo.getEstadoTorneo());                       
            miConectar.psPrepararSentencias.setInt(6, miTorneo.getIdUsuario());                       
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void guardarTorneoEquipo(int idTorneo, Equipo miEquipo){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO torneoEquipo VALUES(null, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setInt(1, idTorneo);
            miConectar.psPrepararSentencias.setInt(2, miEquipo.getIdEquipo());                                   
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void guardarPartidosLiga(int idTorneo, int numeroDeFecha, Equipo miEquipoLocal, Equipo miEquipoVisitante){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO partidos VALUES(null, ?, ?, ?, ?, null, null, null, null)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setInt(1, idTorneo);
            miConectar.psPrepararSentencias.setInt(2, numeroDeFecha);                                   
            miConectar.psPrepararSentencias.setInt(3, miEquipoLocal.getIdEquipo());
            miConectar.psPrepararSentencias.setInt(4, miEquipoVisitante.getIdEquipo());
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }        
    
    public void guardarDatosDeSesion(int idUsuario, String FechaHoraInicioSesion, String FechaHoraCierreSesion){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO datosiniciosesion VALUES(null, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setString(1, FechaHoraInicioSesion);
            miConectar.psPrepararSentencias.setString(2, FechaHoraCierreSesion);
            miConectar.psPrepararSentencias.setInt(3, idUsuario);                                   
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }   
    
    public void guardarTablaPosiciones(int idEquipo, int idTorneo, Posiciones miPosiciones){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO posiciones VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setInt(1, idTorneo);
            miConectar.psPrepararSentencias.setInt(2, idEquipo);
            miConectar.psPrepararSentencias.setInt(3, miPosiciones.getPartidosJugados());                                   
            miConectar.psPrepararSentencias.setInt(4, miPosiciones.getPartidosGanados());                                   
            miConectar.psPrepararSentencias.setInt(5, miPosiciones.getPartidosEmpatados());
            miConectar.psPrepararSentencias.setInt(6, miPosiciones.getPartidosPerdidos());
            miConectar.psPrepararSentencias.setInt(7, miPosiciones.getGolesFavor());
            miConectar.psPrepararSentencias.setInt(8, miPosiciones.getGolesContra());
            miConectar.psPrepararSentencias.setInt(9, miPosiciones.getDiferenciaGoles());
            miConectar.psPrepararSentencias.setInt(10, miPosiciones.getPuntos());
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void guardarJugadorGoleador(int idEquipo, int idTorneo, Goleadores miGoleadores){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO goleadores VALUES(null, ?, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setInt(1, idTorneo);
            miConectar.psPrepararSentencias.setInt(2, idEquipo);            
            miConectar.psPrepararSentencias.setInt(3, miGoleadores.getIdGoleador());                                   
            miConectar.psPrepararSentencias.setInt(4, miGoleadores.getGolesJugador());                                                                                                           
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }        
    
    public void guardarGoleadorPartido(GoleadorPartido miGoleadorPartido){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO goleadorpartido VALUES(null, ?, ?, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setInt(1, miGoleadorPartido.getIdPartido());
            miConectar.psPrepararSentencias.setInt(2, miGoleadorPartido.getIdTorneo());            
            miConectar.psPrepararSentencias.setInt(3, miGoleadorPartido.getIdEquipo());                                   
            miConectar.psPrepararSentencias.setInt(4, miGoleadorPartido.getIdJugador());                                                                                                           
            miConectar.psPrepararSentencias.setInt(5, miGoleadorPartido.getCantidadGoles());                                                 
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
        
    public void guardarCampeonTorneo(int idTorneo, int idEquipo, int cantidadPuntos){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO campeontorneo VALUES(null, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setInt(1, idTorneo);
            miConectar.psPrepararSentencias.setInt(2, cantidadPuntos);            
            miConectar.psPrepararSentencias.setInt(3, idEquipo);                                               
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void guardarGoleadorTorneo(int idJugador, int cantidadGoles, int idTorneo){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "INSERT INTO goleadortorneo VALUES(null, ?, ?, ?)";
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setInt(1, idJugador);
            miConectar.psPrepararSentencias.setInt(2, cantidadGoles);            
            miConectar.psPrepararSentencias.setInt(3, idTorneo);                                               
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
}
