package clases;

/**
 *
 * @author MK
 */
public class ClsSesion {
    //Declaracion de Variables
    public static String user=null;
    public static String[] permisosTabla;
    //EL Constructor
    public ClsSesion(){
        
    }
    
    //_________________________________________________________:)Soy una Bara Espaciadora
    /**
     * @param userString 
     * @param bd 
     * @descripcion Obtendra los permisos a las tablas que tiene el USER en la BD
     */
    public void _getPermisosTabla(String userString,ClsDatabase bd){
        ClsSesion.user=userString;
        Object[][] datos=bd.select("Usuario u,PermisosTabla p", "p.nombreformulario", "u.idusuario=p.idusuario");
        if(datos!=null){
            for (int i = 0; i < datos.length; i++) {
                permisosTabla[i]=datos[i][0].toString();
            }
        }
    }
    //_________________________________________________________:)Soy una Bara Espaciadora
    
}
