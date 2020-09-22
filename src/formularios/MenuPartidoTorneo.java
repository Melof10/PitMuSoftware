/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import alertas.CampeonGoleadorTorneo;
import clases.GoleadorJoinEquipo;
import clases.GoleadorPartido;
import clases.Goleadores;
import clases.Jugador;
import clases.Partidos;
import clases.Posiciones;
import clases.PosicionesJoinEquipo;
import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import metodos.Cargar;
import metodos.CentralizarColumnasJTable;
import metodos.Guardar;
import metodos.Leer;
import metodos.Modificar;

/**
 *
 * @author Federico
 */
public class MenuPartidoTorneo extends javax.swing.JDialog {

    private String nombreEquipoLocal;
    private String nombreEquipoVisitante;
    private String numeroFecha;
    private String nombreTorneo;
    private Partidos miPartidos;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DefaultTableModel dftLocal = new DefaultTableModel();
    private DefaultTableModel dftVisitante = new DefaultTableModel();
    private String titulos[] = new String[3];
    private TableCellRenderer columnasCentralizadas = new CentralizarColumnasJTable();
    private int idTorneo;
    private int idPartido;
    private int idUsuario;

    public MenuPartidoTorneo(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public MenuPartidoTorneo(javax.swing.JDialog parent, boolean modal, Partidos miPartidos, String nombreEquipoLocal, String nombreEquipoVisitante, String numeroFecha, int idTorneo, int idPartido, int idUsuario, String nombreTorneo) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.nombreEquipoLocal = nombreEquipoLocal;
        this.nombreEquipoVisitante = nombreEquipoVisitante;
        this.numeroFecha = numeroFecha;
        this.miPartidos = miPartidos;
        this.nombreTorneo = nombreTorneo;
        this.idTorneo = idTorneo;
        this.idPartido = idPartido;
        this.idUsuario = idUsuario;
        PlaceHolder miPlacerHolder = new PlaceHolder(txt_buscarJugadorLocal, "Buscar");
        PlaceHolder miPlacerHolderDos = new PlaceHolder(txt_buscarJugadorVisitante, "Buscar");
        setTitle("PitMu SOFTWARE - GestionarPartido");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        // Personaliza los JTable       
        tablaGolesLocal.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaGolesLocal.getTableHeader().setOpaque(false);
        tablaGolesLocal.getTableHeader().setBackground(new Color(255, 153, 0));
        tablaGolesLocal.getTableHeader().setForeground(new Color(255, 255, 255));
        tablaGolesLocal.setRowHeight(25);
        tablaGolesVisitante.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaGolesVisitante.getTableHeader().setOpaque(false);
        tablaGolesVisitante.getTableHeader().setBackground(new Color(255, 153, 0));
        tablaGolesVisitante.getTableHeader().setForeground(new Color(255, 255, 255));
        tablaGolesVisitante.setRowHeight(25);
        // Personaliza combosBox
        cmbJugadorLocal.setBackground(Color.WHITE);
        cmbJugadorVisitante.setBackground(Color.WHITE);

        titulos[0] = "id Jugador";
        titulos[1] = "Jugador";
        titulos[2] = "Gol";

    }

    private void recorrerComboBoxLocal(Jugador miJugadorParam) {
        Jugador miJugador;

        for (int i = 0; i < cmbJugadorLocal.getItemCount(); i++) {

            miJugador = (Jugador) cmbJugadorLocal.getItemAt(i);

            if (miJugador.toString().equals(miJugadorParam.getApellidoJugador() + ", " + miJugadorParam.getNombreJugador())) {
                cmbJugadorLocal.setSelectedIndex(i);
                break;
            }

        }
    }

    private void recorrerComboBoxVisitante(Jugador miJugadorParam) {

        Jugador miJugador;

        for (int i = 0; i < cmbJugadorVisitante.getItemCount(); i++) {

            miJugador = (Jugador) cmbJugadorVisitante.getItemAt(i);

            if (miJugador.toString().equals(miJugadorParam.getApellidoJugador() + ", " + miJugadorParam.getNombreJugador())) {
                cmbJugadorVisitante.setSelectedIndex(i);
                break;
            }

        }
    }

    private void calcularPosicionLocal() {

        Leer miLeer = new Leer();
        Modificar miModificar = new Modificar();

        // Datos de equipo Local        
        PosicionesJoinEquipo PosicionActualEquipoLocal = miLeer.leerTablaPosicionesIdEquipo(idTorneo, miPartidos.getIdEquipoLocal());
        Posiciones miPosicionesLocal = new Posiciones();

        int golesFavorLocal = Integer.parseInt(txt_local.getText().trim());
        int golesFavorVisitante = Integer.parseInt(txt_visitante.getText().trim());

        miPosicionesLocal.setIdTorneo(idTorneo);
        miPosicionesLocal.setIdEquipo(miPartidos.getIdEquipoLocal());
        miPosicionesLocal.setPartidosJugados(PosicionActualEquipoLocal.getPartidosJugados() + 1);
        miPosicionesLocal.setGolesFavor(golesFavorLocal + PosicionActualEquipoLocal.getGolesFavor());
        miPosicionesLocal.setGolesContra(golesFavorVisitante + PosicionActualEquipoLocal.getGolesContra());
        miPosicionesLocal.setDiferenciaGoles(miPosicionesLocal.getGolesFavor() - miPosicionesLocal.getGolesContra());

        if (golesFavorLocal > golesFavorVisitante) {
            miPosicionesLocal.setPartidosGanados(PosicionActualEquipoLocal.getPartidosGanados() + 1);
            miPosicionesLocal.setPartidosEmpatados(PosicionActualEquipoLocal.getPartidosEmpatados());
            miPosicionesLocal.setPartidosPerdidos(PosicionActualEquipoLocal.getPartidosPerdidos());
            miPosicionesLocal.setPuntos(PosicionActualEquipoLocal.getPuntos() + 3);
        } else if (golesFavorLocal == golesFavorVisitante) {
            miPosicionesLocal.setPartidosEmpatados(PosicionActualEquipoLocal.getPartidosEmpatados() + 1);
            miPosicionesLocal.setPartidosGanados(PosicionActualEquipoLocal.getPartidosGanados());
            miPosicionesLocal.setPartidosPerdidos(PosicionActualEquipoLocal.getPartidosPerdidos());
            miPosicionesLocal.setPuntos(PosicionActualEquipoLocal.getPuntos() + 1);
        } else if (golesFavorLocal < golesFavorVisitante) {
            miPosicionesLocal.setPartidosPerdidos(PosicionActualEquipoLocal.getPartidosPerdidos() + 1);
            miPosicionesLocal.setPartidosGanados(PosicionActualEquipoLocal.getPartidosGanados());
            miPosicionesLocal.setPartidosEmpatados(PosicionActualEquipoLocal.getPartidosEmpatados());
            miPosicionesLocal.setPuntos(PosicionActualEquipoLocal.getPuntos());
        }

        miModificar.modificarTablaPosiciones(idTorneo, miPosicionesLocal);

    }

    private void calcularPosicionVisitante() {

        Leer miLeer = new Leer();
        Modificar miModificar = new Modificar();

        int golesFavorLocal = Integer.parseInt(txt_local.getText().trim());
        int golesFavorVisitante = Integer.parseInt(txt_visitante.getText().trim());

        PosicionesJoinEquipo PosicionActualEquipoVisitante = miLeer.leerTablaPosicionesIdEquipo(idTorneo, miPartidos.getIdEquipoVisitante());
        Posiciones miPosicionesVisitante = new Posiciones();

        miPosicionesVisitante.setIdTorneo(idTorneo);
        miPosicionesVisitante.setIdEquipo(miPartidos.getIdEquipoVisitante());
        miPosicionesVisitante.setPartidosJugados(PosicionActualEquipoVisitante.getPartidosJugados() + 1);
        miPosicionesVisitante.setGolesFavor(golesFavorVisitante + PosicionActualEquipoVisitante.getGolesFavor());
        miPosicionesVisitante.setGolesContra(golesFavorLocal + PosicionActualEquipoVisitante.getGolesContra());
        miPosicionesVisitante.setDiferenciaGoles(miPosicionesVisitante.getGolesFavor() - miPosicionesVisitante.getGolesContra());

        if (golesFavorVisitante > golesFavorLocal) {
            miPosicionesVisitante.setPartidosGanados(PosicionActualEquipoVisitante.getPartidosGanados() + 1);
            miPosicionesVisitante.setPartidosEmpatados(PosicionActualEquipoVisitante.getPartidosEmpatados());
            miPosicionesVisitante.setPartidosPerdidos(PosicionActualEquipoVisitante.getPartidosPerdidos());
            miPosicionesVisitante.setPuntos(PosicionActualEquipoVisitante.getPuntos() + 3);
        } else if (golesFavorVisitante == golesFavorLocal) {
            miPosicionesVisitante.setPartidosEmpatados(PosicionActualEquipoVisitante.getPartidosEmpatados() + 1);
            miPosicionesVisitante.setPartidosGanados(PosicionActualEquipoVisitante.getPartidosGanados());
            miPosicionesVisitante.setPartidosPerdidos(PosicionActualEquipoVisitante.getPartidosPerdidos());
            miPosicionesVisitante.setPuntos(PosicionActualEquipoVisitante.getPuntos() + 1);
        } else if (golesFavorVisitante < golesFavorLocal) {
            miPosicionesVisitante.setPartidosPerdidos(PosicionActualEquipoVisitante.getPartidosPerdidos() + 1);
            miPosicionesVisitante.setPartidosEmpatados(PosicionActualEquipoVisitante.getPartidosEmpatados());
            miPosicionesVisitante.setPartidosGanados(PosicionActualEquipoVisitante.getPartidosGanados());
            miPosicionesVisitante.setPuntos(PosicionActualEquipoVisitante.getPuntos());
        }

        miModificar.modificarTablaPosiciones(idTorneo, miPosicionesVisitante);

    }
    
    public void corroborarCampeon(){
        
        Leer miLeer = new Leer();
        PosicionesJoinEquipo miPosiciones [] = miLeer.leerTablaPosiciones(idTorneo);
        int cantidadPartidos = miLeer.leerTorneoEspecifico(idUsuario, idTorneo);
        int auxiliar = 0;
        for(int i = 0; i < miPosiciones.length; i++){
            if(miPosiciones[i].getPartidosJugados() != cantidadPartidos){
                auxiliar = 1;
                break;
            }
        }
        
        // VALIDA EL 1ER PUESTO DE LA TABLA DE POSICIONES
        PosicionesJoinEquipo miPosicionesJoinEquipo [] = miLeer.leerTablaPosiciones(idTorneo);    
        PosicionesJoinEquipo auxCampeon = new PosicionesJoinEquipo();
        for(int i = 0; i < miPosicionesJoinEquipo.length; i++){
            for(int j = 0; j < (miPosicionesJoinEquipo.length - 1); j++){
                if(miPosicionesJoinEquipo[j].getPuntos() < miPosicionesJoinEquipo[j+1].getPuntos()){                
                    auxCampeon = miPosicionesJoinEquipo[j+1];
                    miPosicionesJoinEquipo[j+1] = miPosicionesJoinEquipo[j];
                    miPosicionesJoinEquipo[j] = auxCampeon;
                }
            }            
        }
        
        // VALIDA EL 1ER PUESTO DE LA TABLA DE GOLEADORES
        GoleadorJoinEquipo idJugadorTablaGoleadores [] = miLeer.leerJugadoresDeTablaGoleadores(idTorneo);
        GoleadorJoinEquipo miGoleadorJoinEquipo [] = new GoleadorJoinEquipo[idJugadorTablaGoleadores.length];
        for(int i = 0; i < idJugadorTablaGoleadores.length; i++){            
            miGoleadorJoinEquipo[i] = miLeer.leerTablaGoleadores(idTorneo, idJugadorTablaGoleadores[i].getIdJugador());            
        }        
        GoleadorJoinEquipo auxGoleador = new GoleadorJoinEquipo();
        for(int i = 0; i < miGoleadorJoinEquipo.length; i++){
            for(int j = 0; j < (miGoleadorJoinEquipo.length-1); j++){
                if(miGoleadorJoinEquipo[j].getGolesJugador()< miGoleadorJoinEquipo[j+1].getGolesJugador()){                
                    auxGoleador = miGoleadorJoinEquipo[j+1];
                    miGoleadorJoinEquipo[j+1] = miGoleadorJoinEquipo[j];
                    miGoleadorJoinEquipo[j] = auxGoleador;
                }
            }            
        }     
        
        if(auxiliar == 0){
            String equipoCampeon = miPosicionesJoinEquipo[0].getNombreEquipo()+" ("+miPosicionesJoinEquipo[0].getPuntos()+" Ptos.)";
            String goleadorTorneo = miGoleadorJoinEquipo[0].getApellidoJugador()+", "+miGoleadorJoinEquipo[0].getNombreJugador()+" ("+miGoleadorJoinEquipo[0].getGolesJugador()+" goles)";
            CampeonGoleadorTorneo miCampeonGoleadorTorneo = new CampeonGoleadorTorneo(this, true, equipoCampeon, goleadorTorneo, nombreTorneo);
            miCampeonGoleadorTorneo.setVisible(true);
            Guardar miGuardar = new Guardar();
            miGuardar.guardarCampeonTorneo(idTorneo, miPosicionesJoinEquipo[0].getIdEquipo(), miPosicionesJoinEquipo[0].getPuntos());
            miGuardar.guardarGoleadorTorneo(miGoleadorJoinEquipo[0].getIdJugador(), miGoleadorJoinEquipo[0].getGolesJugador(), idTorneo);
        }
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_fecha = new javax.swing.JLabel();
        lbEquipoLocal = new javax.swing.JLabel();
        lbEquipoVisitante = new javax.swing.JLabel();
        txt_visitante = new javax.swing.JTextField();
        cmbJugadorLocal = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaGolesVisitante = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaGolesLocal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spGolesLocal = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spGolesVisitante = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_local = new javax.swing.JTextField();
        calendarFechaPartido = new rojeru_san.componentes.RSDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_buscarJugadorLocal = new javax.swing.JTextField();
        txt_buscarJugadorVisitante = new javax.swing.JTextField();
        cmbJugadorVisitante = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txt_hora = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_fecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha.setText("Fecha ");

        lbEquipoLocal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbEquipoLocal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbEquipoLocal.setText("Local");

        lbEquipoVisitante.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbEquipoVisitante.setText("Visitante");

        txt_visitante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_visitante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        cmbJugadorLocal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        cmbJugadorLocal.setFocusable(false);

        tablaGolesVisitante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        tablaGolesVisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaGolesVisitante.setGridColor(new java.awt.Color(255, 255, 255));
        tablaGolesVisitante.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaGolesVisitante.setRowHeight(25);
        tablaGolesVisitante.setSelectionBackground(new java.awt.Color(0, 112, 192));
        tablaGolesVisitante.setShowVerticalLines(false);
        tablaGolesVisitante.getTableHeader().setReorderingAllowed(false);
        tablaGolesVisitante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGolesVisitanteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaGolesVisitanteMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tablaGolesVisitante);

        tablaGolesLocal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        tablaGolesLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaGolesLocal.setGridColor(new java.awt.Color(255, 255, 255));
        tablaGolesLocal.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaGolesLocal.setRowHeight(25);
        tablaGolesLocal.setSelectionBackground(new java.awt.Color(0, 112, 192));
        tablaGolesLocal.setShowVerticalLines(false);
        tablaGolesLocal.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tablaGolesLocal);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add(1).png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clear.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add(1).png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clear.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("-");

        spGolesLocal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Jugador");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Jugador");

        spGolesVisitante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Goles");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Goles");

        txt_local.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_local.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        calendarFechaPartido.setColorBackground(new java.awt.Color(255, 153, 0));
        calendarFechaPartido.setColorForeground(new java.awt.Color(0, 0, 0));
        calendarFechaPartido.setPlaceholder("Seleccionar Fecha");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Hora del partido:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Fecha del partido:");

        txt_buscarJugadorLocal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txt_buscarJugadorLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarJugadorLocalKeyReleased(evt);
            }
        });

        txt_buscarJugadorVisitante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txt_buscarJugadorVisitante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarJugadorVisitanteKeyReleased(evt);
            }
        });

        cmbJugadorVisitante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        cmbJugadorVisitante.setFocusable(false);
        cmbJugadorVisitante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbJugadorVisitanteItemStateChanged(evt);
            }
        });

        jLabel1.setText("HH:MM");

        btnGuardar.setBackground(new java.awt.Color(255, 153, 0));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save(2).png"))); // NOI18N
        btnGuardar.setText("  Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setFocusable(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarjButton2ActionPerformed(evt);
            }
        });

        txt_hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbEquipoLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_buscarJugadorLocal))
                                        .addComponent(cmbJugadorLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spGolesLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_hora))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txt_local, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_visitante, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                            .addComponent(spGolesVisitante, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt_buscarJugadorVisitante)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5))
                                            .addComponent(cmbJugadorVisitante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(lbEquipoVisitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendarFechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122))))
            .addComponent(lbl_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_fecha)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbEquipoLocal)
                        .addComponent(txt_local, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_visitante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbEquipoVisitante)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_buscarJugadorLocal)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_buscarJugadorVisitante)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbJugadorLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spGolesLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spGolesVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbJugadorVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(calendarFechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        dftLocal.setColumnCount(0);
        dftVisitante.setColumnCount(0);
        dftLocal.setRowCount(0);
        dftVisitante.setRowCount(0);
        dftLocal.setColumnIdentifiers(titulos);
        dftVisitante.setColumnIdentifiers(titulos);
        tablaGolesLocal.setModel(dftLocal);;
        tablaGolesVisitante.setModel(dftVisitante);

        TableColumn columnaCeroLocal = tablaGolesLocal.getColumnModel().getColumn(0);
        columnaCeroLocal.setMaxWidth(0);
        columnaCeroLocal.setMinWidth(0);
        columnaCeroLocal.setPreferredWidth(0);
        TableColumn columnaUnoLocal = tablaGolesLocal.getColumnModel().getColumn(1);
        columnaUnoLocal.setMaxWidth(190);
        columnaUnoLocal.setMinWidth(190);
        columnaUnoLocal.setPreferredWidth(190);

        TableColumn columnaCeroVisitante = tablaGolesVisitante.getColumnModel().getColumn(0);
        columnaCeroVisitante.setMaxWidth(0);
        columnaCeroVisitante.setMinWidth(0);
        columnaCeroVisitante.setPreferredWidth(0);
        TableColumn columnaUnoVisitante = tablaGolesVisitante.getColumnModel().getColumn(1);
        columnaUnoVisitante.setMaxWidth(190);
        columnaUnoVisitante.setMinWidth(190);
        columnaUnoVisitante.setPreferredWidth(190);

        lbl_fecha.setText(numeroFecha);
        lbEquipoLocal.setText(nombreEquipoLocal);
        lbEquipoVisitante.setText(nombreEquipoVisitante);

        Leer miLeer = new Leer();
        Cargar miCargar = new Cargar();
        Jugador miJugadorLocal[] = miLeer.leerJugadorIdEquipo(miPartidos.getIdEquipoLocal());
        Jugador miJugadorVisitante[] = miLeer.leerJugadorIdEquipo(miPartidos.getIdEquipoVisitante());
        cmbJugadorLocal.setModel(miCargar.cargarJugadorTorneo(miJugadorLocal));
        cmbJugadorVisitante.setModel(miCargar.cargarJugadorTorneo(miJugadorVisitante));

        Integer golesLocal = new Integer(miPartidos.getGolesEquipoLocal());
        Integer golesVisitante = new Integer(miPartidos.getGolesEquipoVisitante());

        if (miPartidos.getHoraPartido() != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date hora = sdf.parse(miPartidos.getHoraPartido());
                SpinnerDateModel sm = new SpinnerDateModel(hora, null, null, Calendar.HOUR_OF_DAY);
                txt_hora.setModel(sm);
                JSpinner.DateEditor de = new JSpinner.DateEditor(txt_hora, "HH:mm:ss");
                de.getTextField().setEditable(false);
                txt_hora.setEditor(de);
            } catch (ParseException ex) {
                System.out.println("No funciona");
            }
        } else if (miPartidos.getHoraPartido() == null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date hora = sdf.parse("00:00:00");
                SpinnerDateModel sm = new SpinnerDateModel(hora, null, null, Calendar.HOUR_OF_DAY);
                txt_hora.setModel(sm);
                JSpinner.DateEditor de = new JSpinner.DateEditor(txt_hora, "HH:mm:ss");
                de.getTextField().setEditable(false);
                txt_hora.setEditor(de);
            } catch (ParseException ex) {
                Logger.getLogger(MenuPartidoTorneo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            if (miPartidos.getFechaPartido() != null) {
                String fechaPartido = miPartidos.getFechaPartido();
                Date fechaNacimientoDate = dateFormat.parse(fechaPartido);
                calendarFechaPartido.setDatoFecha(fechaNacimientoDate);
            }
        } catch (ParseException e) {
            System.out.println(e);
        }

        if (golesLocal >= 0) {
            txt_local.setText(String.valueOf(miPartidos.getGolesEquipoLocal()));
        } else {
            txt_local.setText("");
        }

        if (golesVisitante >= 0) {
            txt_visitante.setText(String.valueOf(miPartidos.getGolesEquipoVisitante()));
        } else {
            txt_visitante.setText("");
        }

        GoleadorJoinEquipo miGoleadorJoinEquipo[] = miLeer.leerGoleadorPartidoPorIdPartido(idTorneo, miPartidos.getIdPartido());
        if (miGoleadorJoinEquipo != null) {            
            for(int i = 0; i < miGoleadorJoinEquipo.length; i++){
                if(miGoleadorJoinEquipo[i].getNombreEquipo().equals(lbEquipoLocal.getText())){
                    String datosLocal[] = new String[3];
                    datosLocal[0] = String.valueOf(miGoleadorJoinEquipo[i].getIdJugador());
                    datosLocal[1] = miGoleadorJoinEquipo[i].getApellidoJugador()+", "+miGoleadorJoinEquipo[i].getNombreJugador();
                    datosLocal[2] = String.valueOf(miGoleadorJoinEquipo[i].getGolesJugador());
                    dftLocal.addRow(datosLocal);
                    tablaGolesLocal.setModel(dftLocal);            
                    tablaGolesLocal.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
                    tablaGolesLocal.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
                }
                if(miGoleadorJoinEquipo[i].getNombreEquipo().equals(lbEquipoVisitante.getText())){
                    String datosVisitante[] = new String[3];
                    datosVisitante[0] = String.valueOf(miGoleadorJoinEquipo[i].getIdJugador());
                    datosVisitante[1] = miGoleadorJoinEquipo[i].getApellidoJugador()+", "+miGoleadorJoinEquipo[i].getNombreJugador();
                    datosVisitante[2] = String.valueOf(miGoleadorJoinEquipo[i].getGolesJugador());
                    dftVisitante.addRow(datosVisitante);
                    tablaGolesVisitante.setModel(dftVisitante);        
                    tablaGolesVisitante.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
                    tablaGolesVisitante.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
                }                
            }            
        }

    }//GEN-LAST:event_formWindowOpened

    private void txt_buscarJugadorLocalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarJugadorLocalKeyReleased

        Leer miLeer = new Leer();
        Jugador miJugador = miLeer.leerJugadorIdEquipoDinamicamente(txt_buscarJugadorLocal.getText(), miPartidos.getIdEquipoLocal());
        recorrerComboBoxLocal(miJugador);

    }//GEN-LAST:event_txt_buscarJugadorLocalKeyReleased

    private void txt_buscarJugadorVisitanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarJugadorVisitanteKeyReleased

        Leer miLeer = new Leer();
        Jugador miJugador = miLeer.leerJugadorIdEquipoDinamicamente(txt_buscarJugadorVisitante.getText(), miPartidos.getIdEquipoVisitante());
        recorrerComboBoxVisitante(miJugador);

    }//GEN-LAST:event_txt_buscarJugadorVisitanteKeyReleased

    private void cmbJugadorVisitanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbJugadorVisitanteItemStateChanged

    }//GEN-LAST:event_cmbJugadorVisitanteItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Jugador miJugador = (Jugador) cmbJugadorVisitante.getSelectedItem();
        int valor = Integer.parseInt(spGolesVisitante.getValue().toString());
        int repeticionJugadorTablaVisitante = 0;
        if (dftVisitante.getRowCount() == 0) {
            if (miJugador != null) {
                if (valor > 0) {
                    String datos[] = new String[3];
                    datos[0] = String.valueOf(miJugador.getIdJugador());
                    datos[1] = miJugador.toString();
                    datos[2] = String.valueOf(spGolesVisitante.getValue());
                    dftVisitante.addRow(datos);
                    tablaGolesVisitante.setModel(dftVisitante);
                    TableColumn columnaCeroVisitante = tablaGolesVisitante.getColumnModel().getColumn(0);
                    columnaCeroVisitante.setMaxWidth(0);
                    columnaCeroVisitante.setMinWidth(0);
                    columnaCeroVisitante.setPreferredWidth(0);
                    TableColumn columnaUnoVisitante = tablaGolesVisitante.getColumnModel().getColumn(1);
                    columnaUnoVisitante.setMaxWidth(190);
                    columnaUnoVisitante.setMinWidth(190);
                    columnaUnoVisitante.setPreferredWidth(190);
                    tablaGolesVisitante.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
                    tablaGolesVisitante.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
                } else {
                    new alertas.AlertInformation(this, true, "Seleccione cantidad de Goles").setVisible(true);                                    
                }

            } else {
                new alertas.AlertInformation(this, true, "Debe seleccionar un Jugador").setVisible(true);                                
            }
        } else if (dftVisitante.getRowCount() > 0) {
            for (int i = 0; i < dftVisitante.getRowCount(); i++) {
                if (dftVisitante.getValueAt(i, 1).equals(miJugador.toString())) {
                    repeticionJugadorTablaVisitante = 1;
                }
            }

            if (repeticionJugadorTablaVisitante == 0) {
                if (miJugador != null) {
                    if (valor > 0) {
                        String datos[] = new String[3];
                        datos[0] = String.valueOf(miJugador.getIdJugador());
                        datos[1] = miJugador.toString();
                        datos[2] = String.valueOf(spGolesVisitante.getValue());
                        dftVisitante.addRow(datos);
                        tablaGolesVisitante.setModel(dftVisitante);
                        TableColumn columnaCeroVisitante = tablaGolesVisitante.getColumnModel().getColumn(0);
                        columnaCeroVisitante.setMaxWidth(0);
                        columnaCeroVisitante.setMinWidth(0);
                        columnaCeroVisitante.setPreferredWidth(0);
                        TableColumn columnaUnoVisitante = tablaGolesVisitante.getColumnModel().getColumn(1);
                        columnaUnoVisitante.setMaxWidth(190);
                        columnaUnoVisitante.setMinWidth(190);
                        columnaUnoVisitante.setPreferredWidth(190);
                        tablaGolesVisitante.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
                        tablaGolesVisitante.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
                    } else {
                        new alertas.AlertInformation(this, true, "Seleccione cantidad de Goles").setVisible(true);                
                        //JOptionPane.showMessageDialog(null, "Debe Seleccionar la Cantidad de Goles que hizo el jugador");
                    }
                } else {
                        new alertas.AlertInformation(this, true, "Debe seleccionar un Jugador").setVisible(true);                
                    //JOptionPane.showMessageDialog(null, "Debe seleccionar un Jugador");
                }
            } else if (repeticionJugadorTablaVisitante == 1) {
                new alertas.AlertInformation(this, true, "El jugador ya se encuentra en la tabla").setVisible(true);                
                //JOptionPane.showMessageDialog(null, "El Jugador ya se encuentra en la Tabla");
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Jugador miJugador = (Jugador) cmbJugadorLocal.getSelectedItem();
        int valor = Integer.parseInt(spGolesLocal.getValue().toString());
        int repeticionJugadorTablaLocal = 0;
        if (dftLocal.getRowCount() == 0) {
            if (miJugador != null) {
                if (valor > 0) {
                    String datos[] = new String[3];
                    datos[0] = String.valueOf(miJugador.getIdJugador());
                    datos[1] = miJugador.toString();
                    datos[2] = String.valueOf(spGolesLocal.getValue());
                    dftLocal.addRow(datos);
                    tablaGolesLocal.setModel(dftLocal);
                    TableColumn columnaCeroLocal = tablaGolesLocal.getColumnModel().getColumn(0);
                    columnaCeroLocal.setMaxWidth(0);
                    columnaCeroLocal.setMinWidth(0);
                    columnaCeroLocal.setPreferredWidth(0);
                    TableColumn columnaUnoLocal = tablaGolesLocal.getColumnModel().getColumn(1);
                    columnaUnoLocal.setMaxWidth(190);
                    columnaUnoLocal.setMinWidth(190);
                    columnaUnoLocal.setPreferredWidth(190);
                    tablaGolesLocal.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
                    tablaGolesLocal.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
                } else {
                    new alertas.AlertInformation(this, true, "Debe seleccionar un Jugador").setVisible(true);                                                    
                }

            } else {
                new alertas.AlertInformation(this, true, "Debe seleccionar un Jugador").setVisible(true);                                
            }
        } else if (dftLocal.getRowCount() > 0) {
            for (int i = 0; i < dftLocal.getRowCount(); i++) {
                if (dftLocal.getValueAt(i, 1).equals(miJugador.toString())) {
                    repeticionJugadorTablaLocal = 1;
                }
            }

            if (repeticionJugadorTablaLocal == 0) {
                if (miJugador != null) {
                    if (valor > 0) {
                        String datos[] = new String[3];
                        datos[0] = String.valueOf(miJugador.getIdJugador());
                        datos[1] = miJugador.toString();
                        datos[2] = String.valueOf(spGolesLocal.getValue());
                        dftLocal.addRow(datos);
                        tablaGolesLocal.setModel(dftLocal);
                        TableColumn columnaCeroLocal = tablaGolesLocal.getColumnModel().getColumn(0);
                        columnaCeroLocal.setMaxWidth(0);
                        columnaCeroLocal.setMinWidth(0);
                        columnaCeroLocal.setPreferredWidth(0);
                        TableColumn columnaUnoLocal = tablaGolesLocal.getColumnModel().getColumn(1);
                        columnaUnoLocal.setMaxWidth(190);
                        columnaUnoLocal.setMinWidth(190);
                        columnaUnoLocal.setPreferredWidth(190);
                        tablaGolesLocal.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
                        tablaGolesLocal.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
                    } else {
                        new alertas.AlertInformation(this, true, "Debe seleccionar un Jugador").setVisible(true);  
                    }
                } else {
                    new alertas.AlertInformation(this, true, "Debe seleccionar un Jugador").setVisible(true);  
                }
            } else if (repeticionJugadorTablaLocal == 1) {
                new alertas.AlertInformation(this, true, "El jugador ya se encuentra en la tabla").setVisible(true);                                
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if(tablaGolesVisitante.getSelectedRow() >= 0){
            dftVisitante.removeRow(tablaGolesVisitante.getSelectedRow());            
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaGolesVisitanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGolesVisitanteMouseClicked

        if (evt.getClickCount() == 2) {
            String nombre = tablaGolesVisitante.getValueAt(tablaGolesVisitante.getSelectedRow(), 1).toString();
            int idNombre = Integer.parseInt(tablaGolesVisitante.getValueAt(tablaGolesVisitante.getSelectedRow(), 0).toString());
            int goles = Integer.parseInt(tablaGolesVisitante.getValueAt(tablaGolesVisitante.getSelectedRow(), 2).toString());

            Leer miLeer = new Leer();
            Jugador miJugador = miLeer.leerJugadorIdEquipoDinamicamente(nombre, idNombre);
            recorrerComboBoxVisitante(miJugador);
        }

    }//GEN-LAST:event_tablaGolesVisitanteMouseClicked

    private void btnGuardarjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarjButton2ActionPerformed

        Modificar miModificar = new Modificar();
        Partidos miPartidosDos = new Partidos();

        if (!txt_local.getText().trim().isEmpty() && !txt_visitante.getText().trim().isEmpty()) {
            int golesLocal = Integer.parseInt(txt_local.getText().trim());
            int golesVisitante = Integer.parseInt(txt_visitante.getText().trim());
            calcularPosicionLocal();
            calcularPosicionVisitante();
            miPartidosDos.setGolesEquipoLocal(golesLocal);
            miPartidosDos.setGolesEquipoVisitante(golesVisitante);
            miModificar.modificarPartidosLiga(miPartidosDos, idTorneo, idPartido);
        } else if (!txt_local.getText().trim().isEmpty() && txt_visitante.getText().trim().isEmpty()
                || txt_local.getText().trim().isEmpty() && !txt_visitante.getText().trim().isEmpty()) {            
            new alertas.AlertWarning(this, true, "Debe colocar un resultado").setVisible(true);
        }

        JSpinner.DateEditor de = new JSpinner.DateEditor(txt_hora, "HH:mm:ss");
        String horaPartido = de.getFormat().format(txt_hora.getValue());
        if (!horaPartido.equals("00:00:00")) {
            miPartidosDos.setHoraPartido(horaPartido);
            miModificar.modificarHoraPartidosLiga(miPartidosDos, idTorneo, idPartido);
        } else {
            miPartidosDos.setHoraPartido("");
            miModificar.modificarHoraPartidosLiga(miPartidosDos, idTorneo, idPartido);
        }

        Date fechaPartido = calendarFechaPartido.getDatoFecha();
        SimpleDateFormat fechaFormateada = new SimpleDateFormat("yyyy-MM-dd");
        String fechaDelPartido = fechaFormateada.format(fechaPartido);
        if (!fechaDelPartido.isEmpty()) {
            miPartidosDos.setFechaPartido(fechaDelPartido);
            miModificar.modificarFechaPartidosLiga(miPartidosDos, idTorneo, idPartido);
        } else {
            miPartidosDos.setFechaPartido("");
            miModificar.modificarFechaPartidosLiga(miPartidosDos, idTorneo, idPartido);
        }

        Leer miLeer = new Leer();
        Guardar miGuardar = new Guardar();
        if (dftLocal.getRowCount() > 0) {
            for (int i = 0; i < dftLocal.getRowCount(); i++) {
                Goleadores miGoleadorLocalConsulta = miLeer.leerGoleadorPartido(idTorneo, Integer.parseInt(tablaGolesLocal.getValueAt(i, 0).toString()), miPartidos.getIdPartido());
                if (miGoleadorLocalConsulta.getIdJugador() >= 0) {
                    GoleadorPartido miGoleadorPartidoLocal = new GoleadorPartido();
                    miGoleadorPartidoLocal.setIdPartido(miPartidos.getIdPartido());
                    miGoleadorPartidoLocal.setIdTorneo(idTorneo);
                    miGoleadorPartidoLocal.setIdEquipo(miPartidos.getIdEquipoLocal());
                    miGoleadorPartidoLocal.setIdJugador(Integer.parseInt(tablaGolesLocal.getValueAt(i, 0).toString()));
                    miGoleadorPartidoLocal.setCantidadGoles(Integer.parseInt(tablaGolesLocal.getValueAt(i, 2).toString()));
                    miGuardar.guardarGoleadorPartido(miGoleadorPartidoLocal);
                }
            }
        }
        if (dftVisitante.getRowCount() > 0) {
            for (int i = 0; i < dftVisitante.getRowCount(); i++) {
                Goleadores miGoleadoresVisitanteConsulta = miLeer.leerGoleadorPartido(idTorneo, Integer.parseInt(tablaGolesVisitante.getValueAt(i, 0).toString()), miPartidos.getIdPartido());
                if (miGoleadoresVisitanteConsulta.getIdJugador() >= 0) {                    
                    GoleadorPartido miGoleadorPartidoVisitante = new GoleadorPartido();
                    miGoleadorPartidoVisitante.setIdPartido(miPartidos.getIdPartido());
                    miGoleadorPartidoVisitante.setIdTorneo(idTorneo);
                    miGoleadorPartidoVisitante.setIdEquipo(miPartidos.getIdEquipoVisitante());
                    miGoleadorPartidoVisitante.setIdJugador(Integer.parseInt(tablaGolesVisitante.getValueAt(i, 0).toString()));
                    miGoleadorPartidoVisitante.setCantidadGoles(Integer.parseInt(tablaGolesVisitante.getValueAt(i, 2).toString()));
                    miGuardar.guardarGoleadorPartido(miGoleadorPartidoVisitante);
                }
            }
        }

        new alertas.AlertSuccess(this, true, "Partido guardado correctamente").setVisible(true);
        
        
        dispose();
        
        corroborarCampeon();

    }//GEN-LAST:event_btnGuardarjButton2ActionPerformed

    private void tablaGolesVisitanteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGolesVisitanteMousePressed
                                
        GoleadorJoinEquipo miGoleadorJoinEquipo = new GoleadorJoinEquipo();
        miGoleadorJoinEquipo.setIdJugador(Integer.parseInt(tablaGolesVisitante.getValueAt(tablaGolesVisitante.getSelectedRow(), 0).toString()));
        Jugador miJugadorDos;
        
        for(int i = 0; i < cmbJugadorVisitante.getItemCount(); i++){
                       
            miJugadorDos = (Jugador) cmbJugadorVisitante.getItemAt(i);
            
            if(miGoleadorJoinEquipo.getIdJugador() == miJugadorDos.getIdJugador()){
                spGolesVisitante.setValue(Integer.parseInt(tablaGolesVisitante.getValueAt(tablaGolesVisitante.getSelectedRow(), 2).toString()));
                cmbJugadorVisitante.setSelectedIndex(i);
                break;
            }
            
        }
        
    }//GEN-LAST:event_tablaGolesVisitanteMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(tablaGolesLocal.getSelectedRow() >= 0){
            dftLocal.removeRow(tablaGolesLocal.getSelectedRow());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPartidoTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPartidoTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPartidoTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPartidoTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuPartidoTorneo dialog = new MenuPartidoTorneo(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private rojeru_san.componentes.RSDateChooser calendarFechaPartido;
    private javax.swing.JComboBox<Jugador> cmbJugadorLocal;
    private javax.swing.JComboBox<Jugador> cmbJugadorVisitante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbEquipoLocal;
    private javax.swing.JLabel lbEquipoVisitante;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JSpinner spGolesLocal;
    private javax.swing.JSpinner spGolesVisitante;
    private javax.swing.JTable tablaGolesLocal;
    private javax.swing.JTable tablaGolesVisitante;
    private javax.swing.JTextField txt_buscarJugadorLocal;
    private javax.swing.JTextField txt_buscarJugadorVisitante;
    private javax.swing.JSpinner txt_hora;
    private javax.swing.JTextField txt_local;
    private javax.swing.JTextField txt_visitante;
    // End of variables declaration//GEN-END:variables
}
