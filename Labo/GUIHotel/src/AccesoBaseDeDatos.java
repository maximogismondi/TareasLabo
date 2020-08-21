import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBaseDeDatos {
    private Connection conexion;
    private String nombreBD;
    private String nombreTabla;

    public AccesoBaseDeDatos(String nombreBD,String nombreTabla){
        this.nombreBD=nombreBD;
        this.nombreTabla=nombreTabla;
    }


    public Connection getConexion() {
        return conexion;
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    public String getNombreBD() {
        return nombreBD;
    }
    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }
    public String getNombreTabla() {
        return nombreTabla;
    }
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public void conectar(String user, String password){
        String url = "jdbc:mysql://localhost/" + this.nombreBD + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //String url = "jdbc:mysql://localhost:3306/" + this.nombreBD;
        try{
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion!=null){
                System.out.println("Conexion con la base de datos exitosa");
            }
            else{
                System.out.println("No pudo conectarse con la base de datos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
