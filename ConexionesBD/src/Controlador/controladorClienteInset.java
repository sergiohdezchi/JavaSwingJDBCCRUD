/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTO.DtoCliente;
import Datos.DaoCliente;
import Datos.conexionMySQL;
import java.sql.Connection;

/**
 *
 * @author maggie
 */
public class controladorClienteInset {

    private String Nombre;
    private String Apellido_paterno;
    private String Apellido_materno;
    private String Edad;
    private String Direccion;
    DtoCliente cliente= new  DtoCliente();

    public controladorClienteInset(String Nombre, String Apellido_paterno, String Apellido_materno, String Edad, String Direccion) {
        this.Nombre = Nombre;
        this.Apellido_paterno = Apellido_paterno;
        this.Apellido_materno = Apellido_materno;
        this.Edad = Edad;
        this.Direccion = Direccion;
		
    }

    public String controladorClienteInset() {
        
        cliente.setNombre(Nombre);
        cliente.setApellido_paterno(Apellido_paterno);
        cliente.setApellido_materno(Apellido_materno);
        cliente.setEdad(Edad);
        cliente.setDireccion(Direccion);
        String mensaje="";
        
        try {
            // conectarme a la bd

            String dbIP = "localhost";
            String dbName = "sigsigma";
            String dbUsuario = "root";
            String dbPass = "root";

            // Obtener la conexión única desde la clase ConexionMySQL
            Connection conn = conexionMySQL.getConexionUnica(dbIP, dbName,
                    dbUsuario, dbPass);
            
            DaoCliente daoCli=new DaoCliente(conn);
            int idcliente=daoCli.insertarCliente(cliente);
            mensaje="Agregado con exito";

        } catch (Exception e) {
            System.out.println("Error: "+ e);
            mensaje="Error";
        }

        return mensaje;
    }

}
