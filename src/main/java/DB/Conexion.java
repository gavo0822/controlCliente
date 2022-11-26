
package DB;
//crear importacion

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    //Crear Metodo Privado//
    //conectar base de datos
    //paso1: ingresar services database 2:seleccionar mysql y lib descargada 3: nombre de base de datos copiar link y pegar//
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?zeroDateTimeBehavior=CONVERT_TO_NULL";
    //DATOS DE USER Y PASSWORD DB//
    private static final String JDBC_USER = "root";
    
    private static final String JDBC_PASSWORD = "";
       
    private static BasicDataSource ds;
     
     public static DataSource getDataSource(){
         //inicializar Datos Set-Enviar//
         if(ds == null){
            ds = new BasicDataSource();
            ds.setUrl(JDBC_URL);
            ds.setUsername(JDBC_USER);
            ds.setPassword(JDBC_PASSWORD);
            ds.setInitialSize(50);
         }
         return ds;
     }
     //Entablar Conexion//
     //PreparedStatement transforma sql para ser leido por bd envia sentencia//
     //resulset resultado de la sentencia SQL
     public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
     }
     //cerrar conexion para no saturar conexion a la base de datos//
     public static void close(Connection conn){
         try{
         conn.close();
         }catch(SQLException ex){
         ex.printStackTrace(System.out);
         }
     }
      public static void close(ResultSet rs){
         try{
         rs.close();
         }catch(SQLException ex){
         ex.printStackTrace(System.out);
         }
     }
       public static void close(PreparedStatement stmt){
         try{
         stmt.close();
         }catch(SQLException ex){
         ex.printStackTrace(System.out);
         }
     }
}
