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
public class controladorClienteDelete {
    private int id;
    DtoCliente dtoCliente=new DtoCliente();
    
    
    public controladorClienteDelete(int id){
        this.id=id;
        
    }
    
    
    public String controladorClienteDelete(){
        dtoCliente.setIdCliente(id);
        String mensaje="";
        
        
        try {
            String dbIP = "localhost";
            String dbName = "sigsigma";
            String dbUsuario = "root";
            String dbPass = "root";
            
            
            Connection conn=conexionMySQL.getConexionUnica(dbIP, dbName, dbUsuario, dbPass);
            DaoCliente daocli=new DaoCliente(conn);
            int s=daocli.eliminarCliente(dtoCliente);
            mensaje="Eliminado con exito";
            
            
        } catch (Exception e) {
            mensaje="Error no eliminado";
        }
        return mensaje;
    }
    
    
    
}
