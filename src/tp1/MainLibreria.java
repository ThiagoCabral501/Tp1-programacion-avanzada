package tp1;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class MainLibreria {

    public static void main(String[] args) {
        String[] menuPrincipal = { "Login", "Registrar", "Salir" };
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Bienvenido a la Librería", "Menú Principal",
                    0, 0, null, menuPrincipal, menuPrincipal[0]);

            switch (opcion) {
                case 0: // Login
                    String usuario = JOptionPane.showInputDialog("Ingrese usuario:");
                    String contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");
                    
                    Usuario user = Usuario.login(usuario, contrasena);
                    
                    if (user != null) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + user.getNombre());

                        if (user.getTipo().equalsIgnoreCase("admin")) {
                            menuAdmin();
                        } else {
                            menuAutor(user);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                    break;

                case 1: // Registrar
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String tipo = JOptionPane.showInputDialog("Tipo (admin o autor):");
                    String pass = JOptionPane.showInputDialog("Contraseña:");

                    Usuario nuevo = new Usuario(0, nombre, email, tipo.toLowerCase(), pass);
                    Usuario.RegistrarUsuario(nuevo);
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                    break;
            }
        } while (opcion != 2);
    }

    public static void menuAdmin() {
        String[] opcionesAdmin = { "Ver propuestas", "Aceptar/Rechazar propuestas", "Publicar Libros", "Salir" };
        int elegido;
        do {
            elegido = JOptionPane.showOptionDialog(null, "Menú Administrador", "Opciones",
                    0, 0, null, opcionesAdmin, opcionesAdmin[0]);
            switch (elegido) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Mostrando propuestas...");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Gestionando propuestas...");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Publicando libros...");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del menú administrador...");
                    break;
            }
        } while (elegido != 3);
    }

    public static void menuAutor(Usuario usuario) {
        String[] opcionesAutor = { "Enviar propuesta", "Ver estado de propuestas", "Cancelar propuesta", "Ver ventas", "Salir" };
        int elegido;
        do {
            elegido = JOptionPane.showOptionDialog(null, "Menú Autor", "Opciones",
                    0, 0, null, opcionesAutor, opcionesAutor[0]);
            switch (elegido) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Enviando propuesta de libro...");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Viendo estado de las propuestas...");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Elegir propuesta a cancelar...");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Mostrando estadísticas de ventas...");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del menú autor...");
                    break;
            }
        } while (elegido != 4);
    }
}
