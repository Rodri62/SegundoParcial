
package com.emergentes.dao;

import com.emergentes.modelo.Registro;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAOinpl extends ConexionDB implements RegistroDAO {

    @Override
    public void insert(Registro registro) throws Exception {
        String sql = "INSERT INTO estudiantes (Nombres, Apellidos, Seminarios, Confirmado, Fecha_Inscripcion)VALUES ('?,?,?,?,?')";
        this.conectar();
        PreparedStatement ps  = this.conn.prepareStatement(sql);
        ps.setString(1, registro.getNombres());
        ps.setString(2, registro.getApellidos());
        ps.setString(3, registro.getSeminarios());
        ps.setBoolean(4, registro.isConfirmado());
        ps.setString(5, registro.getFecha_Inscripcion());
        ps.executeUpdate();     
   }

    @Override
    public void update(Registro registro) throws Exception {
        String sql = "upadate estudiantes set Nombres=?, Apelllido=?,Seminarios=?,Confirmado=?,Fecha_Inscripcion=? where id=?)";
        this.conectar();
        PreparedStatement ps  = this.conn.prepareStatement(sql);
        ps.setString(1, registro.getNombres());
        ps.setString(2, registro.getApellidos());
        ps.setString(3, registro.getSeminarios());
        ps.setBoolean(4, registro.isConfirmado());
        ps.setString(5, registro.getFecha_Inscripcion());
        ps.executeUpdate(); 
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from estudiantes where id=?)";
        this.conectar();
        PreparedStatement ps  = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate(); 
    }

    @Override
    public List<Registro> getAll() throws Exception {
        List<Registro> lista = null;
       String sql = "select * from estudiantes";
        this.conectar();
        PreparedStatement ps  = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Registro>();
        while(rs.next()){
            Registro reg = new Registro();
            reg.setId(rs.getInt("id"));
            reg.setNombres(rs.getString("Nombres"));
            reg.setApellidos(rs.getString("Apellidos"));
            reg.setSeminarios(rs.getString("Seminarios"));
            reg.setConfirmado(rs.getBoolean("Confirmado"));
            reg.setFecha_Inscripcion(rs.getString("Fecha_Inscripcion"));
            lista.add(reg);
        }
        return lista;
    }

    @Override
    public Registro getById(int id) throws Exception {
        Registro reg = new Registro ();
        try {
        String sql = "select * from estudiantes where id=?";
        this.conectar();
        PreparedStatement ps  = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            reg.setId(rs.getInt("id"));
            reg.setNombres(rs.getString("Nombres"));
            reg.setApellidos(rs.getString("Apellidos"));
            reg.setSeminarios(rs.getString("Seminarios"));
            reg.setConfirmado(rs.getBoolean("Confirmado"));
            reg.setFecha_Inscripcion(rs.getString("Fecha_Inscripcion"));
        }
            
        }catch (SQLException e){
            throw e;
        } finally {
                    this.desconectar();
        } 
        return reg;
   }   
   
}
