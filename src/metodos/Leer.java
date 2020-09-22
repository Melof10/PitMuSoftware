package metodos;

import clases.DatosDeSesionUsuario;
import clases.Equipo;
import clases.EquipoJoinJugador;
import clases.GoleadorJoinEquipo;
import clases.Goleadores;
import clases.Jugador;
import clases.Partidos;
import clases.PosicionesJoinEquipo;
import clases.Torneo;
import clases.Usuario;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Leer {

    public Usuario loginUsuario(String username) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM usuariosistema WHERE username = '" + username + "'";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Usuario miUsuario = new Usuario();
            rst.beforeFirst();

            while (rst.next()) {
                miUsuario = new Usuario();
                miUsuario.setIdUsuario(rst.getInt("idUsuario"));
                miUsuario.setNombreUsuario(rst.getString("nombreUsuario"));
                miUsuario.setApellidoUsuario(rst.getString("apellidoUsuario"));
                miUsuario.setUsername(rst.getString("username"));
                miUsuario.setPassword(rst.getString("password"));
                miUsuario.setEmail(rst.getString("emailUsuario"));
                miUsuario.setTelefono(rst.getString("telefonoUsuario"));
            }

            rst.close();

            return miUsuario;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Usuario leerUsuario(String username) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM usuariosistema WHERE username = " + username;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Usuario miUsuario = new Usuario();
            rst.beforeFirst();

            while (rst.next()) {
                miUsuario = new Usuario();
                miUsuario.setNombreUsuario(rst.getString("nombreUsuario"));
                miUsuario.setApellidoUsuario(rst.getString("apellidoUsuario"));
                miUsuario.setUsername(rst.getString("username"));
                miUsuario.setEmail(rst.getString("emailUsuario"));
                miUsuario.setTelefono(rst.getString("telefonoUsuario"));
            }

            rst.close();

            return miUsuario;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Jugador[] leerJugador(int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM jugador WHERE idUsuario = " + idUsuario + " AND estadoJugador = 'alta' ORDER BY nombreJugador ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Jugador miJugador[] = new Jugador[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miJugador[rst.getRow() - 1] = new Jugador();
                miJugador[rst.getRow() - 1].setIdJugador(rst.getInt("idJugador"));
                miJugador[rst.getRow() - 1].setNombreJugador(rst.getString("nombreJugador"));
                miJugador[rst.getRow() - 1].setApellidoJugador(rst.getString("apellidoJugador"));
                miJugador[rst.getRow() - 1].setDniJugador(rst.getLong("dniJugador"));
                miJugador[rst.getRow() - 1].setDomicilioJugador(rst.getString("domicilioJugador"));
                miJugador[rst.getRow() - 1].setTelefonoJugador(rst.getLong("telefonoJugador"));
                miJugador[rst.getRow() - 1].setEstaturaJugador(rst.getDouble("estaturaJugador"));
                miJugador[rst.getRow() - 1].setPosicionJugador(rst.getString("posicionJugador"));
            }

            rst.close();

            return miJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Jugador[] buscarJugadoresPorNombre(String busqueda, int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM jugador "
                    + "WHERE nombreJugador LIKE '" + busqueda + "%' "
                    + "AND idUsuario = " + idUsuario + " "
                    + "AND estadoJugador = 'alta' "
                    + "ORDER BY nombreJugador ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Jugador miJugador[] = new Jugador[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miJugador[rst.getRow() - 1] = new Jugador();
                miJugador[rst.getRow() - 1].setIdJugador(rst.getInt("idJugador"));
                miJugador[rst.getRow() - 1].setNombreJugador(rst.getString("nombreJugador"));
                miJugador[rst.getRow() - 1].setApellidoJugador(rst.getString("apellidoJugador"));
                miJugador[rst.getRow() - 1].setDniJugador(rst.getLong("dniJugador"));
                miJugador[rst.getRow() - 1].setDomicilioJugador(rst.getString("domicilioJugador"));
                miJugador[rst.getRow() - 1].setTelefonoJugador(rst.getLong("telefonoJugador"));
                miJugador[rst.getRow() - 1].setEstaturaJugador(rst.getDouble("estaturaJugador"));
                miJugador[rst.getRow() - 1].setPosicionJugador(rst.getString("posicionJugador"));
            }

            rst.close();

            return miJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Jugador[] buscarJugadoresPorApellido(String busqueda, int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM jugador "
                    + "WHERE apellidoJugador LIKE '" + busqueda + "%' "
                    + "AND idUsuario = " + idUsuario + " "
                    + "AND estadoJugador = 'alta' "
                    + "ORDER BY nombreJugador ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Jugador miJugador[] = new Jugador[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miJugador[rst.getRow() - 1] = new Jugador();
                miJugador[rst.getRow() - 1].setIdJugador(rst.getInt("idJugador"));
                miJugador[rst.getRow() - 1].setNombreJugador(rst.getString("nombreJugador"));
                miJugador[rst.getRow() - 1].setApellidoJugador(rst.getString("apellidoJugador"));
                miJugador[rst.getRow() - 1].setDniJugador(rst.getLong("dniJugador"));
                miJugador[rst.getRow() - 1].setDomicilioJugador(rst.getString("domicilioJugador"));
                miJugador[rst.getRow() - 1].setTelefonoJugador(rst.getLong("telefonoJugador"));
                miJugador[rst.getRow() - 1].setEstaturaJugador(rst.getDouble("estaturaJugador"));
                miJugador[rst.getRow() - 1].setPosicionJugador(rst.getString("posicionJugador"));
            }

            rst.close();

            return miJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Jugador[] buscarJugadoresPorDni(String busqueda, int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM jugador "
                    + "WHERE dniJugador LIKE '" + busqueda + "%' "
                    + "AND idUsuario = " + idUsuario + " "
                    + "AND estadoJugador = 'alta' "
                    + "ORDER BY nombreJugador ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Jugador miJugador[] = new Jugador[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miJugador[rst.getRow() - 1] = new Jugador();
                miJugador[rst.getRow() - 1].setIdJugador(rst.getInt("idJugador"));
                miJugador[rst.getRow() - 1].setNombreJugador(rst.getString("nombreJugador"));
                miJugador[rst.getRow() - 1].setApellidoJugador(rst.getString("apellidoJugador"));
                miJugador[rst.getRow() - 1].setDniJugador(rst.getLong("dniJugador"));
                miJugador[rst.getRow() - 1].setDomicilioJugador(rst.getString("domicilioJugador"));
                miJugador[rst.getRow() - 1].setTelefonoJugador(rst.getLong("telefonoJugador"));
                miJugador[rst.getRow() - 1].setEstaturaJugador(rst.getDouble("estaturaJugador"));
                miJugador[rst.getRow() - 1].setPosicionJugador(rst.getString("posicionJugador"));
            }

            rst.close();

            return miJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public long validarJugador(String dni, int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM jugador WHERE dniJugador = " + dni + " AND idUsuario = " + idUsuario;
            ResultSet rst = miConectar.consulta(consulta);
            long dniJugador = 0;

            while (rst.next()) {
                dniJugador = rst.getLong("dniJugador");
            }

            rst.close();

            return dniJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return 0;
        }

    }

    public Jugador validarJugadorDos(int idUsuario, String dniJugador) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM jugador WHERE idUsuario = " +idUsuario+ " AND dniJugador = "+dniJugador;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Jugador miJugador = new Jugador();
            rst.beforeFirst();

            while (rst.next()) {
                miJugador.setIdJugador(rst.getInt("idJugador"));
                miJugador.setNombreJugador(rst.getString("nombreJugador"));
                miJugador.setApellidoJugador(rst.getString("apellidoJugador"));
                miJugador.setDniJugador(rst.getLong("dniJugador"));
                miJugador.setDomicilioJugador(rst.getString("domicilioJugador"));
                miJugador.setTelefonoJugador(rst.getLong("telefonoJugador"));
                miJugador.setEstaturaJugador(rst.getDouble("estaturaJugador"));
                miJugador.setPosicionJugador(rst.getString("posicionJugador"));
                miJugador.setEstadoJugador(rst.getString("estadoJugador"));
            }

            rst.close();

            return miJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Equipo[] leerEquipos(int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM equipo WHERE idUsuario = " + idUsuario + " AND estadoEquipo = 'alta' ORDER BY nombreEquipo ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Equipo miEquipo[] = new Equipo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miEquipo[rst.getRow() - 1] = new Equipo();
                miEquipo[rst.getRow() - 1].setIdEquipo(rst.getInt("idEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEquipo(rst.getString("nombreEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEstadioEquipo(rst.getString("nombreEstadio"));
                miEquipo[rst.getRow() - 1].setDireccionEstadioEquipo(rst.getString("direccionEstadio"));
            }

            rst.close();

            return miEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }
    
    public Jugador[] leerEquiposRelacionJugador(int idUsuario, int idEquipo) {

        try {            
            Conectar miConectar = new Conectar();
            String consulta = "SELECT jugador.idJugador, nombreJugador, apellidoJugador, dniJugador, domicilioJugador, telefonoJugador, estaturaJugador, posicionJugador FROM jugador INNER JOIN equiporelacionjugador on jugador.idJugador = equiporelacionjugador.idJugador WHERE idUsuario = " + idUsuario + " AND idEquipo = "+idEquipo+" AND equiporelacionjugador.estadoIdRelacion = 'alta'";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Jugador miJugador [] = new Jugador[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miJugador[rst.getRow() - 1] = new Jugador();
                miJugador[rst.getRow() - 1].setIdJugador(rst.getInt("jugador.idJugador"));
                miJugador[rst.getRow() - 1].setNombreJugador(rst.getString("nombreJugador"));
                miJugador[rst.getRow() - 1].setApellidoJugador(rst.getString("apellidoJugador"));
                miJugador[rst.getRow() - 1].setDniJugador(rst.getLong("dniJugador"));
                miJugador[rst.getRow() - 1].setDomicilioJugador(rst.getString("domicilioJugador"));
                miJugador[rst.getRow() - 1].setTelefonoJugador(rst.getLong("telefonoJugador"));
                miJugador[rst.getRow() - 1].setEstaturaJugador(rst.getDouble("estaturaJugador"));
                miJugador[rst.getRow() - 1].setPosicionJugador(rst.getString("posicionJugador"));                               
            }

            rst.close();

            return miJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }        
    
    public Equipo leerEquiposPorIdEquipo(int idUsuario, int idEquipo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM equipo WHERE idUsuario = " + idUsuario + " AND idEquipo = " + idEquipo + " ORDER BY nombreEquipo ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Equipo miEquipo = new Equipo();
            rst.beforeFirst();

            while (rst.next()) {                
                miEquipo.setIdEquipo(rst.getInt("idEquipo"));
                miEquipo.setNombreEquipo(rst.getString("nombreEquipo"));
                miEquipo.setNombreEstadioEquipo(rst.getString("nombreEstadio"));
                miEquipo.setDireccionEstadioEquipo(rst.getString("direccionEstadio"));
            }

            rst.close();

            return miEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Equipo[] validarEquipos(int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM equipo WHERE idUsuario = " + idUsuario;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Equipo miEquipo[] = new Equipo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miEquipo[rst.getRow() - 1] = new Equipo();
                miEquipo[rst.getRow() - 1].setIdEquipo(rst.getInt("idEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEquipo(rst.getString("nombreEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEstadioEquipo(rst.getString("nombreEstadio"));
                miEquipo[rst.getRow() - 1].setDireccionEstadioEquipo(rst.getString("direccionEstadio"));
            }

            rst.close();

            return miEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }
    
    public Equipo[] validarEquiposPorNombre(int idUsuario, int idEquipo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM equipo WHERE idUsuario = "+idUsuario+" AND idEquipo = "+idEquipo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Equipo miEquipo[] = new Equipo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miEquipo[rst.getRow() - 1] = new Equipo();
                miEquipo[rst.getRow() - 1].setIdEquipo(rst.getInt("idEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEquipo(rst.getString("nombreEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEstadioEquipo(rst.getString("nombreEstadio"));
                miEquipo[rst.getRow() - 1].setDireccionEstadioEquipo(rst.getString("direccionEstadio"));
            }

            rst.close();

            return miEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Equipo[] leerEquiposPorNombre(String busqueda, int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM equipo "
                            + "WHERE nombreEquipo LIKE '" + busqueda + "%' "
                            + "AND idUsuario = " + idUsuario + " ORDER BY nombreEquipo ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Equipo miEquipo[] = new Equipo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miEquipo[rst.getRow() - 1] = new Equipo();
                miEquipo[rst.getRow() - 1].setIdEquipo(rst.getInt("idEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEquipo(rst.getString("nombreEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEstadioEquipo(rst.getString("nombreEstadio"));
                miEquipo[rst.getRow() - 1].setDireccionEstadioEquipo(rst.getString("direccionEstadio"));
            }

            rst.close();

            return miEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public int LeerIdEquipo(Equipo miEquipo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT idEquipo FROM equipo WHERE nombreEquipo = '" + miEquipo.getNombreEquipo() + "'";
            ResultSet rst = miConectar.consulta(consulta);
            int idEquipo = 0;

            while (rst.next()) {
                idEquipo = rst.getInt("idEquipo");
            }

            rst.close();

            return idEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return 0;
        }

    }

    public int LeerIdTorneo(Torneo miTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT idTorneo FROM torneo WHERE nombreTorneo = '" + miTorneo.getNombreTorneo() + "'";
            ResultSet rst = miConectar.consulta(consulta);
            int idTorneo = 0;

            while (rst.next()) {
                idTorneo = rst.getInt("idTorneo");
            }

            rst.close();

            return idTorneo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return 0;
        }

    }

    public int[] leerIdEquipo(int idTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT idEquipo FROM torneoEquipo WHERE idTorneo = " + idTorneo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            int idEquipo[] = new int[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                idEquipo[rst.getRow() - 1] = rst.getInt("idEquipo");
            }

            rst.close();

            return idEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Torneo[] leerTorneos(int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM torneo WHERE estadoTorneo = 'alta' AND idUsuario = " + idUsuario;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Torneo miTorneo[] = new Torneo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miTorneo[rst.getRow() - 1] = new Torneo();
                miTorneo[rst.getRow() - 1].setIdTorneo(rst.getInt("idTorneo"));
                miTorneo[rst.getRow() - 1].setNombreTorneo(rst.getString("nombreTorneo"));
                miTorneo[rst.getRow() - 1].setCantidadEquipos(Integer.parseInt(rst.getString("cantidadEquipos")));
                miTorneo[rst.getRow() - 1].setCantidadFechas(Integer.parseInt(rst.getString("cantidadFechas")));
                miTorneo[rst.getRow() - 1].setFormatoTorneo(rst.getString("formatoTorneo"));
            }

            rst.close();

            return miTorneo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }
    
    public int leerTorneoEspecifico(int idUsuario, int idTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT cantidadFechas FROM torneo WHERE estadoTorneo = 'alta' AND idUsuario = "+idUsuario+" AND idTorneo = "+idTorneo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Torneo miTorneo = new Torneo();
            rst.beforeFirst();

            while (rst.next()) {
                miTorneo.setCantidadFechas(rst.getInt("cantidadFechas"));
            }

            rst.close();

            return miTorneo.getCantidadFechas();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return 0;
        }

    }

    public Torneo[] leerTorneosPorNombre(String busqueda, int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM torneo "
                            + "WHERE nombreTorneo LIKE '" + busqueda + "%' "                    
                            + "AND estadoTorneo = 'alta' "
                            + "AND idUsuario = " + idUsuario;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Torneo miTorneo[] = new Torneo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miTorneo[rst.getRow() - 1] = new Torneo();
                miTorneo[rst.getRow() - 1].setIdTorneo(rst.getInt("idTorneo"));
                miTorneo[rst.getRow() - 1].setNombreTorneo(rst.getString("nombreTorneo"));
                miTorneo[rst.getRow() - 1].setFormatoTorneo(rst.getString("formatoTorneo"));
                miTorneo[rst.getRow() - 1].setCantidadFechas(rst.getInt("cantidadFechas"));
                miTorneo[rst.getRow() - 1].setCantidadEquipos(rst.getInt("cantidadEquipos"));
            }

            rst.close();

            return miTorneo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Partidos[] fechasTorneo(int idTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT DISTINCT(numeroFechaTorneo) FROM partidos WHERE idTorneo = " + idTorneo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Partidos miPartidos[] = new Partidos[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miPartidos[rst.getRow() - 1] = new Partidos();
                miPartidos[rst.getRow() - 1].setNumFechaTorneo(rst.getInt("numeroFechaTorneo"));                
            }

            rst.close();

            return miPartidos;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Partidos[] leerPartidoPorFecha(int idTorneo, int idNumeroFecha) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "select idPartido, idEquipoLocal, nombreEstadio, idEquipoVisitante, numeroFechaTorneo, idEquipo, idTorneo, IFNULL(fechaPartido, null), IFNULL(horaPartido, null), IFNULL(golesEquipoLocal, -1), IFNULL(golesEquipoVisitante, -1) from partidos inner join equipo on partidos.idEquipoLocal = idEquipo where idTorneo = " + idTorneo + " and numeroFechaTorneo = " + idNumeroFecha;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Partidos miPartidos[] = new Partidos[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miPartidos[rst.getRow() - 1] = new Partidos();
                miPartidos[rst.getRow() - 1].setIdPartido(rst.getInt("idPartido"));
                miPartidos[rst.getRow() - 1].setFechaPartido(rst.getString("IFNULL(fechaPartido, null)"));
                miPartidos[rst.getRow() - 1].setHoraPartido(rst.getString("IFNULL(horaPartido, null)"));
                miPartidos[rst.getRow() - 1].setIdEquipoLocal(rst.getInt("idEquipoLocal"));
                miPartidos[rst.getRow() - 1].setIdEquipoVisitante(rst.getInt("idEquipoVisitante"));
                miPartidos[rst.getRow() - 1].setGolesEquipoLocal(rst.getInt("IFNULL(golesEquipoLocal, -1)"));
                miPartidos[rst.getRow() - 1].setGolesEquipoVisitante(rst.getInt("IFNULL(golesEquipoVisitante, -1)"));
                miPartidos[rst.getRow() - 1].setNombreEstadio(rst.getString("nombreEstadio"));
            }

            rst.close();

            return miPartidos;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }
    
    public EquipoJoinJugador[] leerTablaEquipoRelacionJugador(int idEquipo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM equiporelacionjugador WHERE idEquipo = "+idEquipo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            EquipoJoinJugador miEquipoJoinJugador[] = new EquipoJoinJugador[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miEquipoJoinJugador[rst.getRow() - 1] = new EquipoJoinJugador();
                miEquipoJoinJugador[rst.getRow() - 1].setIdEquipoJoinJugador(rst.getInt("idRelacion"));
                miEquipoJoinJugador[rst.getRow() - 1].setIdEquipo(rst.getInt("idEquipo"));
                miEquipoJoinJugador[rst.getRow() - 1].setIdJugador(rst.getInt("idJugador"));                
            }

            rst.close();

            return miEquipoJoinJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }        
    
    public String leerNombreEquipoLocal(int idEquipolocal, int idTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "select DISTINCT(nombreEquipo) from partidos inner join equipo on partidos.idEquipoLocal = equipo.idEquipo where equipo.idEquipo = " + idEquipolocal + " AND idTorneo = " + idTorneo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            String nombreEquipo = new String();
            rst.beforeFirst();

            while (rst.next()) {
                nombreEquipo = rst.getString("nombreEquipo");
            }

            rst.close();

            return nombreEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public String leerNombreEquipoVisitante(int idEquipoVisitante, int idTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "select DISTINCT(nombreEquipo) from partidos inner join equipo on partidos.idEquipoLocal = equipo.idEquipo where idEquipo = " + idEquipoVisitante + " AND idTorneo = " + idTorneo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            String nombreEquipo = new String();
            rst.beforeFirst();

            while (rst.next()) {
                nombreEquipo = rst.getString("nombreEquipo");
            }

            rst.close();

            return nombreEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Jugador[] leerJugadorIdEquipo(int idEquipo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "select jugador.idJugador, nombreJugador, apellidoJugador, dniJugador, domicilioJugador, telefonoJugador, estaturaJugador, posicionJugador from equiporelacionjugador inner join jugador on equiporelacionjugador.idJugador = jugador.idJugador where idEquipo = " + idEquipo + " AND equiporelacionjugador.estadoIdRelacion = 'alta' ORDER BY nombreJugador ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Jugador miJugador[] = new Jugador[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miJugador[rst.getRow() - 1] = new Jugador();
                miJugador[rst.getRow() - 1].setIdJugador(rst.getInt("jugador.idJugador"));
                miJugador[rst.getRow() - 1].setNombreJugador(rst.getString("nombreJugador"));
                miJugador[rst.getRow() - 1].setApellidoJugador(rst.getString("apellidoJugador"));
                miJugador[rst.getRow() - 1].setDniJugador(rst.getLong("dniJugador"));
                miJugador[rst.getRow() - 1].setDomicilioJugador(rst.getString("domicilioJugador"));
                miJugador[rst.getRow() - 1].setTelefonoJugador(rst.getLong("telefonoJugador"));
                miJugador[rst.getRow() - 1].setEstaturaJugador(rst.getDouble("estaturaJugador"));
                miJugador[rst.getRow() - 1].setPosicionJugador(rst.getString("posicionJugador"));
            }

            rst.close();

            return miJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Jugador leerJugadorIdEquipoDinamicamente(String busqueda, int idEquipo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT jugador.idJugador, nombreJugador, apellidoJugador, dniJugador, domicilioJugador, telefonoJugador, estaturaJugador, posicionJugador from equiporelacionjugador inner join jugador on equiporelacionjugador.idJugador = jugador.idJugador "
                    + "WHERE nombreJugador LIKE '" + busqueda + "%' "
                    + "OR apellidoJugador LIKE '" + busqueda + "%' "
                    + "AND idEquipo = " + idEquipo + " ORDER BY nombreJugador ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Jugador miJugador = new Jugador();
            rst.beforeFirst();

            while (rst.next()) {
                miJugador.setIdJugador(rst.getInt("idJugador"));
                miJugador.setNombreJugador(rst.getString("nombreJugador"));
                miJugador.setApellidoJugador(rst.getString("apellidoJugador"));
                miJugador.setDniJugador(rst.getLong("dniJugador"));
                miJugador.setDomicilioJugador(rst.getString("domicilioJugador"));
                miJugador.setTelefonoJugador(rst.getLong("telefonoJugador"));
                miJugador.setEstaturaJugador(rst.getDouble("estaturaJugador"));
                miJugador.setPosicionJugador(rst.getString("posicionJugador"));
            }

            rst.close();

            return miJugador;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public DatosDeSesionUsuario[] leerDatosDeSesion(int idUsuario) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM datosiniciosesion WHERE idUsuario = " + idUsuario + " ORDER BY FechaHoraInicioSesion DESC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            DatosDeSesionUsuario miDatosDeSesionUsuario[] = new DatosDeSesionUsuario[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miDatosDeSesionUsuario[rst.getRow() - 1] = new DatosDeSesionUsuario();
                miDatosDeSesionUsuario[rst.getRow() - 1].setIdDatosDeSesion(rst.getInt("idInicioSesion"));
                miDatosDeSesionUsuario[rst.getRow() - 1].setFechaHoraInicioSesion(rst.getString("FechaHoraInicioSesion"));
                miDatosDeSesionUsuario[rst.getRow() - 1].setFechaHoraCierreSesion(rst.getString("FechaHoraCierreSesion"));
                miDatosDeSesionUsuario[rst.getRow() - 1].setIdUsuario(rst.getInt("idUsuario"));
            }

            rst.close();

            return miDatosDeSesionUsuario;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public DatosDeSesionUsuario[] leerDatosDeSesionDinamicamente(int idUsuario, String busqueda) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM datosiniciosesion WHERE fechaHoraInicioSesion LIKE '" + busqueda + "%' OR fechaHoraCierreSesion LIKE '" + busqueda + "%' AND idUsuario = " + idUsuario + " ORDER BY FechaHoraInicioSesion DESC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            DatosDeSesionUsuario miDatosDeSesionUsuario[] = new DatosDeSesionUsuario[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miDatosDeSesionUsuario[rst.getRow() - 1] = new DatosDeSesionUsuario();
                miDatosDeSesionUsuario[rst.getRow() - 1].setIdDatosDeSesion(rst.getInt("idInicioSesion"));
                miDatosDeSesionUsuario[rst.getRow() - 1].setFechaHoraInicioSesion(rst.getString("FechaHoraInicioSesion"));
                miDatosDeSesionUsuario[rst.getRow() - 1].setFechaHoraCierreSesion(rst.getString("FechaHoraCierreSesion"));
                miDatosDeSesionUsuario[rst.getRow() - 1].setIdUsuario(rst.getInt("idUsuario"));
            }

            rst.close();

            return miDatosDeSesionUsuario;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public PosicionesJoinEquipo[] leerTablaPosiciones(int idTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT posiciones.idEquipo, equipo.nombreEquipo, equipo.idEquipo, partidosJugados, idTorneo, idPosiciones, partidosGanados, partidosEmpatados, partidosPerdidos, golesFavor, golesContra, diferenciaGoles, puntos FROM equipo INNER JOIN posiciones ON equipo.idEquipo = posiciones.idEquipo WHERE posiciones.idTorneo = " + idTorneo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            PosicionesJoinEquipo miPosicionesJoinEquipo[] = new PosicionesJoinEquipo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miPosicionesJoinEquipo[rst.getRow() - 1] = new PosicionesJoinEquipo();
                miPosicionesJoinEquipo[rst.getRow() - 1].setIdEquipo(rst.getInt("posiciones.idEquipo"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setNombreEquipo(rst.getString("nombreEquipo"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setPartidosJugados(rst.getInt("partidosJugados"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setPartidosGanados(rst.getInt("partidosGanados"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setPartidosEmpatados(rst.getInt("partidosEmpatados"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setPartidosPerdidos(rst.getInt("partidosPerdidos"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setGolesFavor(rst.getInt("golesFavor"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setGolesContra(rst.getInt("golesContra"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setDiferenciaGoles(rst.getInt("diferenciaGoles"));
                miPosicionesJoinEquipo[rst.getRow() - 1].setPuntos(rst.getInt("puntos"));
            }

            rst.close();

            return miPosicionesJoinEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Equipo[] leerEquiposTorneo(int idTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT equipo.idEquipo, nombreEquipo FROM torneoequipo INNER JOIN equipo on torneoequipo.idEquipo = equipo.idEquipo WHERE idTorneo = " + idTorneo + " ORDER BY nombreEquipo ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Equipo miEquipo[] = new Equipo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miEquipo[rst.getRow() - 1] = new Equipo();
                miEquipo[rst.getRow() - 1].setIdEquipo(rst.getInt("idEquipo"));
                miEquipo[rst.getRow() - 1].setNombreEquipo(rst.getString("nombreEquipo"));
            }

            rst.close();

            return miEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public PosicionesJoinEquipo leerTablaPosicionesIdEquipo(int idTorneo, int idEquipo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT equipo.idEquipo, equipo.idEquipo, partidosJugados, idTorneo, idPosiciones, partidosGanados, partidosEmpatados, partidosPerdidos, golesFavor, golesContra, diferenciaGoles, puntos FROM equipo INNER JOIN posiciones ON equipo.idEquipo = posiciones.idEquipo WHERE posiciones.idTorneo = " + idTorneo + " AND posiciones.idEquipo =" + idEquipo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            PosicionesJoinEquipo miPosicionesJoinEquipo = new PosicionesJoinEquipo();
            rst.beforeFirst();

            while (rst.next()) {
                miPosicionesJoinEquipo.setIdEquipo(rst.getInt("idEquipo"));
                miPosicionesJoinEquipo.setPartidosJugados(rst.getInt("partidosJugados"));
                miPosicionesJoinEquipo.setPartidosGanados(rst.getInt("partidosGanados"));
                miPosicionesJoinEquipo.setPartidosEmpatados(rst.getInt("partidosEmpatados"));
                miPosicionesJoinEquipo.setPartidosPerdidos(rst.getInt("partidosPerdidos"));
                miPosicionesJoinEquipo.setGolesFavor(rst.getInt("golesFavor"));
                miPosicionesJoinEquipo.setGolesContra(rst.getInt("golesContra"));
                miPosicionesJoinEquipo.setDiferenciaGoles(rst.getInt("diferenciaGoles"));
                miPosicionesJoinEquipo.setPuntos(rst.getInt("puntos"));
            }

            rst.close();

            return miPosicionesJoinEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public GoleadorJoinEquipo leerTablaGoleadores(int idTorneo, int idJugador) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT nombreEquipo, goleadorpartido.idJugador, nombreJugador, apellidoJugador, SUM(cantidadGoles) FROM goleadorpartido INNER JOIN equipo ON goleadorpartido.idEquipo = equipo.idEquipo INNER JOIN jugador ON goleadorpartido.idJugador = jugador.idJugador WHERE goleadorpartido.idTorneo = " + idTorneo + " AND goleadorpartido.idJugador = " + idJugador;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            GoleadorJoinEquipo miGoleadorJoinEquipo = new GoleadorJoinEquipo();
            rst.beforeFirst();

            while (rst.next()) {
                miGoleadorJoinEquipo.setGolesJugador(rst.getInt("SUM(cantidadGoles)"));
                miGoleadorJoinEquipo.setNombreJugador(rst.getString("nombreJugador"));
                miGoleadorJoinEquipo.setApellidoJugador(rst.getString("apellidoJugador"));
                miGoleadorJoinEquipo.setIdJugador(rst.getInt("goleadorpartido.idJugador"));
                miGoleadorJoinEquipo.setNombreEquipo(rst.getString("nombreEquipo"));
            }

            rst.close();

            return miGoleadorJoinEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public GoleadorJoinEquipo[] leerJugadoresDeTablaGoleadores(int idTorneo) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT DISTINCT(goleadorpartido.idJugador) FROM goleadorpartido WHERE goleadorpartido.idTorneo = " + idTorneo;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            GoleadorJoinEquipo miGoleadorJoinEquipo[] = new GoleadorJoinEquipo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miGoleadorJoinEquipo[rst.getRow() - 1] = new GoleadorJoinEquipo();
                miGoleadorJoinEquipo[rst.getRow() - 1].setIdJugador(rst.getInt("goleadorpartido.idJugador"));
            }

            rst.close();

            return miGoleadorJoinEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public Goleadores leerGoleadorPartido(int idTorneo, int idJugador, int idPartido) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT * FROM goleadorpartido WHERE idTorneo = " + idTorneo + " AND idJugador = " + idJugador;
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            Goleadores miGoleadoresConsulta = new Goleadores();
            rst.beforeFirst();

            while (rst.next()) {
                miGoleadoresConsulta.setIdGoleador(rst.getInt("idGoleadorPartido"));
                miGoleadoresConsulta.setIdTorneo(rst.getInt("idTorneo"));
                miGoleadoresConsulta.setIdEquipo(rst.getInt("idEquipo"));
                miGoleadoresConsulta.setIdJugador(rst.getInt("idJugador"));
                miGoleadoresConsulta.setGolesJugador(rst.getInt("cantidadGoles"));
            }

            rst.close();

            return miGoleadoresConsulta;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

    public GoleadorJoinEquipo[] leerGoleadorPartidoPorIdPartido(int idTorneo, int idPartido) {

        try {
            Conectar miConectar = new Conectar();
            String consulta = "SELECT nombreEquipo, goleadorpartido.idJugador, nombreJugador, apellidoJugador, cantidadGoles FROM goleadorpartido INNER JOIN equipo ON goleadorpartido.idEquipo = equipo.idEquipo INNER JOIN jugador ON goleadorpartido.idJugador = jugador.idJugador WHERE goleadorpartido.idTorneo = " + idTorneo + " AND idPartido = " + idPartido + " ORDER BY nombreJugador ASC";
            ResultSet rst = miConectar.consulta(consulta);
            rst.last();
            GoleadorJoinEquipo miGoleadorJoinEquipo[] = new GoleadorJoinEquipo[rst.getRow()];
            rst.beforeFirst();

            while (rst.next()) {
                miGoleadorJoinEquipo[rst.getRow() - 1] = new GoleadorJoinEquipo();
                miGoleadorJoinEquipo[rst.getRow() - 1].setGolesJugador(rst.getInt("cantidadGoles"));
                miGoleadorJoinEquipo[rst.getRow() - 1].setNombreJugador(rst.getString("nombreJugador"));
                miGoleadorJoinEquipo[rst.getRow() - 1].setApellidoJugador(rst.getString("apellidoJugador"));
                miGoleadorJoinEquipo[rst.getRow() - 1].setIdJugador(rst.getInt("goleadorpartido.idJugador"));
                miGoleadorJoinEquipo[rst.getRow() - 1].setNombreEquipo(rst.getString("nombreEquipo"));
            }

            rst.close();

            return miGoleadorJoinEquipo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }

    }

}
