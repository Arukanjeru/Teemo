package com.Meza;

import com.Meza.excepciones.ErrorValidacion;

public class Cliente {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Cliente(String id, String nombre, String apellido){

    }

    public String getId(){
        return id;
    }

    public void setId(String nuevoId) throws Exception {
        if(id.length() != 13){
            throw new ErrorValidacion("El numero de indentidad debe contener 13 caracteres");
        }
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nuevoNombre){

    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String nuevoApellido){

    }

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }


    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono) throws ErrorValidacion {
        if (!telefono.matches("^(\\+?504\\s?)?[0-9]{4}\\-?[0-9]{4}")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;

    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) throws ErrorValidacion {
        if (!email.matches("([a-z\\d\\.-]+)@([a-z\\d-]+)(\\.[a-z]{2,8})(\\.[a-z]{2,8})?")){
            throw new ErrorValidacion("Correo electronico invalido");

        }
        this.email = email;

    }


}
