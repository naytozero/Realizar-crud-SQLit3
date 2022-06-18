
package Implementacion;
import entidades.Persona;
import java.sql.SQLException;
import conexion.ConexionSqlite;
import org.sqlite.SQLiteException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplPersona {
    ConexionSqlite cnx = new ConexionSqlite();

    public void registrarPersona(Persona p){
try{
String query="INSERT INTO personas VALUES('"+p.getId()+"','"+p.getNombres()+"','"+p.getApellido_pater()+"','"+p.getApellido_mater()+"','"+p.getDireccion()+"','"+p.getCorreo()+"','"+p.getNum_celular()+"','"+p.getAnios_edad()+"','"+p.getDni()+"','"+p.getNivel_educacion()+"','"+p.getEstado_civil()+"','"+p.getGenero()+"','"+p.getUsuario()+"','"+p.getContrasenia()+"')";


           Statement st= cnx.getConnect().createStatement();
           st.execute(query);



       }catch(SQLException ex){
           System.out.println(ex.getMessage());

       }





    }
    public void modificarpersonas(Persona m){

        try {

                Connection cn= cnx.getConnect();

                PreparedStatement ps = cn.prepareStatement("UPDATE personas SET PER_NOMBRE = ?, PER_APELL_PATERNO = ?,PER_APELL_MATERNO = ?,PER_DIRECCION = ?, PER_CORREO = ?, PER_NUM_CELULAR = ?, PER_ANIOS_EDAD = ?, PER_DNI = ?, PER_NIVEL_EDUCACION = ?, PER_ESTADO_CIVIL = ?, PER_GENERO = ?, PER_USUARIO = ?, PER_CONTRASENIA = ? WHERE PER_ID = ?;");

                ps.setString(1, m.getNombres());
                ps.setString(2, m.getApellido_pater());
                ps.setString(3, m.getApellido_mater());
                ps.setString(4, m.getDireccion());
                ps.setString(5, m.getCorreo());
                ps.setString(6, m.getNum_celular());
                ps.setString(7, m.getAnios_edad());
                ps.setString(8, m.getDni());
                ps.setObject(9, m.getNivel_educacion());
                ps.setObject(10, m.getEstado_civil());
                ps.setObject(11, m.getGenero());
                ps.setString(12, m.getUsuario());
                ps.setString(13, m.getContrasenia());
                ps.setString(14, m.getId());

                ps.executeUpdate();



            } catch (SQLException ex) {
                Logger.getLogger(ImplPersona.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    public void eliminarpersonas(Persona e){

        try {

                Connection cn= cnx.getConnect();

                PreparedStatement ps = cn.prepareStatement("DELETE FROM personas WHERE PER_ID = ?;");

                ps.setString(1, e.getId());

                ps.executeUpdate();



            } catch (SQLException ex) {
                Logger.getLogger(ImplPersona.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
    
}
