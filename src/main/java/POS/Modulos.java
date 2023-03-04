/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package POS;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NELSON
 */
public class Modulos extends javax.swing.JFrame {

    /**
     * Creates new form Modulos
     */
    public Modulos() {
        initComponents();
        llena_tabla();
    }

   private int seleccionar;
    
   private LinkedList<vendedores> listaVendedores = new LinkedList<vendedores>();
   
    public void cambioVendedor(boolean solicitud) {
        if (solicitud) {
            pVendedores.setBackground(new Color(204, 255, 255));
        }else{
            pVendedores.setBackground(Color.blue);
        }
        setVisible(true);
        pModulos.setSelectedIndex(3); // Seleccionar el panel de vendedores
    }
    
    public void llena_tabla() {
 
        try {
            FileInputStream fileIn = new FileInputStream("vendedores.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaVendedores = (LinkedList<vendedores>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("La lista se ha deserializado correctamente");
            
            String columnas[] = {"codigo", "nombre", "caja","ventas","genero"};
            DefaultTableModel t1 = new DefaultTableModel(null, columnas);

            for (vendedores v : listaVendedores) {
                Object[] fila = new Object[5];
                fila[0] = v.getCodigo();
                fila[1] = v.getNombre();
                fila[2] = v.getCaja();
                fila[3] = v.getVentas();
                fila[4] = v.getGenero();
                t1.addRow(fila);
            }
            
            tblVendedores.setModel(t1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }

    
       public void eliminar(int vendedor) {
        try {
            // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
            FileInputStream fileIn = new FileInputStream("vendedores.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LinkedList<vendedores> listaVendedoresActual = (LinkedList<vendedores>) in.readObject();
            in.close();
            fileIn.close();

            // Buscar el vendedor a eliminar en la nueva LinkedList y eliminarlo
            Iterator<vendedores> iterator = listaVendedoresActual.iterator();
            while (iterator.hasNext()) {
                vendedores vendedorActual = iterator.next();
                if (vendedorActual.getCodigo() == vendedor) {
                    iterator.remove();
                    break;
                }
            }

            // Escribir la nueva LinkedList actualizada en el archivo
            FileOutputStream fileOut = new FileOutputStream("vendedores.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaVendedoresActual);
            out.close();
            fileOut.close();

            JOptionPane.showMessageDialog(null, "Vendedor eliminado exitosamente");

            Modulos ad = new Modulos();
            ad.cambioVendedor(true);
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pModulos = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pClientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDos = new javax.swing.JTable();
        pVendedores = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnCargaMasiva = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExportarPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendedores = new javax.swing.JTable();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        pModulos.addTab("Sucursales", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        pModulos.addTab("Productos", jPanel2);

        tablaDos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDos);

        javax.swing.GroupLayout pClientesLayout = new javax.swing.GroupLayout(pClientes);
        pClientes.setLayout(pClientesLayout);
        pClientesLayout.setHorizontalGroup(
            pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClientesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        pClientesLayout.setVerticalGroup(
            pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pModulos.addTab("Clientes", pClientes);

        pVendedores.setBackground(new java.awt.Color(204, 255, 255));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCargaMasiva.setText("Carga Masiva");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnExportarPDF.setText("Exportar listado a PDF");

        tblVendedores.setShowGrid(false);
        tblVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendedores);

        javax.swing.GroupLayout pVendedoresLayout = new javax.swing.GroupLayout(pVendedores);
        pVendedores.setLayout(pVendedoresLayout);
        pVendedoresLayout.setHorizontalGroup(
            pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pVendedoresLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pVendedoresLayout.createSequentialGroup()
                        .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCargaMasiva, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pVendedoresLayout.setVerticalGroup(
            pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVendedoresLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pVendedoresLayout.createSequentialGroup()
                        .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCargaMasiva, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pModulos.addTab("Vendedores", pVendedores);

        btnCerrarSesion.setBackground(new java.awt.Color(255, 102, 102));
        btnCerrarSesion.setText("cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pModulos)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pModulos, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
      
        CargaVendedores ad = new CargaVendedores();
        ad.cambioCreaVendedor(true);
        dispose();
            
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        try {
            FileInputStream fileIn = new FileInputStream("vendedores.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaVendedores = (LinkedList<vendedores>) in.readObject();
            in.close();
            fileIn.close();
         
            CargaVendedores cv = new CargaVendedores();

            cv.editarVendedor(listaVendedores.get(tblVendedores.getSelectedRow()));
            
            dispose();
        
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendedoresMouseClicked

    }//GEN-LAST:event_tblVendedoresMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar(tblVendedores.getSelectedRow());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        dispose();
        POS po = new POS();
        po.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCargaMasiva;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pClientes;
    private javax.swing.JTabbedPane pModulos;
    private javax.swing.JPanel pVendedores;
    private javax.swing.JTable tablaDos;
    public javax.swing.JTable tblVendedores;
    // End of variables declaration//GEN-END:variables
}
