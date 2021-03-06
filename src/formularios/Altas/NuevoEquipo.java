/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios.Altas;

import clases.Equipo;
import clases.EquipoJoinJugador;
import clases.Jugador;
import formularios.BuscarJugadorJoinEquipo;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import metodos.CentralizarColumnasJTable;
import metodos.Guardar;
import metodos.Leer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Federico Melo
 */
public class NuevoEquipo extends javax.swing.JDialog {

    public static DefaultTableModel dft = new DefaultTableModel();
    private TableCellRenderer columnasCentralizadas = new CentralizarColumnasJTable();
    private int idUsuario;

    public NuevoEquipo(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Agregar Jugadores ");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
    }

    public NuevoEquipo(javax.swing.JDialog parent, boolean modal, int idUsuario) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.idUsuario = idUsuario;
        // Título de la Ventana
        setTitle("PitMu SOFTWARE - Agregar Jugadores ");
        // Icono para el Sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        tablaJugador.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaJugador.getTableHeader().setOpaque(false);
        tablaJugador.getTableHeader().setBackground(new Color(255, 153, 0));
        tablaJugador.getTableHeader().setForeground(new Color(255, 255, 255));
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
    
    public void limpiarTabla(JTable tabla){
        
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
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
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txt_direccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_estadio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaJugador = new javax.swing.JTable();

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

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add (1).png"))); // NOI18N
        jButton1.setText(" Agregar Jugador");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Alta Equipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Nombre:");

        txt_nombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txt_nombre.setPreferredSize(new java.awt.Dimension(2, 28));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Dirección de Estadio:");

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save(2).png"))); // NOI18N
        jButton4.setText("  Guardar");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_direccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txt_direccion.setMinimumSize(new java.awt.Dimension(2, 28));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Nombre de Estadio:");

        txt_estadio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_estadio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_estadio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txt_estadio.setMinimumSize(new java.awt.Dimension(2, 28));
        txt_estadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 142, Short.MAX_VALUE))
                    .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_estadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_estadio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_direccion, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(59, 59, 59)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("importar lista de jugadores en Excel");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Importar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed1(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Ó");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jButton2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        BuscarJugadorJoinEquipo miBuscarJugadorJoinEquipo = new BuscarJugadorJoinEquipo(new javax.swing.JDialog(), true, idUsuario);
        miBuscarJugadorJoinEquipo.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Guardar miGuardar = new Guardar();
        Leer miLeer = new Leer();
        Jugador miJugadorValidacionDos[] = miLeer.leerJugador(idUsuario);
        int auxiliarJugador = 0;

        for (int i = 0; i < tablaJugador.getRowCount(); i++) {
            if (Integer.parseInt(tablaJugador.getValueAt(i, 0).toString()) == 0) {
                Jugador miJugadorTablaValidacion = new Jugador();
                miJugadorTablaValidacion.setNombreJugador(tablaJugador.getValueAt(i, 1).toString());
                miJugadorTablaValidacion.setApellidoJugador(tablaJugador.getValueAt(i, 2).toString());
                miJugadorTablaValidacion.setDniJugador(Long.parseLong(tablaJugador.getValueAt(i, 3).toString()));
                miJugadorTablaValidacion.setDomicilioJugador(tablaJugador.getValueAt(i, 4).toString());
                miJugadorTablaValidacion.setTelefonoJugador(Long.parseLong(tablaJugador.getValueAt(i, 5).toString()));
                miJugadorTablaValidacion.setEstaturaJugador(Double.parseDouble(tablaJugador.getValueAt(i, 6).toString()));
                miJugadorTablaValidacion.setPosicionJugador(tablaJugador.getValueAt(i, 7).toString());
                for (int x = 0; x < miJugadorValidacionDos.length; x++) {
                    if (miJugadorValidacionDos[x].getDniJugador() == miJugadorTablaValidacion.getDniJugador()) {
                        auxiliarJugador = 1;
                    }
                }
                if (auxiliarJugador == 0) {
                    miJugadorTablaValidacion.setIdUsuario(idUsuario);
                    miJugadorTablaValidacion.setEstadoJugador("alta");
                    miGuardar.guardarJugador(miJugadorTablaValidacion);
                }
            }
        }

        if (!txt_nombre.getText().trim().isEmpty()
                && !txt_estadio.getText().trim().isEmpty()
                && !txt_direccion.getText().trim().isEmpty()) {

            TableModel tableModel = tablaJugador.getModel();
            int filas = tableModel.getRowCount();

            if (filas > 0) {

                Equipo miEquipo = new Equipo();
                miEquipo.setNombreEquipo(txt_nombre.getText().trim());
                miEquipo.setNombreEstadioEquipo(txt_estadio.getText().trim());
                miEquipo.setDireccionEstadioEquipo(txt_direccion.getText().trim());
                miEquipo.setIdUsuario(idUsuario);
                miEquipo.setEstadoEquipo("alta");

                Equipo miEquipoValidacion[] = miLeer.validarEquipos(idUsuario);

                int auxEquipo = 0;

                for (int j = 0; j < miEquipoValidacion.length; j++) {

                    if (miEquipoValidacion[j].getNombreEquipo().equals(miEquipo.getNombreEquipo())) {
                        auxEquipo = 1;
                    }

                }

                if (auxEquipo == 0) {
                    miGuardar.guardarEquipo(miEquipo);
                    int idEquipo = miLeer.LeerIdEquipo(miEquipo);
                    Jugador miJugadorValidarSiExiste[] = miLeer.leerJugador(idUsuario);

                    if (idEquipo != 0) {

                        for (int i = 0; i < filas; i++) {

                            if (Integer.parseInt(tablaJugador.getValueAt(i, 0).toString()) == 0) {
                                int idJugador = 0;

                                for (int x = 0; x < miJugadorValidarSiExiste.length; x++) {

                                    if (miJugadorValidarSiExiste[x].getDniJugador() == Integer.parseInt(tablaJugador.getValueAt(i, 3).toString())) {
                                        idJugador = miJugadorValidarSiExiste[x].getIdJugador();
                                    }

                                }

                                if (idJugador != 0) {
                                    EquipoJoinJugador miEquipoJoinJugador = new EquipoJoinJugador();
                                    miEquipoJoinJugador.setIdEquipo(idEquipo);
                                    miEquipoJoinJugador.setIdJugador(idJugador);
                                    miGuardar.guardarEquipoJoinJugador(miEquipoJoinJugador);
                                }

                            } else {

                                EquipoJoinJugador miEquipoJoinJugador = new EquipoJoinJugador();
                                miEquipoJoinJugador.setIdEquipo(idEquipo);
                                miEquipoJoinJugador.setIdJugador(Integer.parseInt(tablaJugador.getValueAt(i, 0).toString()));
                                miGuardar.guardarEquipoJoinJugador(miEquipoJoinJugador);

                            }

                        }

                    }

                } else {

                    new alertas.AlertSuccess(this, true, "El jugador se ha agregado").setVisible(true);

                }

                txt_nombre.setText("");
                txt_estadio.setText("");
                txt_direccion.setText("");
                limpiarTabla(tablaJugador);
                
            } else if (filas <= 0) {

                new alertas.AlertWarning(this, true, "Debe seleccionar jugadores").setVisible(true);

            }

        } else {

            new alertas.AlertWarning(this, true, "Debe rellenar todos los campos").setVisible(true);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        String titulos[] = new String[8];

        titulos[0] = "ID";
        titulos[1] = "Nombre";
        titulos[2] = "Apellido";
        titulos[3] = "DNI";
        titulos[4] = "Domicilio";
        titulos[5] = "Teléfono";
        titulos[6] = "Estatura";
        titulos[7] = "Posición";

        dft.setColumnIdentifiers(titulos);
        tablaJugador.setModel(dft);
        propiedadesTabla();

    }//GEN-LAST:event_formWindowOpened

    private void txt_estadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadioActionPerformed

    private void jButton2ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed1

        Leer miLeer = new Leer();

        JFileChooser miJFileChoser = new JFileChooser();
        miJFileChoser.setDialogTitle("Buscar plantilla con Jugadores");
        File archivo = null;
        if (miJFileChoser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            archivo = new File(miJFileChoser.getSelectedFile().toString());
        }
        try {
            FileInputStream file = new FileInputStream(archivo);
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            Jugador miJugadorArreglo[] = new Jugador[numFilas];

            for (int i = 1; i <= numFilas; i++) {
                Row fila = sheet.getRow(i);

                miJugadorArreglo[i - 1] = new Jugador();
                miJugadorArreglo[i - 1].setNombreJugador(fila.getCell(0).getStringCellValue());
                miJugadorArreglo[i - 1].setApellidoJugador(fila.getCell(1).getStringCellValue());
                miJugadorArreglo[i - 1].setDniJugador((long) fila.getCell(2).getNumericCellValue());
                miJugadorArreglo[i - 1].setDomicilioJugador(fila.getCell(3).getStringCellValue());
                miJugadorArreglo[i - 1].setTelefonoJugador((long) fila.getCell(4).getNumericCellValue());
                miJugadorArreglo[i - 1].setEstaturaJugador(Double.parseDouble(fila.getCell(5).getStringCellValue()));
                miJugadorArreglo[i - 1].setPosicionJugador(fila.getCell(6).getStringCellValue());

            }

            int validacionJugador = 0;

            if (tablaJugador.getRowCount() > 0) {

                Jugador miJugadorTablaValidacion[] = new Jugador[tablaJugador.getRowCount()];

                for (int i = 0; i < miJugadorTablaValidacion.length; i++) {

                    miJugadorTablaValidacion[i].setDniJugador(Integer.parseInt(tablaJugador.getValueAt(i, 3).toString()));
                    long dni = miJugadorTablaValidacion[i].getDniJugador();
                    String miJugadorTabla[] = new String[8];

                    for (int j = 0; j < miJugadorArreglo.length; j++) {

                        if (dni == miJugadorArreglo[j].getDniJugador()) {
                            validacionJugador = 1;
                        } else {
                            miJugadorTabla[0] = String.valueOf(0);
                            miJugadorTabla[1] = miJugadorArreglo[j].getNombreJugador();
                            miJugadorTabla[2] = miJugadorArreglo[j].getApellidoJugador();
                            miJugadorTabla[3] = String.valueOf(miJugadorArreglo[j].getDniJugador());
                            miJugadorTabla[4] = miJugadorArreglo[j].getDomicilioJugador();
                            miJugadorTabla[5] = String.valueOf(miJugadorArreglo[j].getTelefonoJugador());
                            miJugadorTabla[6] = String.valueOf(miJugadorArreglo[j].getEstaturaJugador());
                            miJugadorTabla[7] = miJugadorArreglo[j].getPosicionJugador();
                        }

                    }

                    if (validacionJugador == 0) {      
                        Presentacion_1 miPresentacion_1 = new Presentacion_1(this, true);
                        miPresentacion_1.setVisible(true);
                        dft.addRow(miJugadorTabla);
                        tablaJugador.setModel(dft);                            
                        propiedadesTabla();
                    }

                }                

            } else {

                Presentacion_1 miPresentacion_1 = new Presentacion_1(this, true);
                miPresentacion_1.setVisible(true);                
                for (int x = 0; x < miJugadorArreglo.length; x++) {
                    String miJugadorTabla[] = new String[9];
                    miJugadorTabla[0] = String.valueOf(0);
                    miJugadorTabla[1] = miJugadorArreglo[x].getNombreJugador();
                    miJugadorTabla[2] = miJugadorArreglo[x].getApellidoJugador();
                    miJugadorTabla[3] = String.valueOf(miJugadorArreglo[x].getDniJugador());
                    miJugadorTabla[4] = miJugadorArreglo[x].getDomicilioJugador();
                    miJugadorTabla[5] = String.valueOf(miJugadorArreglo[x].getTelefonoJugador());
                    miJugadorTabla[6] = String.valueOf(miJugadorArreglo[x].getEstaturaJugador());
                    miJugadorTabla[7] = miJugadorArreglo[x].getPosicionJugador();
                    dft.addRow(miJugadorTabla);
                    tablaJugador.setModel(dft);
                }                

            }

        } catch (FileNotFoundException ex) {
            new alertas.AlertWarning(this, true, "No se seleccionó el archivo").setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(NuevoEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed1

    private void tablaJugadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJugadorMouseClicked

    }//GEN-LAST:event_tablaJugadorMouseClicked

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed

        dft.removeRow(tablaJugador.getSelectedRow());

    }//GEN-LAST:event_itemEliminarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        txt_nombre.setText("");
        txt_estadio.setText("");
        txt_direccion.setText("");
        limpiarTabla(tablaJugador);
        
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
            java.util.logging.Logger.getLogger(NuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoEquipo dialog = new NuevoEquipo(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);

                /*try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NuevoEquipo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NuevoEquipo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NuevoEquipo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(NuevoEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane7;
    public static javax.swing.JTable tablaJugador;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_estadio;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

}
