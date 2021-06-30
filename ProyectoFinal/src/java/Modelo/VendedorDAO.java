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
public class VendedorDAO {

    Conexion cn= new Conexion();
     Connection con;  
     
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public Vendedor validar(String user,String dni){
     Vendedor em=new Vendedor();
      String sql="select * from Vendedor where User=? and Dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2,dni);
            rs=ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdVendedor"));
                em.setUser(rs.getString("user"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    /////
    public List listar(){
    String sql="select*from vendedor";
          List<Vendedor> lista = new ArrayList<>();
       
        try {
           con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
               Vendedor em= new Vendedor();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);   
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Vendedor em){
        
        String sql="insert into vendedor(Dni,Nombres,Telefono,Estado,User) values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setObject(1,em.getDni());
            ps.setObject(2,em.getNom());
            ps.setObject(3,em.getTel());
            ps.setObject(4,em.getEstado());
            ps.setObject(5,em.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public int actualizar(Vendedor em){
        String sql="update vendedor set Dni=?, Nombres=?,Telefono=?,Estado=?,User=? where IdVendedor=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setObject(1,em.getDni());
            ps.setObject(2,em.getNom());
            ps.setObject(3,em.getTel());
            ps.setObject(4,em.getEstado());
            ps.setObject(5,em.getUser());
            ps.setInt(6,em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public  Vendedor listarId(int id){
       Vendedor emp= new Vendedor();
        String sql="select * from vendedor where IdVendedor="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }    
        return emp;
    
    }
    public void delete(int id){
    String sql="delete from vendedor where IdVendedor=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
             ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       
    }

    
}
