package tup.lc4.abmpersonas.repositories;


import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tup.lc4.abmpersonas.exceptions.BackendException;
import tup.lc4.abmpersonas.models.Persona;


@Repository
public class RepositorioPersonas {
    
    @Autowired
    private DataSource source;
    
    public List<Persona> obtenerTodas() throws BackendException {
        
        List<Persona> lista = new ArrayList<>();
        
        try {
            Connection conn = source.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from personas2");
            
            while (rs.next()) {
                int doc = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                int edad = rs.getInt(4);
                
                lista.add(new Persona(doc, nombre, apellido, edad));
            }
            
            
            rs.close();
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            throw new BackendException();
        }
        
        return lista;
        
    }


    public Persona obtenerUna(int documento) throws BackendException  {
        
        Persona encontrada = null;
        
        try {
            Connection conn = source.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from personas2 where documento = ?");
            st.setInt(1,documento);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int doc = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                int edad = rs.getInt(4);
                
                encontrada = new Persona(doc, nombre, apellido, edad);
            }
            
            rs.close();
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            throw new BackendException();
        }
        
        return encontrada;
        
    }
     
    public void guardar(Persona p) throws BackendException {
          try {
            Connection conn = source.getConnection();
            PreparedStatement st = conn.prepareStatement("select count(*) from personas2 where documento = ?");
            st.setInt(1,p.getDocumento());
            
            ResultSet rs = st.executeQuery();
            
            rs.next();
            if (rs.getInt(1) == 0) {
                PreparedStatement stIns = conn.prepareStatement("insert into personas2 values (?,?,?,?)");
                stIns.setInt(1, p.getDocumento());
                stIns.setString(2, p.getNombre());
                stIns.setString(3, p.getApellido());
                stIns.setInt(4, p.getEdad());
                stIns.executeUpdate();
            } else {
                PreparedStatement stUpd = conn.prepareStatement("update personas2 set nombre = ?, apellido = ?, edad = ? where documento = ?");
                stUpd.setString(1, p.getNombre());
                stUpd.setString(2, p.getApellido());
                stUpd.setInt(3, p.getEdad());
                stUpd.setInt(4, p.getDocumento());
                stUpd.executeUpdate();
            }
            
            rs.close();
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            throw new BackendException();
        }
          
    }
}
