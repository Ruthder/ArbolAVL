
package avlui_ruthdercantillo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    Graphics g;
    AVLUI_RuthderCantillo avl;
    int ejex;    
    int diferenciaX=0;
    int diferenciaY=0;
    
    public Ventana(AVLUI_RuthderCantillo avl) {
        initComponents();
        this.avl = avl;
        informacion();
        jLabel4.setText("");
        jPanel1.setPreferredSize(new Dimension(3000, 1920));
        g = jPanel1.getGraphics();
        ejex = jPanel1.getWidth();
        
    }

    public final void informacion() {
        jLabel2.setText("Altura del arbol:       " + avl.altura(avl.Raiz));
        jLabel3.setText("Tamaño del arbol:   " + avl.tamaño(avl.Raiz));
        jLabel5.setText("Hojas del arbol:        " + avl.hojas(avl.Raiz));
        jLabel6.setText("Nodos completos:   " + avl.completos(avl.Raiz));
    }

    public boolean VerificarAumentoX(int dAct){
        return dAct > diferenciaX;
    }
    
    public boolean VerificarAumentoY(int dAct){
        return dAct > diferenciaY;
    }
    
    public void moverGraficar(Graphics g, Nodo p, int x, int y, String buscado, int lvl){
        jScrollPane1.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (VerificarAumentoX(e.getValue())) {
                    g.clearRect(0, 0, 3000, 1920);
                    g.translate(diferenciaX-e.getValue(), 0);
                    graficar1(g, p, x, y, buscado, 1);
                    diferenciaX = e.getValue();
                    
                }else{
                    g.clearRect(0, 0, 3000, 1920);
                    g.translate(diferenciaX-e.getValue(), 0);
                    graficar1(g, p, x, y, buscado, 1);
                    diferenciaX = e.getValue();
                }
            }
        });
        
        jScrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent f) {
                if(VerificarAumentoY(f.getValue())){
                    g.clearRect(0, 0, 3000, 1920);
                    g.translate(0, diferenciaY-f.getValue());
                    graficar1(g, p, x, y, buscado, 1);
                    diferenciaY = f.getValue();
                }else{
                    g.clearRect(0, 0, 3000, 1920);
                    g.translate(0, diferenciaY-f.getValue());
                    graficar1(g, p, x, y, buscado, 1);
                    diferenciaY = f.getValue();
                }
            }
        });
    }
    
    public void graficar1(Graphics g, Nodo p, int x, int y, String buscado, int lvl) {
        if (p != null) {
            g.setColor(java.awt.Color.black);
            System.out.println("Info: " + p.getDato() + "; x = " + x + "; y = " + y);
            if (p.getDerecho() != null) {
                g.drawLine(x + 15, y + 15, (int) (x+15 + (ejex / (Math.pow(2, lvl + 1)))), y + 65);
            }
            if (p.getIzquierdo() != null) {
                g.drawLine(x + 15, y + 15, (int) (x+15 - (ejex / (Math.pow(2, lvl + 1)))), y + 65);
            }
            if("b".equals(buscado)){
                g.setColor(java.awt.Color.BLACK);
            }else{
                if(Integer.parseInt(buscado)==p.getDato()){
                    g.setColor(java.awt.Color.RED);
                }else{
                    g.setColor(java.awt.Color.BLACK);
                }
            }
            g.fillOval(x, y, 30 - lvl, 30 - lvl);
            g.setColor(java.awt.Color.white);
            if (String.valueOf(p.getDato()).length() == 1) {
                g.drawString(String.valueOf(p.getDato()), x + 12 - lvl/2, y + 19 - lvl/4);
            } else {
                g.drawString(String.valueOf(p.getDato()), x + 8 - lvl/2, y + 19 -lvl/4);
            }
            
            graficar1(g, p.getIzquierdo(), (int) (x - (ejex / (Math.pow(2, lvl + 1)))), y + 50, buscado, lvl + 1);
            graficar1(g, p.getDerecho(), (int) (x + (ejex / (Math.pow(2, lvl + 1)))), y + 50, buscado, lvl + 1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 720));
        setPreferredSize(new java.awt.Dimension(1366, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 720));
        getContentPane().setLayout(null);

        jButton1.setText("Insertar número de nodos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 610, 210, 30);

        jLabel7.setText("Funciones");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 590, 90, 20);

        jButton3.setText("Preorden");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(260, 610, 100, 30);

        jButton4.setText("Niveles");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(370, 650, 100, 30);

        jButton5.setText("Inorden");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(370, 610, 100, 30);

        jButton6.setText("Postorden");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(260, 650, 100, 30);

        jLabel8.setText("Información");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1100, 590, 260, 20);

        jButton2.setText("Buscar nodo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 650, 210, 30);

        jLabel9.setText("Recorridos");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(260, 590, 90, 20);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(540, 610, 280, 70);

        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(830, 650, 100, 30);

        jButton8.setText("Insertar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(830, 610, 100, 30);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(490, 650, 30, 20);

        jLabel2.setText("info4");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1100, 670, 260, 20);

        jLabel6.setText("info3");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1100, 650, 260, 20);

        jLabel5.setText("info2");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1100, 630, 260, 20);

        jLabel3.setText("info1");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1100, 610, 260, 20);

        jLabel10.setText("Operaciones");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(540, 590, 90, 20);

        jPanel1.setMaximumSize(new java.awt.Dimension(1365, 633));
        jPanel1.setMinimumSize(new java.awt.Dimension(1365, 633));
        jPanel1.setPreferredSize(new java.awt.Dimension(1365, 633));

        jLabel4.setText("Tipo de rotación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(1278, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(608, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 1350, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        avl.Raiz = null;
        int n, xd;
        do {
            xd = Integer.parseInt(JOptionPane.showInputDialog("Ingresar número de nodos"));
        } while (xd <= 0);
        for (int i = 1; i <= xd; i++) {
            do {
                n = (int) (Math.random() * 100);
            } while (Metodos.buscarAVL(avl.Raiz, n) != null);
            avl.Raiz = Metodos.insertarAVL(avl.Raiz, n);
        }
        jPanel1.removeAll();
        g.clearRect(0, 0, 3000, 1920);
        graficar1(g, avl.Raiz, 1500, 10, "b", 1);
        moverGraficar(g, avl.Raiz, 1500, 10, "b", 1);
        informacion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (avl.Raiz == null) {
            JOptionPane.showMessageDialog(null, "Arbol vacío");
        } else {
            Recorridos.preOrdenR(avl.Raiz);
            JOptionPane.showMessageDialog(null, "Secuencia(preOrden): " + Recorridos.aux);
            Recorridos.aux = "";
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (avl.Raiz == null) {
            JOptionPane.showMessageDialog(null, "Arbol vacío");
        } else {
            Recorridos.niveles(0, avl.Raiz);
            JOptionPane.showMessageDialog(null, "Secuencia(Niveles): " + Recorridos.aux);
            Recorridos.aux = "";
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (avl.Raiz == null) {
            JOptionPane.showMessageDialog(null, "Arbol vacío");
        } else {
            Recorridos.inOrdenR(avl.Raiz);
            JOptionPane.showMessageDialog(null, "Secuencia(niveles): " + Recorridos.aux);
            Recorridos.aux = "";
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (avl.Raiz == null) {
            JOptionPane.showMessageDialog(null, "Arbol vacío");
        } else {
            Recorridos.postOrdenR(avl.Raiz);
            JOptionPane.showMessageDialog(null, "Secuencia(postOrden): " + Recorridos.aux);
            Recorridos.aux = "";
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (avl.Raiz == null) {
            JOptionPane.showMessageDialog(null, "Arbol vacío");
        } else {
            int xd = Integer.parseInt(JOptionPane.showInputDialog("Nodo a buscar: "));
            if (Metodos.buscarAVL(avl.Raiz, xd) != null) {
                JOptionPane.showMessageDialog(null, "Nodo encontrado");
                jPanel1.removeAll();
                g.clearRect(0, 0, 3000, 1920);
                graficar1(g, avl.Raiz, jPanel1.getX()/2, 10, "b", 1);
                moverGraficar(g, avl.Raiz, jPanel1.getX(), 10, "b", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Nodo no encontrado");
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Campo vacío");
        } else {
            avl.Raiz = Metodos.borrarAVL(avl.Raiz, Integer.parseInt(jTextField1.getText()));
            jPanel1.removeAll();
            g.clearRect(0, 0, 3000, 1920);
            graficar1(g, avl.Raiz, jPanel1.getX()/2, 10, "b", 1);
            moverGraficar(g, avl.Raiz, jPanel1.getX(), 10, "b", 1);
        }
        jTextField1.setText("");
        informacion();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Campo vacío");
        } else {
            avl.Raiz = Metodos.insertarAVL(avl.Raiz, Integer.parseInt(jTextField1.getText()));
            jPanel1.removeAll();
            g.clearRect(0, 0, 3000, 1920);
            graficar1(g, avl.Raiz, jPanel1.getX()/2, 10, "b", 1);
            moverGraficar(g, avl.Raiz, jPanel1.getX(), 10, "b", 1);
        }
        jTextField1.setText("");
        informacion();
    }//GEN-LAST:event_jButton8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
