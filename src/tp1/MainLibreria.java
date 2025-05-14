package tp1;

import javax.swing.JOptionPane;

public class MainLibreria {

	public static void main(String[] args) {
		String[] opcionesAdmin = { "Ver propuestas", "Aceptar/Rechazar propuestas", "Publicar Libros", "Salir" };
        String[] opcionesAutor = { "Enviar propuesta", "Ver estado de propuestas", "Cancelar propuesta", "Ver ventas", "Salir" };
        
        String usuario;
        
        do {
            usuario = JOptionPane.showInputDialog("Ingrese usuario:");
            String contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");

            if (usuario.equals("admin") && contrasena.equals("admin123")) {
                int elegido;
                do {
                    elegido = JOptionPane.showOptionDialog(null, "Bienvenido Administrador", "Menú",
                            0, 0, null, opcionesAdmin, opcionesAdmin);
                    switch (elegido) {
                        case 0:
                            JOptionPane.showMessageDialog(null, "Mostrando propuestas...");
                            JOptionPane.showMessageDialog(null, "Propuesta Ejemplo:\nTitulo: 'Viaje a Jupiter'\nAutor: 'Juan perez'\nResumen: 'Una aventura espacial.'");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "Gestionando propuestas...");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Publicando libros...");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                            break;
                    }
                } while (elegido != 3);
            } else if (usuario.equals("autor1") && contrasena.equals("autor123")) {
                int elegido;
                do {
                    elegido = JOptionPane.showOptionDialog(null, "Bienvenido Autor", "Menú",
                            0, 0, null, opcionesAutor, opcionesAutor);
                    switch (elegido) {
                        case 0:
                            JOptionPane.showMessageDialog(null, "Enviando propuesta de libro...");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "Viendo estado de las propuestas...");
                            JOptionPane.showMessageDialog(null, "Propuesta enviada:\nTitulo: 'Viaje a Jupiter'\nEstado: Pendiente de revision");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Elegir propuesta a cancelar...");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Mostrando estadisticas de ventas...");
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                            break;
                    }
                } while (elegido != 4);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

        } while (usuario != null && !usuario.isEmpty());

	}

}
