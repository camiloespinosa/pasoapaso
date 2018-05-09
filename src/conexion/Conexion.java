package conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    public Connection conex;
    
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost/prueba","root","");
            System.out.println("Conexion establecida.");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conex;
    }
}
