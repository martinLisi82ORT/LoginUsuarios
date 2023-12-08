package com.proyecto.login.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol implements Serializable {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nomRol;
    private String descripcion;

    @OneToMany(mappedBy = "unRol")
    private List<Usuario> listaUsuarios;

    public Rol() {
    }

    public Rol(int id, String nomRol, String descripcion, List<Usuario> listaUsuarios) {
        this.id = id;
        this.nomRol = nomRol;
        this.descripcion = descripcion;
        this.listaUsuarios = listaUsuarios;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
