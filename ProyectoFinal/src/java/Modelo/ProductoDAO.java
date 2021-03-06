/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hye
 */
public class ProductoDAO {
   
 Conexion cn= new Conexion();
     Connection con;  
     
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int actualizarStock(int cant, int idp){
        String sql="update producto set Stock=? where idProducto=?";
        try {
           con=cn.Conexion();
              ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ps.setInt(1, cant);
            ps.setInt(2, idp);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Producto listarID(int id){
        Producto p = new Producto();
        String sql="select * from producto where IdProducto=?";
        try {
          con=cn.Conexion();
              ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ps.setInt(1, id);
            rs= ps.executeQuery();
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    public List listar() {
        List<Producto> lista = new ArrayList<>();
        String sql="select * from producto";
        try {
            con=cn.Conexion();
              ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto p= new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int add(Object[] o) {
        int r=0;
        String sql="insert into producto(Nombres,Precio,Stock,Estado) values(?,?,?,?)";
        try {
           con=cn.Conexion();
              ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r =ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int actualizar(Object[] o) {
        int r=0;
        String sql="update producto set Nombres=?,Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
           con=cn.Conexion();
              ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void eliminar(int id) {
        String sql="delete from producto where IdProducto=?";
        try {
           con=cn.Conexion();
              ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    
}

}
