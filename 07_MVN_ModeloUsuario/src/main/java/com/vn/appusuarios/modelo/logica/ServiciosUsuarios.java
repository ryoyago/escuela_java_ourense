package com.vn.appusuarios.modelo.logica;

import com.vn.appusuarios.modelo.dao.DaoUsuarioImp;
import com.vn.appusuarios.modelo.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Metodos para la verificacion de datos e interactua con la base de datos
 * db_usuarios
 *
 * @author grupo-4
 */
public class ServiciosUsuarios implements ChivatoServicios {

    private DaoUsuarioImp dui;
    private ChivatoServicios chivato;

    public ServiciosUsuarios() {
        try {
            this.dui = new DaoUsuarioImp();
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("ServiciosUsuarios(). " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("ServiciosUsuarios(). " + ex.getMessage());
        }
    }

    public void setChivato(ChivatoServicios chivato) {
        this.chivato = chivato;
    }

    /**
     * Metodo de creacion de un usuario
     *
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     */
    public Usuario crear(String email, String password, String nombre, String edad) {

        Usuario usuarioValido = crearUsuarioValido(email, password, nombre, edad);

        if (usuarioValido != null) {
            try {
                if (this.dui.leerUno(email) == null) {
                    Usuario usuarioCreado = this.dui.crearNuevo(usuarioValido);
                    if (null != usuarioCreado) {
                        return usuarioCreado;
                    } else {
                        notificarError("crear(). " + "Error al intentar crear el usuario.");
                    }
                } else {
                    notificarError("crear(). " + "Ya existe un usuario en la bbdd con este email.");
                }
            } catch (Exception ex) {
                Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                notificarError("crear(). " + ex.getMessage());
            }
        } else {
            notificarError("crear(). " + "Error al intentar validar dos datos dados.");
        }
        return null;
    }

    /**
     * Metodo para modificar los parametros de un usuario
     *
     * @param id
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     */
    public Usuario modificar(int id, String email, String password, String nombre, String edad) {

        Usuario usuarioValido = crearUsuarioValido(email, password, nombre, edad);

        if (usuarioValido != null) {
            try {
                if (null != this.dui.leerUno(id)) {
                    usuarioValido.setId(id);
                    if (null != dui.actualizar(usuarioValido)) {
                        return usuarioValido;
                    } else {
                        notificarError("modificar(). " + "No se ha podido actualizar el usuario.");
                    }
                } else {
                    notificarError("modificar(). " + "El usuario que intenta modificar no existe.");
                }
            } catch (Exception ex) {
                Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                notificarError("modificar(). " + ex.getMessage());
            }
        } else {
            notificarError("modificar(). " + "Error al intentar validar dos datos dados.");
        }
        return null;
    }

    /**
     * Modificar los datos de un usuario
     *
     * @param usuDatosNuevos
     * @return
     */
    public Usuario modificar(Usuario usuDatosNuevos) {

        String edad = String.valueOf(usuDatosNuevos.getAge());

        return this.modificar(usuDatosNuevos.getId(),
                usuDatosNuevos.getEmail(),
                usuDatosNuevos.getPassword(),
                usuDatosNuevos.getNombre(),
                edad);
    }

    /**
     * Eliminacion de un usuario por Id
     *
     * @param id
     * @return
     */
    public boolean eliminar(int id) {
        try {
            if (null != this.dui.leerUno(id)) {
                if (dui.eliminar(id)) {
                    return true;
                } else {
                    notificarError("eliminar(int id)." + "Error. No se ha podido eliminar el usuario.");
                }
            } else {
                notificarError("eliminar(int id). " + "El usuario que intenta eliminar no existe.");
            }
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError(ex.getMessage());
            return false;
        }
    }

    /**
     * Metodo para leer un usuario por su Id
     *
     * @param id
     * @return
     */
    public Usuario leerUno(int id) {
        try {
            return dui.leerUno(id);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerUno(int id). " + ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo para leer un usuario por su Email
     *
     * @param email
     * @return
     */
    public Usuario leerUno(String email) {
        try {
            return dui.leerUno(email);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerUno(String email). " + ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo para leer por nombre los usuarios
     *
     * @param nombre
     * @return
     */
    public List<Usuario> leerPorNombre(String nombre) {
        try {
            return dui.leerTodos(nombre);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerPorNombre(String nombre). " + ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo para leer todos los usuarios
     *
     * @return
     */
    public List<Usuario> leerTodos() {
        try {
            return dui.leerTodos();
        } catch (Exception ex) {
            Logger.getLogger(ServiciosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerTodos(). " + ex.getMessage());
            return null;
        }
    }

    /**
     * Método para validar datos y generar usuarios válidos.
     *
     *
     * @param email del usuario válido
     * @param password del usuario con mínimo 4 caracteres
     * @param nombre del usuario con mínimo 1 letra
     * @param edad del usuario mayor de 12 años
     * @return Usuario válido or null si surge algún problema
     */
    public Usuario crearUsuarioValido(String email, String password, String nombre, String edad) {

        if (email != null
                && password != null
                && nombre != null
                && edad != null) {
            if (email.length() >= 3
                    && nombre.length() > 1
                    && password.length() >= 4
                    && !"".equals(edad)) {
                String regExp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
                Pattern pattern = Pattern.compile(regExp);
                Matcher matcher = pattern.matcher(email);
                if (matcher.find()) {
                    try {
                        int iEdad = Integer.parseInt(edad);
                        if (iEdad > 12) {
                            Usuario usuario = new Usuario(-1, email, password, nombre, iEdad);
                            return usuario;
                        } else {
                            return null;
                        }
                    } catch (NumberFormatException nfe) {
                        notificarError("crearUsuarioValido(). " + "La edad no puede ser convertida a int: " + edad + ". " + nfe.getMessage());
                        return null;
                    } catch (Exception e) {
                        notificarError("crearUsuarioValido(). " + "Error al crear el objeto usuario: " + e.getMessage());
                        return null;
                    }
                } else {
                    notificarError("crearUsuarioValido(). " + "El email introducido no es válido.");
                    return null;
                }
            } else {
                notificarError("crearUsuarioValido(). " + "Uno de los campos no tiene la longitud mínima requerida.");
                return null;
            }
        } else {
            notificarError("crearUsuarioValido(). " + "No admiten valores nulos en los datos del usuario.");
            return null;
        }
    }

    @Override
    public void notificarError(String mensajeError) {
        System.out.println(">>ERROR ServicioUsuarios: " + mensajeError);
        if (chivato != null) {
            this.chivato.notificarError(mensajeError);
        }
    }

}
