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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maggie
 */
public class controladorClienteListar {

    DtoCliente cliente = new DtoCliente();

    public controladorClienteListar() {

    }

    public ArrayList<String> controladorClienteListar() {
        List<DtoCliente> lista = null;
        ArrayList<String> hi=new ArrayList<String>();
        
        try {
            // conectarme a la bd

            String dbIP = "localhost";
            String dbName = "sigsigma";
            String dbUsuario = "root";
            String dbPass = "root";

            // Obtener la conexión única desde la clase ConexionMySQL
            Connection conn = conexionMySQL.getConexionUnica(dbIP, dbName,
                    dbUsuario, dbPass);

            DaoCliente daoCli = new DaoCliente(conn);
            lista = daoCli.obtenerUsuario();
            
            
            //convertir arraylis
            
            for (int i = 0; i < lista.size(); i++) {
                hi.add(String.valueOf(lista.get(i).getIdCliente()));
                hi.add(String.valueOf(lista.get(i).getNombre()));
                hi.add(String.valueOf(lista.get(i).getApellido_paterno()));
                hi.add(String.valueOf(lista.get(i).getApellido_materno()));
                hi.add(String.valueOf(lista.get(i).getEdad()));
                hi.add(String.valueOf(lista.get(i).getDireccion()));
            }
            
             for(int i = 0;i<hi.size();i++){
            System.out.println("fila numero "+i+" "+hi.get(i));
            }
            
            
            

        } catch (Exception e) {
            System.out.println("Error: " + e);

        }
        return hi;
    }

}
