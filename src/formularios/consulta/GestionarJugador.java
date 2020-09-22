/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios.consulta;

import clases.Jugador;
import com.placeholder.PlaceHolder;
import static formularios.MenuTorneo.tablaPartido;
import formularios.modificar.ModificarJugador;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import metodos.Cargar;
import metodos.CentralizarColumnasJTable;
import metodos.Leer;
import metodos.Modificar;

/**
 *
 * @author Federico Melo
 */
public class GestionarJugador extends javax.swing.JDialog {

    private TableCellRenderer columnasCentralizadas = new CentralizarColumnasJTable();
    String titulos[] = new String[8];
    private int idUsuario;

    public GestionarJugador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Gestionar Jugador");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        PlaceHolder miPlaceHolder = new PlaceHolder(txt_buscar, " Buscar Jugador");
    }

    public GestionarJugador(java.awt.Frame parent, boolean modal, int idUsuario) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.idUsuario = idUsuario;
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Gestionar Jugador");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        PlaceHolder miPlaceHolder = new PlaceHolder(txt_buscar, " Buscar Jugador por Nombre, Apellido o DNI");
        // Personaliza el JTable              
        tablaJugador.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaJugador.getTableHeader().setOpaque(false);
        tablaJugador.getTableHeader().setBackground(new Color(255, 153, 0));
        tablaJugador.getTableHeader().setForeground(new Color(255, 255, 255));
        cmbDatos.setBackground(Color.WHITE);

    }

    public void cargarTabla(int idUsuario) {
        titulos[0] = "ID";
        titulos[1] = "Nombre";
        titulos[2] = "Apellido";
        titulos[3] = "DNI";
        titulos[4] = "Domicilio";
        titulos[5] = "Teléfono";
        titulos[6] = "Estatura";
        titulos[7] = "Posición";

        Leer miLeer = new Leer();
        Cargar miCargar = new Cargar();
        tablaJugador = miCargar.cargarJugador(tablaJugador, miLeer.leerJugador(idUsuario), titulos);
    }

    private void propiedadesTabla() {

        tablaJugador.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
        tablaJugador.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
        tablaJugador.getColumnModel().getColumn(3).setCellRenderer(columnasCentralizadas);
        tablaJugador.getColumnModel().getColumn(4).setCellRenderer(columnasCentralizadas);
        tablaJugador.getColumnModel().getColumn(5).setCellRenderer(columnasCentralizadas);
        tablaJugador.getColumnModel().getColumn(6).setCellRenderer(columnasCentralizadas);
        tablaJugador.getColumnModel().getColumn(7).setCellRenderer(columnasCentralizadas);

        TableColumn columnaCero = tablaJugador.getColumnModel().getColumn(0);
        columnaCero.setMaxWidth(0);
        columnaCero.setMinWidth(0);
        columnaCero.setPreferredWidth(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemModificar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaJugador = new javax.swing.JTable();
        cmbDatos = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jPopupMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        itemModificar.setBackground(new java.awt.Color(255, 255, 255));
        itemModificar.setText("Modificar");
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemModificar);

        jSeparator1.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 153, 0));
        jPopupMenu1.add(jSeparator1);

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
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gestionar Jugador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txt_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txt_buscar.setPreferredSize(new java.awt.Dimension(2, 32));
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        tablaJugador = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaJugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaJugador.setComponentPopupMenu(jPopupMenu1);
        tablaJugador.setGridColor(new java.awt.Color(255, 255, 255));
        tablaJugador.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaJugador.setRowHeight(25);
        tablaJugador.setSelectionBackground(new java.awt.Color(0, 112, 192));
        tablaJugador.setShowVerticalLines(false);
        tablaJugador.getTableHeader().setReorderingAllowed(false);
        tablaJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJugadorMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaJugador);

        cmbDatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbDatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "DNI" }));
        cmbDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        cmbDatos.setFocusable(false);
        cmbDatos.setPreferredSize(new java.awt.Dimension(77, 30));
        cmbDatos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDatosItemStateChanged(evt);
            }
        });
        cmbDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDatosActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscadorDos.png"))); // NOI18N
        jToggleButton1.setText("  Buscar");
        jToggleButton1.setBorder(null);
        jToggleButton1.setPreferredSize(new java.awt.Dimension(105, 28));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        jToggleButton2.setBorder(null);
        jToggleButton2.setPreferredSize(new java.awt.Dimension(105, 28));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(cmbDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla(idUsuario);
        propiedadesTabla();
    }//GEN-LAST:event_formWindowOpened

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed

        Jugador miJugador = new Jugador();
        miJugador.setIdJugador(Integer.parseInt(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 0).toString()));
        miJugador.setNombreJugador(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 1).toString());
        miJugador.setApellidoJugador(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 2).toString());
        miJugador.setDniJugador(Long.parseLong(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 3).toString()));
        miJugador.setDomicilioJugador(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 4).toString());
        miJugador.setTelefonoJugador(Long.parseLong(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 5).toString()));
        miJugador.setEstaturaJugador(Double.parseDouble(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 6).toString()));
        miJugador.setPosicionJugador(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 7).toString());
        ModificarJugador miModificarJugador;
        try {
            miModificarJugador = new ModificarJugador(new javax.swing.JDialog(), true, miJugador);
            miModificarJugador.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(GestionarJugador.class.getName()).log(Level.SEVERE, null, ex);
        }

        cargarTabla(idUsuario);

    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed

        if (tablaJugador.getSelectedRow() >= 0) {
            Modificar miModificar = new Modificar();
            miModificar.darBajaJugador(Integer.parseInt(tablaJugador.getValueAt(tablaJugador.getSelectedRow(), 0).toString()), idUsuario);            
            cargarTabla(idUsuario);
            propiedadesTabla();
        } else if (tablaJugador.getSelectedRow() < 0) {
            new alertas.AlertWarning(this, true, "Debes seleccionar la fila").setVisible(true);            
        }

    }//GEN-LAST:event_itemEliminarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased


    }//GEN-LAST:event_txt_buscarKeyReleased

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed


    }//GEN-LAST:event_txt_buscarKeyPressed

    private void tablaJugadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJugadorMouseClicked

    }//GEN-LAST:event_tablaJugadorMouseClicked

    private void cmbDatosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDatosItemStateChanged

    }//GEN-LAST:event_cmbDatosItemStateChanged

    private void cmbDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDatosActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        titulos[0] = "ID";
        titulos[1] = "Nombre";
        titulos[2] = "Apellido";
        titulos[3] = "DNI";
        titulos[4] = "Domicilio";
        titulos[5] = "Teléfono";
        titulos[6] = "Estatura";
        titulos[7] = "Posición";
        Leer miLeer = new Leer();
        Cargar miCargar = new Cargar();

        if (cmbDatos.getSelectedItem().equals("Nombre")) {
            tablaJugador = miCargar.cargarJugador(tablaJugador, miLeer.buscarJugadoresPorNombre(txt_buscar.getText().trim(), idUsuario), titulos);
        } else if (cmbDatos.getSelectedItem().equals("Apellido")) {
            tablaJugador = miCargar.cargarJugador(tablaJugador, miLeer.buscarJugadoresPorApellido(txt_buscar.getText().trim(), idUsuario), titulos);
        } else if (cmbDatos.getSelectedItem().equals("DNI")) {
            tablaJugador = miCargar.cargarJugador(tablaJugador, miLeer.buscarJugadoresPorDni(txt_buscar.getText().trim(), idUsuario), titulos);
        }

        propiedadesTabla();

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

        txt_buscar.setText("");
        cargarTabla(idUsuario);
        propiedadesTabla();

    }//GEN-LAST:event_jToggleButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarJugador dialog = new GestionarJugador(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cmbDatos;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JMenuItem itemModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    public static javax.swing.JTable tablaJugador;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables

}
