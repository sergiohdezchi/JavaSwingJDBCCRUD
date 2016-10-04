
package Controlador;

import DTO.DtoCliente;
import Datos.DaoCliente;
import Datos.conexionMySQL;
import java.sql.Connection;

/**
 *
 * @author maggie
 */
public class controladorClienteUpdate {
    private int idCliente;
    private String Nombre;
    private String Apellido_paterno;
    private String Apellido_materno;
    private String Edad;
    private String Direccion;
    DtoCliente cliente= new  DtoCliente();
    
    public controladorClienteUpdate(int idCliente, String Nombre, String Apellido_paterno, String Apellido_materno, String Edad, String Direccion){
        this.idCliente=idCliente;
        this.Nombre = Nombre;
        this.Apellido_paterno = Apellido_paterno;
        this.Apellido_materno = Apellido_materno;
        this.Edad = Edad;
        this.Direccion = Direccion;
    }
    
    public String controladorClienteUpdate(){
        cliente.setIdCliente(idCliente);
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

            Connection conn=conexionMySQL.getConexionUnica(dbIP, dbName, dbUsuario, dbPass);
            
            DaoCliente daoCli=new DaoCliente(conn);
            int id=daoCli.actualizarCliente(cliente);
            mensaje="Registro actualizado con exito";
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return mensaje;
    }
    
    
    
}
