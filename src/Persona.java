import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Persona extends PersonaApp.PersonaPOA{
    
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarPersona(int id_persona, String nombre, String apellido, int telefono, String direccion, String correo) {
    boolean resultado = false;
        try {
            String query = "Insert into persona(id_persona,nombre,apellido,telefono,direccion,correo)"
                    + "values ('"+id_persona+"','"+nombre+"','"+apellido+"','"+telefono+"','"+direccion+"','"+correo+"')";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor > 0){
                resultado = true;
            }
            //Cerramos recursos
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }
    

    @Override
    public String consultarPersona(int id_persona) {
 String resultado = "";
        try {
            String query = "Select * from persona where id_persona = "+id_persona;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(1) + " - "
                        +  rs.getString(2) + " - "
                        +  rs.getString(3) + " - "
                        +  rs.getLong(4) + " - "
                        +  rs.getString(5) + " - "
                        +  rs.getString(6)+ "\n";
            }
            st.close();
            rs.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;    }

    @Override
    public boolean eliminarPersona(int id_persona) {
   boolean resultado = false;
        try {
            String query = "Delete from persona where id_persona = "+id_persona;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor > 0){
                resultado = true;
            }
            //Cerramos recursos
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;    }

    @Override
    public boolean actualizarPersona(int id_persona, String nombre, String apellido, int telefono, String direccion, String correo) {
  boolean resultado = false;
        try {
            String query = "Update persona set nombre='"+nombre+"',apellido='"+apellido+"',telefono='"+telefono+"',direccion='"+direccion+"',correo='"+correo+"'"
                    + " where id_persona='"+id_persona+"'";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor > 0){
                resultado = true;
            }
            //Cerramos recursos
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;    }

    @Override
    public String listarPersonas() {
  String resultado = "";
        try {
            String query = "Select * from persona";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(1) + " - "
                        +  rs.getString(2) + " - "
                        +  rs.getString(3) + " - "
                        +  rs.getLong(4) + " - "
                        +  rs.getString(5) + " - "
                        +  rs.getString(6)+ "\n";
            }
            st.close();
            rs.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
