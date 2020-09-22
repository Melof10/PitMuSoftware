/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import alertas.CampeonGoleadorTorneo;
import clases.GoleadorJoinEquipo;
import clases.Partidos;
import clases.PosicionesJoinEquipo;
import formularios.consulta.TablaGoleadores;
import formularios.consulta.TablaPosiciones;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import metodos.Cargar;
import metodos.Leer;
import metodos.CentralizarColumnasJTable;

public class MenuTorneo extends javax.swing.JDialog {

    private int idUsuario;
    private int idTorneo; 
    String nombreTorneo;
    private TableCellRenderer columnasCentralizadas = new CentralizarColumnasJTable();
    private String titulos [] = new String[10];
    private String nombreEquipoLocal;
    private String nombreEquipoVisitante;
    public DefaultTableModel dtf = new DefaultTableModel();
    
    public MenuTorneo(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Gestionar Torneo");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
    }
    
    public MenuTorneo() {    
        initComponents();
        setLocationRelativeTo(null);
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Gestionar Torneo");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
    }
    
    public MenuTorneo(javax.swing.JDialog parent, boolean modal, int idTorneo, int idUsuario, String nombreTorneo) {
        super(parent, modal);       
        initComponents();
        this.idTorneo = idTorneo;
        this.idUsuario = idUsuario;
        this.nombreTorneo = nombreTorneo;
        titulos[0] = "ID"; 
        titulos[1] = "Fecha";
        titulos[2] = "Hora";
        titulos[3] = "Estadio";
        titulos[4] = "Local";
        titulos[5] = "ID Local";
        titulos[6] = "   ";
        titulos[7] = "   ";
        titulos[8] = "Visitante";
        titulos[9] = "ID Visitante";         
        setLocationRelativeTo(null);
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Gestionar Torneo");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        // Personaliza el JTable              
        tablaPartido.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaPartido.getTableHeader().setOpaque(false);
        tablaPartido.getTableHeader().setBackground(new Color(255,153,0));
        tablaPartido.getTableHeader().setForeground(new Color(255,255,255));
        tablaPartido.setRowHeight(25);            
        // Personaliza comboBox
        comboBoxFechas.setBackground(Color.WHITE);             
    }    
    
    public String[] mostrarNombresEquipoLocal(int fecha){
        Leer miLeer = new Leer();                
        Partidos miPartido [] = miLeer.leerPartidoPorFecha(idTorneo, fecha);
        int equipoLocal [] = new int[miPartido.length];        
        String nombreEquipoLocal [] = new String[miPartido.length]; 
        for(int i = 0; i < miPartido.length; i++){            
            equipoLocal[i] = miPartido[i].getIdEquipoLocal();            
        }        
        
        for(int i = 0; i < miPartido.length; i++){
            nombreEquipoLocal[i] = miLeer.leerNombreEquipoLocal(equipoLocal[i], idTorneo);            
        }       
        return nombreEquipoLocal;
    }
    
    public String[] mostrarNombresEquipoVisitante(int fecha){    
        Leer miLeer = new Leer();        
        Partidos miPartido [] = miLeer.leerPartidoPorFecha(idTorneo, fecha);
        int equipoVisitante [] = new int[miPartido.length];        
        String nombreEquipoVisitante [] = new String[miPartido.length];
        for(int i = 0; i < miPartido.length; i++){            
            equipoVisitante[i] = miPartido[i].getIdEquipoVisitante();            
        }                
        for(int i = 0; i < miPartido.length; i++){            
            nombreEquipoVisitante[i] = miLeer.leerNombreEquipoVisitante(equipoVisitante[i], idTorneo);
        }                    
        return nombreEquipoVisitante;
    }           
    
    public void propiedadesTabla(){
        
        tablaPartido.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);        
        tablaPartido.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
        tablaPartido.getColumnModel().getColumn(3).setCellRenderer(columnasCentralizadas);
        tablaPartido.getColumnModel().getColumn(4).setCellRenderer(columnasCentralizadas);                                
        tablaPartido.getColumnModel().getColumn(5).setCellRenderer(columnasCentralizadas);  
        tablaPartido.getColumnModel().getColumn(6).setCellRenderer(columnasCentralizadas); 
        tablaPartido.getColumnModel().getColumn(7).setCellRenderer(columnasCentralizadas); 
        tablaPartido.getColumnModel().getColumn(8).setCellRenderer(columnasCentralizadas); 
        
        TableColumn columnaCero = tablaPartido.getColumnModel().getColumn(0);
        columnaCero.setMaxWidth(0);
        columnaCero.setMinWidth(0);
        columnaCero.setPreferredWidth(0);       
        TableColumn columnaDos = tablaPartido.getColumnModel().getColumn(5);
        columnaDos.setMaxWidth(0);
        columnaDos.setMinWidth(0);
        columnaDos.setPreferredWidth(0);   
        TableColumn columnaCinco = tablaPartido.getColumnModel().getColumn(9);
        columnaCinco.setMaxWidth(0);
        columnaCinco.setMinWidth(0);
        columnaCinco.setPreferredWidth(0);   
        
        TableColumn columnaTres = tablaPartido.getColumnModel().getColumn(6);
        columnaTres.setMaxWidth(30);
        columnaTres.setMinWidth(30);
        columnaTres.setPreferredWidth(30);
        TableColumn columnaCuatro = tablaPartido.getColumnModel().getColumn(7);
        columnaCuatro.setMaxWidth(30);
        columnaCuatro.setMinWidth(30);
        columnaCuatro.setPreferredWidth(30);       
        
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxFechas = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaPartido = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Torneo"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nro. de Fecha:");

        comboBoxFechas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        comboBoxFechas.setFocusable(false);
        comboBoxFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFechasActionPerformed(evt);
            }
        });

        tablaPartido = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaPartido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPartido.setGridColor(new java.awt.Color(255, 255, 255));
        tablaPartido.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaPartido.setRowHeight(25);
        tablaPartido.setSelectionBackground(new java.awt.Color(0, 112, 192));
        tablaPartido.setShowVerticalLines(false);
        tablaPartido.getTableHeader().setReorderingAllowed(false);
        tablaPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPartidoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaPartido);

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("* Doble click en el partido para colocar el resultado");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/list.png"))); // NOI18N
        jButton1.setText("  Posiciones");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/goleador.png"))); // NOI18N
        jButton3.setText("  Goleadores");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboBoxFechas))
                        .addGap(323, 323, 323))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel4)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(62, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                                       
        Cargar miCargar = new Cargar();
        Leer miLeer = new Leer();
        Partidos [] miFechasTorneo = miLeer.fechasTorneo(idTorneo);        
        comboBoxFechas.setModel(miCargar.cargarFechasTorneo(miFechasTorneo));                
        
        Partidos miPartidosPorFecha = (Partidos) comboBoxFechas.getSelectedItem();
        int fecha = miPartidosPorFecha.getNumFechaTorneo();                             
                
        tablaPartido = miCargar.cargarPartidosPorFecha(tablaPartido, miLeer.leerPartidoPorFecha(idTorneo, fecha), titulos, mostrarNombresEquipoLocal(fecha), mostrarNombresEquipoVisitante(fecha));                
        
        propiedadesTabla();        
        
        corroborarCampeon();        
        
    }//GEN-LAST:event_formWindowOpened

    private void comboBoxFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFechasActionPerformed
        
        Cargar miCargar = new Cargar();
        Leer miLeer = new Leer();
        Partidos miPartidosPorFecha = (Partidos) comboBoxFechas.getSelectedItem();
        int fecha = miPartidosPorFecha.getNumFechaTorneo();                        
        
        tablaPartido = miCargar.cargarPartidosPorFecha(tablaPartido, miLeer.leerPartidoPorFecha(idTorneo, fecha), titulos, mostrarNombresEquipoLocal(fecha), mostrarNombresEquipoVisitante(fecha));
        
        propiedadesTabla();
        
    }//GEN-LAST:event_comboBoxFechasActionPerformed

    private void tablaPartidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPartidoMouseClicked
        
        if (evt.getClickCount() == 2) {
            
            Partidos miPartidos = new Partidos();
            miPartidos.setIdPartido(Integer.parseInt(tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 0).toString()));                    
            miPartidos.setIdTorneo(idTorneo);                    
            if(!tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 1).toString().equals("")){                                
                miPartidos.setFechaPartido(tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 1).toString());
            }
            if(!tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 2).toString().equals("")){                
                miPartidos.setHoraPartido(tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 2).toString());
            }            
            nombreEquipoLocal = tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 4).toString();
            miPartidos.setIdEquipoLocal(Integer.parseInt(tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 5).toString()));
            if(!tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 6).toString().equals("")){                
                miPartidos.setGolesEquipoLocal(Integer.parseInt(tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 6).toString()));                
            }else{
                miPartidos.setGolesEquipoLocal(-1);
            }
            if(!tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 7).toString().equals("")){                
                miPartidos.setGolesEquipoVisitante(Integer.parseInt(tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 7).toString()));
            }else{
                miPartidos.setGolesEquipoVisitante(-1);
            }
            nombreEquipoVisitante = tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 8).toString();
            miPartidos.setIdEquipoVisitante(Integer.parseInt(tablaPartido.getValueAt(tablaPartido.getSelectedRow(), 9).toString()));            
                        
            MenuPartidoTorneo miMenuPartidoTorneo = new MenuPartidoTorneo(this, true, miPartidos, nombreEquipoLocal, nombreEquipoVisitante, comboBoxFechas.getSelectedItem().toString(), idTorneo, miPartidos.getIdPartido(), idUsuario, nombreTorneo);
            miMenuPartidoTorneo.setVisible(true);
            
        }        
        
    }//GEN-LAST:event_tablaPartidoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        TablaPosiciones miPosiciones = new TablaPosiciones(this, true, idTorneo);
        miPosiciones.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        TablaGoleadores miTablaGoleadores = new TablaGoleadores(this, true, idTorneo);
        miTablaGoleadores.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        Cargar miCargar = new Cargar();
        Leer miLeer = new Leer();
        Partidos [] miFechasTorneo = miLeer.fechasTorneo(idTorneo);        
        comboBoxFechas.setModel(miCargar.cargarFechasTorneo(miFechasTorneo));                
        
        Partidos miPartidosPorFecha = (Partidos) comboBoxFechas.getSelectedItem();
        int fecha = miPartidosPorFecha.getNumFechaTorneo();                             
                
        tablaPartido = miCargar.cargarPartidosPorFecha(tablaPartido, miLeer.leerPartidoPorFecha(idTorneo, fecha), titulos, mostrarNombresEquipoLocal(fecha), mostrarNombresEquipoVisitante(fecha));                
        
        propiedadesTabla();                    
        
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set tcomboBoxCategorias and feel */
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
            java.util.logging.Logger.getLogger(MenuTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuTorneo dialog = new MenuTorneo(new javax.swing.JDialog(), true);
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
    public static javax.swing.JComboBox<String> comboBoxFechas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    public static javax.swing.JTable tablaPartido;
    // End of variables declaration//GEN-END:variables
}
