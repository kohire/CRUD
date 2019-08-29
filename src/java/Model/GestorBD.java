package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aidee
 */
public class GestorBD {
    private Connection conexion;
    private ResultSet rs;
    private Statement st;
    private PreparedStatement ps;

    public GestorBD(){
        conexion = ConexionBD.obtenerConexion();
    }

    public List<Dispositivo> getDevs(String smt) {
        List<Dispositivo> disp = new ArrayList<>();
        try {
            st = conexion.createStatement();
            if (smt == null) {
                rs = st.executeQuery("SELECT * FROM dispositivos");
            } else {
                rs = st.executeQuery("SELECT * FROM dispositivos WHERE nombre LIKE '%" + smt + "%'");
            }
            while (rs.next()) {
                Dispositivo dis = new Dispositivo();
                dis.setId(rs.getInt(1));
                dis.setNombre(rs.getString(2));
                dis.setDescripcion(rs.getString(3));
                dis.setModelo(rs.getString(4));
                dis.setMarca(rs.getString(5));
                dis.setPrecio(rs.getInt(6));
                dis.setColor(rs.getString(7));
                disp.add(dis);
            }
            rs.close();
            st.close();
            return disp;
        } catch (SQLException e) {
            System.out.println("Exception caught in get devices: ");
            e.printStackTrace();
            return null;
        }
    }
   
    public Dispositivo uniqueDev(int idDev) {        
    // idDisp,nombre,descripcion,modelo,marca,precio,color
         Dispositivo dis = new Dispositivo();
        try {
            st = conexion.createStatement();
                rs = st.executeQuery("SELECT idDisp,nombre,descripcion,modelo,marca,precio,color "
                        + " FROM dispositivos WHERE idDisp=" +idDev);
            while (rs.next()) {
                dis.setId(rs.getInt(1));
                dis.setNombre(rs.getString(2));
                dis.setDescripcion(rs.getString(3));
                dis.setModelo(rs.getString(4));
                dis.setMarca(rs.getString(5));
                dis.setPrecio(rs.getInt(6));
                dis.setColor(rs.getString(7));
            }
            rs.close();
            st.close();
            return dis;
        } catch (SQLException e) {
            System.out.println("Exception caught in get device. ");
            e.printStackTrace();
            return null;
        }
    }
    

    public boolean deleteDev(int idDev) {
         try {
            String sql = "DELETE FROM dispositivos WHERE idDisp =" + idDev;
            ps = conexion.prepareCall(sql);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: delete device. Check.");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addDev(Dispositivo disp){
        try {
           String sql = "INSERT INTO dispositivos(idDisp,nombre,descripcion,modelo,marca,precio,color) VALUES \n"
                    + "(NULL,?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, disp.getNombre());
            ps.setString(2, disp.getDescripcion());
            ps.setString(3, disp.getModelo());
            ps.setString(4, disp.getMarca());
            ps.setInt(5, disp.getPrecio());
            ps.setString(6,disp.getColor());
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: add disp. Check.");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modifyDev (Dispositivo disp){
        try {
           String sql = "UPDATE dispositivos SET nombre=?, descripcion=?,"+
                   "modelo=?,marca=?, precio=?, color=? WHERE idDisp =?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, disp.getNombre());
            ps.setString(2, disp.getDescripcion());
            ps.setString(3, disp.getModelo());
            ps.setString(4, disp.getMarca());
            ps.setInt(5, disp.getPrecio());
            ps.setString(6,disp.getColor());
            ps.setInt(7,disp.getId());
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: add device. Check.");
            e.printStackTrace();
            return false;
        }
    }
    
    public int getID() {
        int id = 0;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("CALL getNextID();");
            rs.next();
            id = rs.getInt(1);
            rs.close();
            st.close();
            return id;
        } catch (Exception e) {
            System.out.println("Error caught in: get id from device. Check.");
            e.printStackTrace();
            return -1;
        }
    }
    
}
