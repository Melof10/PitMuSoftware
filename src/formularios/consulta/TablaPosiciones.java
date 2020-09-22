package formularios.consulta;

import clases.PosicionesJoinEquipo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import metodos.Cargar;
import metodos.CentralizarColumnasJTable;
import metodos.Leer;

public class TablaPosiciones extends javax.swing.JDialog {

    private int idTorneo;
    private TableCellRenderer columnasCentralizadas = new CentralizarColumnasJTable();

    public TablaPosiciones(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public TablaPosiciones(javax.swing.JDialog parent, boolean modal, int idTorneo) {
        super(parent, modal);
        initComponents();
        this.idTorneo = idTorneo;
        setLocationRelativeTo(null);
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Tabla de Posiciones");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        // Personaliza el JTable              
        tablaPosiciones.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaPosiciones.getTableHeader().setOpaque(false);
        tablaPosiciones.getTableHeader().setBackground(new Color(255, 153, 0));
        tablaPosiciones.getTableHeader().setForeground(new Color(255, 255, 255));
        tablaPosiciones.setRowHeight(25);
    }

    private void propiedadesTabla() {

        tablaPosiciones.getColumnModel().getColumn(0).setCellRenderer(columnasCentralizadas);
        tablaPosiciones.getColumnModel().getColumn(1).setCellRenderer(columnasCentralizadas);
        tablaPosiciones.getColumnModel().getColumn(2).setCellRenderer(columnasCentralizadas);
        tablaPosiciones.getColumnModel().getColumn(3).setCellRenderer(columnasCentralizadas);
        tablaPosiciones.getColumnModel().getColumn(4).setCellRenderer(columnasCentralizadas);
        tablaPosiciones.getColumnModel().getColumn(5).setCellRenderer(columnasCentralizadas);
        tablaPosiciones.getColumnModel().getColumn(6).setCellRenderer(columnasCentralizadas);
        tablaPosiciones.getColumnModel().getColumn(7).setCellRenderer(columnasCentralizadas);
        tablaPosiciones.getColumnModel().getColumn(8).setCellRenderer(columnasCentralizadas);

        TableColumn columnaTres = tablaPosiciones.getColumnModel().getColumn(0);
        columnaTres.setMaxWidth(160);
        columnaTres.setMinWidth(160);
        columnaTres.setPreferredWidth(160);

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
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaPosiciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane6.setBorder(null);

        tablaPosiciones = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaPosiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPosiciones.setGridColor(new java.awt.Color(255, 255, 255));
        tablaPosiciones.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaPosiciones.setRowHeight(25);
        tablaPosiciones.setSelectionBackground(new java.awt.Color(0, 112, 192));
        tablaPosiciones.setShowVerticalLines(false);
        tablaPosiciones.getTableHeader().setReorderingAllowed(false);
        tablaPosiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPosicionesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaPosiciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
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

        Leer miLeer = new Leer();
        Cargar miCargar = new Cargar();

        String tituloTablaPosiciones[] = new String[9];
        tituloTablaPosiciones[0] = "Nombre Equipo";
        tituloTablaPosiciones[1] = "PJ";
        tituloTablaPosiciones[2] = "G";
        tituloTablaPosiciones[3] = "E";
        tituloTablaPosiciones[4] = "P";
        tituloTablaPosiciones[5] = "GF";
        tituloTablaPosiciones[6] = "GC";
        tituloTablaPosiciones[7] = "DG";
        tituloTablaPosiciones[8] = "Pts";

        PosicionesJoinEquipo miPosicionesJoinEquipo[] = miLeer.leerTablaPosiciones(idTorneo);
        PosicionesJoinEquipo aux = new PosicionesJoinEquipo();
        for (int i = 0; i < miPosicionesJoinEquipo.length; i++) {
            for (int j = 0; j < (miPosicionesJoinEquipo.length - 1); j++) {
                if (miPosicionesJoinEquipo[j].getPuntos() < miPosicionesJoinEquipo[j + 1].getPuntos()) {
                    aux = miPosicionesJoinEquipo[j + 1];
                    miPosicionesJoinEquipo[j + 1] = miPosicionesJoinEquipo[j];
                    miPosicionesJoinEquipo[j] = aux;
                } else if (miPosicionesJoinEquipo[j].getPuntos() == miPosicionesJoinEquipo[j + 1].getPuntos()) {
                    aux = miPosicionesJoinEquipo[j + 1];
                    miPosicionesJoinEquipo[j + 1] = miPosicionesJoinEquipo[j];
                    miPosicionesJoinEquipo[j] = aux;
                }
            }
        }
        tablaPosiciones = miCargar.cargarTablaPosiciones(tablaPosiciones, miPosicionesJoinEquipo, tituloTablaPosiciones);

        propiedadesTabla();

    }//GEN-LAST:event_formWindowOpened

    private void tablaPosicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPosicionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaPosicionesMouseClicked

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
            java.util.logging.Logger.getLogger(TablaPosiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaPosiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaPosiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaPosiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TablaPosiciones dialog = new TablaPosiciones(new javax.swing.JDialog(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JTable tablaPosiciones;
    // End of variables declaration//GEN-END:variables
}