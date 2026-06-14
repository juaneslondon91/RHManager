package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/RHManager";

    private static final String USUARIO = "root";

    private static final String PASSWORD = "123456";

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