package clases;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MK
 */
public class ClsSesion {
    //Declaracion de Variables
    public static String user=null;
    public static String[][] permisosTabla;
    
    //Permitira almacenar los botones para poder actuar sobre ellos
//    public JButton[] botonesAccesoTotal;
    public JButton[] botonesAccesoObservador;
    public JButton[] botonesAccesoNulo;
    
    //EL Constructor
    public ClsSesion() {
        
    }
    
    //_________________________________________________________:)Soy una Bara Espaciadora
    /**
     * 
     * @descripcion Obtendra los permisos a las tablas que tiene el USER en la BD
     * @param userString 
     * @param bd 
     */
    public void _getPermisosTabla(String userString,ClsDatabase bd){
        ClsSesion.user=userString;
        Object[][] datos=bd.select("Usuario u,PermisosTabla p", 
                "p.nombreformulario,p.acceso", 
                "u.idusuario=p.idusuario ");//and p.acceso="+permiso_Total()+"
        if(datos!=null){
            for (int i = 0; i < datos.length; i++) {
                permisosTabla[i][0]=datos[i][0].toString();//p.nombreformulario
                permisosTabla[i][1]=datos[i][1].toString();//p.acceso
            }
        }
    }
    //___________________________________________________________________________________ Soy una barra separadora :)
    /**
     * 
     * @param nameFormulario
     * @param botonesArrayString 
     */
    public void _verificarPermisos_MostrarVentana(JFrame nameFormulario,JButton[] botonesArrayString){
        for (int i = 0; i < permisosTabla.length; i++) {
            if (permisosTabla[i][0].equals(nameFormulario.getName())) {
                //Verificamos el tipo de permiso que tiene
                if (permisosTabla[i][1].equals("1")) {
                    nameFormulario.setVisible(true);
//                    permiso_Total();
                }else if(permisosTabla[i][1].equals("2")){
//                    botonesAccesoObservador=new JButton[botonesArrayString.length];
                    for (int j = 0; j < botonesArrayString.length; j++) {                        
                        botonesAccesoObservador[i]=botonesArrayString[i];
                    }
//                    permiso_Observador();
                    for (int k = 0; k < botonesAccesoObservador.length; k++) {
                        botonesAccesoObservador[k].setEnabled(false);
                    }
                    nameFormulario.setVisible(true);
                }else if(permisosTabla[i][1].equals("3")){
                    mensajeWarning();
                }
            }
        }
    }
    //___________________________________________________________________________________ Soy una barra separadora :)
    public void _verificarPermisos_MostrarVentana(JDialog nameDialog,JButton[] botonesArrayString){
        for (int i = 0; i < permisosTabla.length; i++) {
            if (permisosTabla[i][0].equals(nameDialog.getName())) {
                //Verificamos el tipo de permiso que tiene
                if (permisosTabla[i][1].equals("1")) {
                    permiso_Total();
                }else if(permisosTabla[i][1].equals("2")){
                    for (int j = 0; j < botonesArrayString.length; j++) {                        
                        botonesAccesoObservador[i]=botonesArrayString[i];
                    }
//                    permiso_Observador();
                    for (int k = 0; k < botonesAccesoObservador.length; k++) {
                        botonesAccesoObservador[k].setEnabled(false);
                    }
                    nameDialog.setVisible(true);
                }else if(permisosTabla[i][1].equals("3")){
                    mensajeWarning();                    
                }
            }
        }
    }
    //___________________________________________________________________________________ Soy una barra separadora :)
    private String permiso_Total(){
        return "1";
    }
    private String permiso_Observador(){
        return "2";
    }
    private String permiso_Nulo(){        
        return "3";
    }
    //_________________________________________________________:)Soy una Bara Espaciadora
    private void mensajeWarning(){
        JOptionPane.showMessageDialog(null, "Ud. No tiene permisos", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
}
