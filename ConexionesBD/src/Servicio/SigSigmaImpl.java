/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Controlador.controladorClienteDelete;
import Controlador.controladorClienteInset;
import Controlador.controladorClienteListar;
import Controlador.controladorClienteSearch;
import Controlador.controladorClienteUpdate;
import DTO.DtoCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maggie
 */
public class SigSigmaImpl implements InterfaceSigSigma{

    @Override
    public String insertarCliente(String Nombre, String Apellido_paterno, String Apellido_materno, String Edad, String Direccion) {
        controladorClienteInset insertar=new controladorClienteInset(Nombre, Apellido_paterno, Apellido_materno, Edad, Direccion);
        String mensaje=insertar.controladorClienteInset();
        return mensaje;
    }

    @Override
    public ArrayList<String> listarClientes() {
        controladorClienteListar listar=new controladorClienteListar();
        ArrayList<String> lista=listar.controladorClienteListar();
        return lista;
    }

    @Override
    public String actualizarRegistro(int id, String Nombre, String Apellido_paterno, String Apellido_materno, String Edad, String Direccion) {
        controladorClienteUpdate actualizar=new controladorClienteUpdate(id, Nombre, Apellido_paterno, Apellido_materno, Edad, Direccion);
        String respuesta=actualizar.controladorClienteUpdate();
        return respuesta;
    }

    @Override
    public String eliminarRegistro(int id) {
        controladorClienteDelete eliminar=new controladorClienteDelete(id);
        String respuesta=eliminar.controladorClienteDelete();
        return respuesta;
    }

    @Override
    public ArrayList<String> buscarCliente(int id) {
        controladorClienteSearch search=new controladorClienteSearch(id);
        ArrayList<String> lista=search.controladorClienteSeach();
        return lista;
    }


    
}
