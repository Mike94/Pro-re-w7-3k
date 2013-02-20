package project01;

import interfaz.dlgAccessSystem;

/**
 *
 * @author MK
 * @fecha 20/02/2013
 */
public class Project01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // modificando
        dlgAccessSystem dialog=new dlgAccessSystem(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }
}
