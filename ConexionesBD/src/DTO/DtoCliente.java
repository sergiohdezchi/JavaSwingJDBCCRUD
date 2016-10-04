/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author maggie
 */
public class DtoCliente {

    private int idCliente;
    private String Nombre;
    private String Apellido_paterno;
    private String Apellido_materno;
    private String Edad;
    private String Direccion;

    
    
    
    
    
    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido_paterno
     */
    public String getApellido_paterno() {
        return Apellido_paterno;
    }

    /**
     * @param Apellido_paterno the Apellido_paterno to set
     */
    public void setApellido_paterno(String Apellido_paterno) {
        this.Apellido_paterno = Apellido_paterno;
    }

    /**
     * @return the Apellido_materno
     */
    public String getApellido_materno() {
        return Apellido_materno;
    }

    /**
     * @param Apellido_materno the Apellido_materno to set
     */
    public void setApellido_materno(String Apellido_materno) {
        this.Apellido_materno = Apellido_materno;
    }

    /**
     * @return the Edad
     */
    public String getEdad() {
        return Edad;
    }

    /**
     * @param Edad the Edad to set
     */
    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return "datoCliente{" + "Nombre=" + Nombre + ", Apellido_paterno=" + Apellido_paterno + ", Apellido_materno=" + Apellido_materno + ", Edad=" + Edad + ", Direccion=" + Direccion + '}';
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    
    
    
    
}
