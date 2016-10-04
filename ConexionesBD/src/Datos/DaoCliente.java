/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import DTO.DtoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maggie
 */
public class DaoCliente {
    private Connection conexion;
    
    public DaoCliente(Connection conexion){
        this.conexion=conexion;
    }
    
    private static final String insertarCliente = "insert into cliente values (null,?,?,?,?,?)";

    private static final String obtenerClientes = "select * from cliente";
    
    private static final String buscarCliente = "select * from cliente where idCliente=?";

    private static final String actualizarCliente = "update cliente set Nombre=?, Apellido_paterno=?, Apellido_materno=?, Edad=?, Direccion=? where idCliente=?";

    private static final String eliminarCliente = "DELETE FROM cliente WHERE idCliente=?";
    
    //insert
    public int insertarCliente(DtoCliente cliente) throws SQLException {

		PreparedStatement sentencia;
		ResultSet rs;
		int id = 0;

		sentencia = conexion.prepareStatement(insertarCliente, Statement.RETURN_GENERATED_KEYS);

		sentencia.setString(1, cliente.getNombre());
		sentencia.setString(2, cliente.getApellido_paterno());
		sentencia.setString(3, cliente.getApellido_materno());
		sentencia.setString(4, cliente.getEdad());
                sentencia.setString(5, cliente.getDireccion());
                
		sentencia.executeUpdate();
		rs = sentencia.getGeneratedKeys();

		if (rs.next()) {
			id = rs.getInt(1);
		}

		rs.close();
		sentencia.close();

		return id;

    }
    
    //list
    
    public List<DtoCliente> obtenerUsuario() throws SQLException {
		Statement sentencia;
		ResultSet rs;
		List<DtoCliente> listaCliente = new ArrayList<DtoCliente>();
		DtoCliente cliente;
		sentencia = conexion.createStatement();
		rs = sentencia.executeQuery(obtenerClientes);

		while (rs.next()) {
			cliente = new DtoCliente();
			cliente.setIdCliente(rs.getInt(1));
			cliente.setNombre(rs.getString(2));
			cliente.setApellido_paterno(rs.getString(3));
			cliente.setApellido_materno(rs.getString(4));
			cliente.setEdad(rs.getString(5));
                        cliente.setDireccion(rs.getString(6));
			listaCliente.add(cliente);

		}

		return listaCliente;
    }
    
    //update
    
    public int actualizarCliente(DtoCliente cliente) throws SQLException {
		PreparedStatement sentencia;
		ResultSet rs;
		int id = 0;

		sentencia = conexion.prepareStatement(actualizarCliente, Statement.RETURN_GENERATED_KEYS);

		sentencia.setString(1, cliente.getNombre());
		sentencia.setString(2, cliente.getApellido_paterno());
		sentencia.setString(3, cliente.getApellido_materno());
		sentencia.setString(4, cliente.getEdad());
		sentencia.setString(5, cliente.getDireccion());
                sentencia.setInt(6, cliente.getIdCliente());

		sentencia.executeUpdate();
		rs = sentencia.getGeneratedKeys();

		rs.close();
		sentencia.close();
		return id;
    }
    
    //search
    
        public List<DtoCliente> buscarCliente(DtoCliente cliente) throws SQLException {
		PreparedStatement sentencia;
		ResultSet rs;
		int id = 0;
                List<DtoCliente> listaCliente = new ArrayList<DtoCliente>();
                
		sentencia = conexion.prepareStatement(buscarCliente, Statement.RETURN_GENERATED_KEYS);
                sentencia.setInt(1, cliente.getIdCliente());
                rs=sentencia.executeQuery();
		while (rs.next()) {
			cliente = new DtoCliente();
			cliente.setIdCliente(rs.getInt(1));
			cliente.setNombre(rs.getString(2));
			cliente.setApellido_paterno(rs.getString(3));
			cliente.setApellido_materno(rs.getString(4));
			cliente.setEdad(rs.getString(5));
                        cliente.setDireccion(rs.getString(6));
			listaCliente.add(cliente);

		}
                
		rs.close();
		sentencia.close();
		return listaCliente;
    }
    
    //delete
    
    
    	public int eliminarCliente(DtoCliente cliente) throws SQLException {
		PreparedStatement sentencia;
		ResultSet rs;
		int id = 0;

		sentencia = conexion.prepareStatement(eliminarCliente, Statement.RETURN_GENERATED_KEYS);

		sentencia.setInt(1, cliente.getIdCliente());

		sentencia.executeUpdate();
		rs = sentencia.getGeneratedKeys();

		rs.close();
		sentencia.close();
		return id;
	}
    
    
    
    
}
