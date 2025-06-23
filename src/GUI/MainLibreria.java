package GUI;

import java.util.LinkedList;
import javax.swing.JOptionPane;

import BLL.Libro;
import BLL.Usuario;
import DLL.DLLLibro;

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
                        } else if (user.getTipo().equalsIgnoreCase("autor")) {
                            menuAutor(user);
                        } else if (user.getTipo().equalsIgnoreCase("cliente")) {
                            menuCliente(user);
                        } else {
                            JOptionPane.showMessageDialog(null, "Tipo de usuario no reconocido.");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                    break;

                case 1: // Registrar
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String tipo = JOptionPane.showInputDialog("Tipo (admin, autor o cliente):");
                    String pass = JOptionPane.showInputDialog("Contraseña:");

                    Usuario nuevo = new Usuario(0, nombre, email, tipo.toLowerCase(), pass);
                    Usuario.RegistrarUsuario(nuevo);
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                    break;
            }
        } while (opcion != 2);
    }

    public static void menuAdmin() {
        String[] opcionesAdmin = { "Ver propuestas", "Aceptar/Rechazar propuestas", "Publicar Libros", "Administrar Stock", "Salir" };
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
                    try {
                        String idStr = JOptionPane.showInputDialog("ID del libro:");
                        int idLibro = Integer.parseInt(idStr);

                        String cantidadStr = JOptionPane.showInputDialog("Cantidad a aumentar:");
                        int cantidad = Integer.parseInt(cantidadStr);

                        DLLLibro.aumentarStock(idLibro, cantidad);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida.");
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del menú administrador...");
                    break;
            }
        } while (elegido != 4);
    }

    public static void menuAutor(Usuario usuario) {
        String[] opcionesAutor = { "Enviar propuesta", "Ver estado de propuestas", "Cancelar propuesta", "Ver ventas", "Salir" };
        int elegido;
        do {
            elegido = JOptionPane.showOptionDialog(null, "Menú Autor", "Opciones",
                    0, 0, null, opcionesAutor, opcionesAutor[0]);
            switch (elegido) {
                case 0://Enviar propuesta de libro
                	String titulo = JOptionPane.showInputDialog("Título del libro:");
                    String descripcion = JOptionPane.showInputDialog("Descripción del libro:");
                    String genero = JOptionPane.showInputDialog("Género del libro:");
                    String fecha = JOptionPane.showInputDialog("Fecha de envío (YYYY-MM-DD):");
                    String archivo = JOptionPane.showInputDialog("Nombre del archivo (PDF):");
                    String estado = "pendiente";
                    int stock = 0; // El autor no define stock
                    double precio = 0.0;
                    
                    Libro nuevoLibro = new Libro(0, titulo, descripcion, genero, fecha, archivo, estado, usuario.getId(), stock, precio);
                    DLLLibro.agregarLibro(nuevoLibro);
                    
                    JOptionPane.showMessageDialog(null, "Propuesta enviada con éxito.");
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
    

    public static void menuCliente(Usuario usuario) {
        String[] opcionesCliente = { "Comprar libro", "Salir" };
        int elegido;
        do {
            elegido = JOptionPane.showOptionDialog(null, "Menú Cliente", "Opciones",
                    0, 0, null, opcionesCliente, opcionesCliente[0]);
            switch (elegido) {
                case 0: // Comprar libro
                    try {
                        String idLibroStr = JOptionPane.showInputDialog("ID del libro a comprar:");
                        int idLibro = Integer.parseInt(idLibroStr);

                        String cantidadStr = JOptionPane.showInputDialog("Cantidad:");
                        int cantidad = Integer.parseInt(cantidadStr);

                        DLLLibro.actualizarStock(idLibro, cantidad);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida.");
                    }
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Saliendo del menú cliente...");
                    break;
            }
        } while (elegido != 1);
    }

    
}
