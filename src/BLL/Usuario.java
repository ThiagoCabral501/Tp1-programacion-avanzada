package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.Conexion;
import DLL.DLLUsuario;

public class Usuario {
    protected int id;
    protected String nombre;
    protected String email;
    protected String tipo;
    protected String password;

    public Usuario(int id, String nombre, String email, String tipo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
        this.password = password;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", tipo=" + tipo + ", password="
                + password + "]";
    }

    public static Usuario login(String nombre,String contrasenia) {
		
		if (nombre.isEmpty() || contrasenia.isEmpty()) {
			//JOptionPane.showMessageDialog(null, "No puede estar vacio");
		}else {
			return DLLUsuario.login(nombre, contrasenia);

		}
		return null;
	}
	
	public static void RegistrarUsuario(Usuario usuario) {
		DLLUsuario.RegistrarUsuario(usuario);
	}
	
}
