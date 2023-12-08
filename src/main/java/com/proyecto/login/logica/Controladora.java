package com.proyecto.login.logica;

import com.proyecto.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {
        //String mensaje = "";
        Usuario user = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        for (Usuario usu : listaUsuarios) {
            if (usu.getNomUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    user = usu;
                    return user;
                } else {
                    user = null;
                    return user;
                }
            } else {
                user = null;
                // return user;
            }
        }

        return user;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        Usuario user = new Usuario();
        user.setNomUsuario(usuario);
        user.setContrasenia(contra);

        Rol rol = new Rol();
        rol = this.traerRol(rolRecibido);
        if (rol != null) {
            user.setUnRol(rol);
        }

        int id = this.buscarUltimoId();
        user.setId(id + 1);

        controlPersis.crearUsuario(user);

    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();

        for (Rol rol : listaRoles) {
            if (rol.getNomRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimoId() {
        List<Usuario> listaUsuario = this.traerUsuarios();

        Usuario user = listaUsuario.get(listaUsuario.size() - 1);
        return user.getId();

    }

    public void eliminarUsuario(int id_User) {
        controlPersis.eliminarUsuario(id_User);
    }

    public Usuario traerUsuario(int id_User) {
        return controlPersis.traerUsuario(id_User);
    }

    public void editarUsuario(Usuario user, String usuario, String contra, String rolRecibido) {
       user.setNomUsuario(usuario);
       user.setContrasenia(contra);
       
        Rol rol = new Rol();
        rol = this.traerRol(rolRecibido);
        if (rol != null) {
            user.setUnRol(rol);
        }
       controlPersis.editarUsuario(user);
    }

}
