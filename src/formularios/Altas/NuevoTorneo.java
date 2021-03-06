/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios.Altas;

import clases.Equipo;
import clases.Posiciones;
import clases.RoundRobin;
import clases.Torneo;
import formularios.BuscarEquipoJoinTorneo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import metodos.CentralizarColumnasJTable;
import metodos.Guardar;
import metodos.Leer;

/**
 *
 * @author Federico Melo
 */
public class NuevoTorneo extends javax.swing.JDialog {

    public static DefaultTableModel dft = new DefaultTableModel();
    private TableCellRenderer columnasCentralizadas = new CentralizarColumnasJTable();
    private int idUsuario;

    public NuevoTorneo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Crear Torneo ");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
    }

    public NuevoTorneo(java.awt.Frame parent, boolean modal, int idUsuario) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.idUsuario = idUsuario;
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Crear Torneo ");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        tablaEquipo.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaEquipo.getTableHeader().setOpaque(false);
        tablaEquipo.getTableHeader().setBackground(new Color(255, 153, 0));
        tablaEquipo.getTableHeader().setForeground(new Color(255, 255, 255));
        cmb_formato.setBackground(Color.WHITE);
    }

    private void propiedadesTabla() {

        tablaEquipo.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
        tablaEquipo.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
        tablaEquipo.getColumnModel().getColumn(3).setCellRenderer(columnasCentralizadas);

        TableColumn columnaCero = tablaEquipo.getColumnModel().getColumn(0);
        columnaCero.setMaxWidth(0);
        columnaCero.setMinWidth(0);
        columnaCero.setPreferredWidth(0);

    }

    public void limpiarTabla(JTable tabla) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = tabla.getRowCount();

        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmb_formato = new javax.swing.JComboBox<>();
        sp_cantEquipos = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaEquipo = new javax.swing.JTable();

        jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jPopupMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        itemEliminar.setBackground(new java.awt.Color(255, 255, 255));
        itemEliminar.setText("Eliminar");
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nuevo Torneo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Nombre:");

        txt_nombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txt_nombre.setPreferredSize(new java.awt.Dimension(2, 28));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save(2).png"))); // NOI18N
        jButton2.setText(" Guardar");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad de Equipos:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Formato:");

        cmb_formato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_formato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>", "Ida", "Ida y Vuelta" }));
        cmb_formato.setSelectedItem(-1);
        cmb_formato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        cmb_formato.setMinimumSize(new java.awt.Dimension(57, 28));

        sp_cantEquipos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sp_cantEquipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        jLabel1.setText("* Desde 3 hasta 32 equipos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(sp_cantEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_formato, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sp_cantEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cmb_formato, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add (1).png"))); // NOI18N
        jButton1.setText(" Agregar Equipo");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaEquipo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaEquipo.setComponentPopupMenu(jPopupMenu1);
        tablaEquipo.setGridColor(new java.awt.Color(255, 255, 255));
        tablaEquipo.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaEquipo.setRowHeight(25);
        tablaEquipo.setSelectionBackground(new java.awt.Color(0, 112, 192));
        tablaEquipo.setShowVerticalLines(false);
        tablaEquipo.getTableHeader().setReorderingAllowed(false);
        tablaEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEquipoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaEquipo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(307, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(73, Short.MAX_VALUE)))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Guardar miGuardar = new Guardar();
        Torneo miTorneo = new Torneo();
        Leer miLeer = new Leer();

        if (!txt_nombre.getText().trim().isEmpty() && !cmb_formato.getSelectedItem().equals("<Seleccionar>")) {

            int spinner = Integer.parseInt(sp_cantEquipos.getValue().toString());
            TableModel tableModel = tablaEquipo.getModel();
            int filas = tableModel.getRowCount();

            if (spinner >= 3 && 32 >= spinner) {

                miTorneo.setNombreTorneo(txt_nombre.getText().trim());
                miTorneo.setCantidadEquipos(spinner);
                miTorneo.setCantidadFechas(spinner - 1);
                miTorneo.setFormatoTorneo(cmb_formato.getSelectedItem().toString());
                miTorneo.setEstadoTorneo("Alta");
                miTorneo.setIdUsuario(idUsuario);
                miGuardar.guardarTorneo(miTorneo);
                Equipo miEquipoArray[] = new Equipo[filas];

                for (int i = 0; i < filas; i++) {

                    Equipo miEquipo = new Equipo();
                    miEquipo.setIdEquipo(Integer.parseInt(tablaEquipo.getValueAt(i, 0).toString()));
                    miEquipo.setNombreEquipo(tablaEquipo.getValueAt(i, 1).toString());
                    miGuardar.guardarTorneoEquipo(miLeer.LeerIdTorneo(miTorneo), miEquipo);
                    miEquipoArray[i] = miEquipo;
                }

                RoundRobin miRoundRobin = new RoundRobin();
                miRoundRobin.combinarEquiposParFormatoIda(miEquipoArray);

                int idTorneo = miLeer.LeerIdTorneo(miTorneo);

                for (int i = 0; i < miEquipoArray.length - 1; i++) {

                    miRoundRobin.mostrarFormatoIda(idTorneo, i + 1, miEquipoArray);
                    miRoundRobin.combinarEquiposParFormatoIda(miEquipoArray);

                }

                Equipo miEquipo[] = miLeer.leerEquiposTorneo(idTorneo);

                for (int i = 0; i < miEquipo.length; i++) {
                    Posiciones miPosiciones = new Posiciones();
                    miPosiciones.setIdTorneo(idTorneo);
                    miPosiciones.setIdEquipo(miEquipo[i].getIdEquipo());
                    miPosiciones.setPartidosJugados(0);
                    miPosiciones.setPartidosGanados(0);
                    miPosiciones.setPartidosEmpatados(0);
                    miPosiciones.setPartidosPerdidos(0);
                    miPosiciones.setGolesFavor(0);
                    miPosiciones.setGolesContra(0);
                    miPosiciones.setDiferenciaGoles(0);
                    miPosiciones.setPuntos(0);
                    miGuardar.guardarTablaPosiciones(miEquipo[i].getIdEquipo(), idTorneo, miPosiciones);
                }

                Presentacion miPresentacion = new Presentacion(this, true);
                miPresentacion.setVisible(true);

            } else if (spinner < 3) {

                new alertas.AlertInformation(this, true, "Deben ser un mínimo de 3 equipos").setVisible(true);

            }

        } else {

            new alertas.AlertInformation(this, true, "Debes completar todos los campos").setVisible(true);

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        BuscarEquipoJoinTorneo miBuscarEquipoJoinJugador = new BuscarEquipoJoinTorneo(this, true, idUsuario);
        miBuscarEquipoJoinJugador.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        String titulos[] = new String[4];

        titulos[0] = "ID";
        titulos[1] = "Nombre";
        titulos[2] = "Estadio";
        titulos[3] = "Dirección";

        dft.setColumnIdentifiers(titulos);
        tablaEquipo.setModel(dft);
        propiedadesTabla();

    }//GEN-LAST:event_formWindowOpened

    private void tablaEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEquipoMouseClicked

    }//GEN-LAST:event_tablaEquipoMouseClicked

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed

        dft.removeRow(tablaEquipo.getSelectedRow());

    }//GEN-LAST:event_itemEliminarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        limpiarTabla(tablaEquipo);

    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(NuevoTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoTorneo dialog = new NuevoTorneo(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cmb_formato;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner sp_cantEquipos;
    public static javax.swing.JTable tablaEquipo;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
