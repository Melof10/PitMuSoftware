/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios.consulta;

import clases.Torneo;
import com.placeholder.PlaceHolder;
import formularios.MenuTorneo;
import formularios.modificar.ModificarTorneo;
import java.awt.Color;
import java.awt.Font;
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
 * @author Federico
 */
public class GestionarTorneo extends javax.swing.JDialog {
    
    private TableCellRenderer columnasCentralizadas = new CentralizarColumnasJTable();
    private int idUsuario;    
    
    public GestionarTorneo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);        
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Gestionar Torneo");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        PlaceHolder miPlaceHolder = new PlaceHolder(txt_buscar, "Buscar Torneo");       
    }
    
    public GestionarTorneo(java.awt.Frame parent, boolean modal, int idUsuario){
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.idUsuario = idUsuario;
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Gestionar Torneo");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        PlaceHolder miPlaceHolder = new PlaceHolder(txt_buscar, " Buscar por nombre de Torneo");
        // Personaliza el JTable              
        tablaTorneo.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaTorneo.getTableHeader().setOpaque(false);
        tablaTorneo.getTableHeader().setBackground(new Color(255,153,0));
        tablaTorneo.getTableHeader().setForeground(new Color(255,255,255));              
    }

    private void cargarTorneos(int idUsuario){
        
        String titulos [] = new String [5];
        titulos[0] = "ID";
        titulos[1] = "Nombre";
        titulos[2] = "Equipos";
        titulos[3] = "Fechas";
        titulos[4] = "Formato";
        
        Leer miLeer = new Leer();
        Torneo miTorneo [] = miLeer.leerTorneos(idUsuario);
        Cargar miCargar = new Cargar();
        tablaTorneo = miCargar.cargarTorneos(tablaTorneo, miTorneo, titulos);
        
    }    
    
    private void propiedadesTabla(){
        
        tablaTorneo.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
        tablaTorneo.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
        tablaTorneo.getColumnModel().getColumn(3).setCellRenderer(columnasCentralizadas);                                
        tablaTorneo.getColumnModel().getColumn(4).setCellRenderer(columnasCentralizadas);  
        
        TableColumn columnaCero = tablaTorneo.getColumnModel().getColumn(0);
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
        tablaTorneo = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jPopupMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        itemModificar.setBackground(new java.awt.Color(255, 255, 255));
        itemModificar.setText("Modificar");
        itemModificar.setBorder(null);
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
        itemEliminar.setBorder(null);
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
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gestionar Torneo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txt_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txt_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        tablaTorneo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaTorneo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaTorneo.setComponentPopupMenu(jPopupMenu1);
        tablaTorneo.setGridColor(new java.awt.Color(255, 255, 255));
        tablaTorneo.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaTorneo.setRowHeight(25);
        tablaTorneo.setSelectionBackground(new java.awt.Color(0, 112, 192));
        tablaTorneo.setShowVerticalLines(false);
        tablaTorneo.getTableHeader().setReorderingAllowed(false);
        tablaTorneo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTorneoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaTorneo);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
                       
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTorneos(idUsuario);
        propiedadesTabla();
    }//GEN-LAST:event_formWindowOpened

    private void tablaTorneoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTorneoMouseClicked
        
        if (evt.getClickCount() == 2) {
            int idTorneo = Integer.parseInt(tablaTorneo.getValueAt(tablaTorneo.getSelectedRow(), 0).toString());        
            MenuTorneo miMenuTorneo = new MenuTorneo(this, true, idTorneo, idUsuario, tablaTorneo.getValueAt(tablaTorneo.getSelectedRow(), 1).toString());            
            miMenuTorneo.setVisible(true);
        }          
        
    }//GEN-LAST:event_tablaTorneoMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
        String titulos [] = new String [5];
        titulos[0] = "ID";
        titulos[1] = "Nombre";
        titulos[2] = "Equipos";
        titulos[3] = "Fechas";
        titulos[4] = "Formato";
        
        Leer miLeer = new Leer();
        Cargar miCargar = new Cargar();        
        
        tablaTorneo = miCargar.cargarTorneosDinamicamente(tablaTorneo, miLeer.leerTorneosPorNombre(txt_buscar.getText().trim(), idUsuario), titulos);
        
        propiedadesTabla();
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        
        cargarTorneos(idUsuario);
        propiedadesTabla();
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed

        ModificarTorneo miModificarTorneo = new ModificarTorneo(this, true, idUsuario, Integer.parseInt(tablaTorneo.getValueAt(tablaTorneo.getSelectedRow(), 0).toString()), tablaTorneo.getValueAt(tablaTorneo.getSelectedRow(), 1).toString());
        miModificarTorneo.setVisible(true);

    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed

        Modificar miModificar = new Modificar();
        miModificar.darBajaTorneo(Integer.parseInt(tablaTorneo.getValueAt(tablaTorneo.getSelectedRow(), 0).toString()), idUsuario);
        new alertas.AlertSuccess(this, true, "El torneo se dió de baja correctamente").setVisible(true);        
        cargarTorneos(idUsuario);
        propiedadesTabla();
        
    }//GEN-LAST:event_itemEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarTorneo dialog = new GestionarTorneo(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JMenuItem itemModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    public static javax.swing.JTable tablaTorneo;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
