package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.Usuario;

public class DLLUsuario {
	
	private static Connection con = Conexion.getInstance().getConnection();

    public static Usuario login(String nombre, String password) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE nombre = ? AND password = ?"
            );
            stmt.setString(1, nombre);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String tipo = rs.getString("tipo");
                usuario = new Usuario(id, nombre, email, tipo, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public static void agregarUsuario(Usuario usuario) {
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO `usuario`(`nombre`, `email`, `tipo`, `password`) VALUES (?, ?, ?, ?)"
            );
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getTipo());
            statement.setString(4, usuario.getPassword());

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario agregado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RegistrarUsuario(Usuario nuevo) {
        LinkedList<Usuario> existentes = mostrarUsuarios();
        boolean flag = true;
        for (Usuario existente : existentes) {
        	if (existente.getEmail() != null && existente.getEmail().equals(nuevo.getEmail())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            agregarUsuario(nuevo);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario ya creado");
        }
    }

    public static LinkedList<Usuario> mostrarUsuarios() {
        LinkedList<Usuario> usuarios = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String tipo = rs.getString("tipo");
                String password = rs.getString("password");

                usuarios.add(new Usuario(id, nombre, email, tipo, password));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}
