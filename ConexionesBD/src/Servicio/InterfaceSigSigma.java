/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import DTO.DtoCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maggie
 */
public interface InterfaceSigSigma {
    public String insertarCliente(String Nombre, String Apellido_paterno, String Apellido_materno, String Edad, String Direccion);
    public ArrayList<String> listarClientes();
    public String actualizarRegistro(int id, String Nombre, String Apellido_paterno, String Apellido_materno, String Edad, String Direccion);
    public String eliminarRegistro(int id);
    public ArrayList<String> buscarCliente(int id);
}
