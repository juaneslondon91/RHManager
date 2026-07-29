package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase encargada de establecer la conexión con la base de datos RHManager.
 * Utiliza JDBC para conectarse al servidor MySQL.
 */

public class ConexionBD {

    // URL de conexión a la base de datos
    private static final String URL =
            "jdbc:mysql://localhost:3306/RHManager";

    // Usuario de la base de datos
    private static final String USUARIO = "root";

    // Contraseña de la base de datos
    private static final String PASSWORD = "123456";

    /**
     * Establece y retorna una conexión con la base de datos.
     * @return objeto Connection si la conexión es exitosa.
     */
    public static Connection conectar() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    PASSWORD
            );

            System.out.println("Conexion exitosa con MySQL");

        } catch (Exception e) {

            System.out.println("Error de conexion: "
                    + e.getMessage());
        }

        return conexion;
    }
}