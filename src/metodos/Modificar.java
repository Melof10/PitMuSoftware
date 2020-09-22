package metodos;

import clases.Equipo;
import clases.Jugador;
import clases.Partidos;
import clases.Posiciones;
import clases.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Modificar {
    
    public void modificarJugador(Jugador miJugador) {

        try {
            Conectar miConectar = new Conectar();
            String insert = "UPDATE jugador SET nombreJugador = ?, apellidoJugador = ?, dniJugador = ?, domicilioJugador = ?, telefonoJugador = ?, estaturaJugador = ?, posicionJugador = ? WHERE idJugador = ?";                          
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setString(1, miJugador.getNombreJugador());
            miConectar.psPrepararSentencias.setString(2, miJugador.getApellidoJugador());
            miConectar.psPrepararSentencias.setLong(3, miJugador.getDniJugador());            
            miConectar.psPrepararSentencias.setString(4, miJugador.getDomicilioJugador());
            miConectar.psPrepararSentencias.setLong(5, miJugador.getTelefonoJugador());            
            miConectar.psPrepararSentencias.setDouble(6, miJugador.getEstaturaJugador());            
            miConectar.psPrepararSentencias.setString(7, miJugador.getPosicionJugador());            
            miConectar.psPrepararSentencias.setInt(8, miJugador.getIdJugador());
            miConectar.psPrepararSentencias.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
    
    public void modificarEquipo(Equipo miEquipo) {

        try {
            Conectar miConectar = new Conectar();
            String insert = "UPDATE equipo SET nombreEquipo = ?, nombreEstadio = ?, direccionEstadio = ? WHERE idUsuario = "+miEquipo.getIdUsuario()+" AND idEquipo = "+miEquipo.getIdEquipo();                          
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setString(1, miEquipo.getNombreEquipo());
            miConectar.psPrepararSentencias.setString(2, miEquipo.getNombreEstadioEquipo());
            miConectar.psPrepararSentencias.setString(3, miEquipo.getDireccionEstadioEquipo());                        
            miConectar.psPrepararSentencias.executeUpdate();            

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
    
    public void darBajaEquipo(int idEquipo, int idUsuario) {

        try {            
            Conectar miConectar = new Conectar();
            String insert = "UPDATE equipo SET estadoEquipo = 'baja' WHERE idUsuario = "+idUsuario+" AND idEquipo = "+idEquipo;                          
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);            
            miConectar.psPrepararSentencias.executeUpdate();

            new alertas.AlertSuccess(new javax.swing.JDialog(), true, "El equipo se ha dado de baja").setVisible(true);                                                                               

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
    
    public void darBajaJugador(int idJugador, int idUsuario) {

        try {            
            Conectar miConectar = new Conectar();
            String insert = "UPDATE jugador SET estadoJugador = 'baja' WHERE idJugador = ? AND idUsuario = "+idUsuario;                          
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);                        
            miConectar.psPrepararSentencias.setInt(1, idJugador);
            miConectar.psPrepararSentencias.executeUpdate();

            new alertas.AlertSuccess(new javax.swing.JDialog(), true, "El jugador se dió de baja correctamente").setVisible(true);            

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
    
    public void modificarPerfilUsuario(Usuario miUsuario, int idUsuario){
        
        try {
            Conectar miConectar = new Conectar();
            String insert = "UPDATE usuariosistema SET nombreUsuario = ?, apellidoUsuario = ?, username = ?, "
                          + "emailUsuario = ?, telefonoUsuario = ? "
                          + "WHERE idUsuario = "+idUsuario;                           
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setString(1, miUsuario.getNombreUsuario());
            miConectar.psPrepararSentencias.setString(2, miUsuario.getApellidoUsuario());
            miConectar.psPrepararSentencias.setString(3, miUsuario.getUsername());
            miConectar.psPrepararSentencias.setString(4, miUsuario.getEmail());
            miConectar.psPrepararSentencias.setString(5, miUsuario.getTelefono());                                                                      
            miConectar.psPrepararSentencias.executeUpdate();

            new alertas.AlertSuccess(new javax.swing.JDialog(), true, "El Usuario se ha modificado").setVisible(true);                                                                                           

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void modificarContraseñaUsuario(Usuario miUsuario){
        
        try {
            Conectar miConectar = new Conectar();
            String insert = "UPDATE usuariosistema SET password = ? WHERE idUsuario = "+miUsuario.getIdUsuario();                          
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);
            miConectar.psPrepararSentencias.setString(1, miUsuario.getPassword());
            miConectar.psPrepararSentencias.executeUpdate();

            new alertas.AlertSuccess(new javax.swing.JDialog(), true, "La contraseña se cambió correctamente").setVisible(true);                                                        

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void modificarTablaPosiciones(int idTorneo, Posiciones miPosiciones){
        
        try {
            Conectar miConectar = new Conectar();
            String insert = "UPDATE posiciones SET partidosJugados = "+miPosiciones.getPartidosJugados()+", partidosGanados = "+miPosiciones.getPartidosGanados()+", partidosEmpatados = "+miPosiciones.getPartidosEmpatados()+", partidosPerdidos = "+miPosiciones.getPartidosPerdidos()+", golesFavor = "+miPosiciones.getGolesFavor()+", golesContra = "+miPosiciones.getGolesContra()+", diferenciaGoles = "+miPosiciones.getDiferenciaGoles()+", puntos = "+miPosiciones.getPuntos()+" WHERE idTorneo = "+miPosiciones.getIdTorneo()+" AND idEquipo = "+miPosiciones.getIdEquipo();
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);  
            miConectar.psPrepararSentencias.executeUpdate();           

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void modificarPartidosLiga(Partidos miPartidos, int idTorneo, int idPartido){
        
        try{            
            Conectar miConectar = new Conectar();
            String insert = "UPDATE partidos SET golesEquipoLocal = "+miPartidos.getGolesEquipoLocal()+", golesEquipoVisitante = "+miPartidos.getGolesEquipoVisitante()+" WHERE idPartido = "+idPartido+" AND idTorneo = "+idTorneo;            
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);            
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void modificarFechaPartidosLiga(Partidos miPartidos, int idTorneo, int idPartido){
        
        try{            
            Conectar miConectar = new Conectar();            
            String insert = "UPDATE partidos SET fechaPartido = ? WHERE idPartido = "+idPartido+" AND idTorneo = "+idTorneo;
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);  
            miConectar.psPrepararSentencias.setString(1, miPartidos.getFechaPartido());
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }    
    
    public void modificarHoraPartidosLiga(Partidos miPartidos, int idTorneo, int idPartido){
        
        try{            
            Conectar miConectar = new Conectar();            
            String insert = "UPDATE partidos SET horaPartido = '"+miPartidos.getHoraPartido()+"' WHERE idPartido = "+idPartido+" AND idTorneo = "+idTorneo;
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);            
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }    
    
    public void modificarGolesJugadorPartido(int cantidadGoles, int idTorneo, int idPartido, int idJugador){
        
        try{            
            Conectar miConectar = new Conectar();            
            String insert = "UPDATE goleadorpartido SET cantidadGoles = "+cantidadGoles+" WHERE idTorneo = "+idTorneo+" AND idJugador = "+idJugador+" AND idPartido = "+idPartido;
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);            
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void darBajaJugadorRelacionEquipo(int idEquipo, int idJugador){
        
        try{            
            Conectar miConectar = new Conectar();            
            String insert = "UPDATE equiporelacionjugador SET estadoIdRelacion = 'baja' WHERE idEquipo = "+idEquipo+" AND idJugador = "+idJugador;
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);            
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void modificarNombreTorneo(int idUsuario, int idTorneo, String nombreTorneo){
        
        try{            
            Conectar miConectar = new Conectar();            
            String insert = "UPDATE torneo SET nombreTorneo = '"+nombreTorneo+"' WHERE idUsuario = "+idUsuario+" AND idTorneo = "+idTorneo;
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);            
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void darBajaTorneo(int idTorneo, int idUsuario){
        
        try{            
            Conectar miConectar = new Conectar();            
            String insert = "UPDATE torneo SET estadoTorneo = 'baja' WHERE idTorneo = "+idTorneo+" AND idUsuario = "+idUsuario;
            miConectar.psPrepararSentencias = miConectar.miconexion.prepareStatement(insert);            
            miConectar.psPrepararSentencias.executeUpdate();                                       
            
        }catch(ClassNotFoundException | SQLException e){            
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
}