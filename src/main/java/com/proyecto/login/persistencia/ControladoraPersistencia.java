package com.proyecto.login.persistencia;

import com.proyecto.login.logica.Rol;
import com.proyecto.login.logica.Usuario;
import com.proyecto.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    public void crearUsuario(Usuario user) {
        usuJpa.create(user);
    }

    public void eliminarUsuario(int id_User) {
        try {
            usuJpa.destroy(id_User);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id_User) {
        return usuJpa.findUsuario(id_User);
    }

    public void editarUsuario(Usuario user) {
        try {
            usuJpa.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
