package com.gestion.empleados.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "clients")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")    
    private Long id;
    
    @Column(name = "client_name", nullable = false, length =60)
    private String nombre;

    @Column(name = "client_address", nullable = false, length = 60)
    private String direccion;

    @Column(name = "client_email", nullable = false, unique = true)
    private String correo;

    @Column(name = "client_phone", nullable = false)
    private String telefono;

    public Cliente() {

    }

    public Cliente(Long id, String nombre, String direccion, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
