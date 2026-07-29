package dao;

import conexion.ConexionBD;
import modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Clase encargada de realizar las operaciones CRUD
 * de los empleados en la base de datos RHManager.
 */

public class EmpleadoDAO {

        
/**
 * Inserta un nuevo empleado en la base de datos.
 * @param empleado objeto con la información del empleado.
 */    
    public void insertarEmpleado(Empleado empleado) {

        // Consulta SQL para insertar un empleado
        String sql = "INSERT INTO RHManager_Empleados " +
                "(Nombre, Documento, Salario, IdArea, IdCargo, Estado) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // Se establece la conexión con la base de datos    
            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getDocumento());
            ps.setDouble(3, empleado.getSalario());
            ps.setInt(4, empleado.getIdArea());
            ps.setInt(5, empleado.getIdCargo());
            ps.setBoolean(6, empleado.isEstado());
            
            // Se ejecuta la consulta
            ps.executeUpdate();

            System.out.println("Empleado insertado correctamente");

            conexion.close();

        } catch (Exception e) {

            System.out.println("Error al insertar: "
                    + e.getMessage());
        }
    }

/**
 * Obtiene la lista de empleados registrados.
 * @return lista de empleados.
 */
    public void listarEmpleados() {

    String sql = "SELECT * FROM RHManager_Empleados";

    try {

        Connection conexion = ConexionBD.conectar();

        PreparedStatement ps =
                conexion.prepareStatement(sql);

        var rs = ps.executeQuery();

        System.out.println("LISTA DE EMPLEADOS");

        while (rs.next()) {

            System.out.println("-------------------");

            System.out.println(
                    "ID: " + rs.getInt("Id"));

            System.out.println(
                    "Nombre: "
                            + rs.getString("Nombre"));

            System.out.println(
                    "Documento: "
                            + rs.getString("Documento"));

            System.out.println(
                    "Salario: "
                            + rs.getDouble("Salario"));

            System.out.println(
                    "Area ID: "
                            + rs.getInt("IdArea"));

            System.out.println(
                    "Cargo ID: "
                            + rs.getInt("IdCargo"));

            System.out.println(
                    "Estado: "
                            + rs.getBoolean("Estado"));
        }

        conexion.close();

    } catch (Exception e) {

        System.out.println(
                "Error al listar: "
                        + e.getMessage());
    }
}

/**
 * Actualiza la información de un empleado.
 */
    public void actualizarEmpleado(Empleado empleado) {

    String sql = "UPDATE RHManager_Empleados " +
            "SET Nombre = ?, Salario = ? " +
            "WHERE Id = ?";

    try {

        Connection conexion = ConexionBD.conectar();

        PreparedStatement ps =
                conexion.prepareStatement(sql);

        ps.setString(1, empleado.getNombre());

        ps.setDouble(2, empleado.getSalario());

        ps.setInt(3, empleado.getId());

        int filas =
                ps.executeUpdate();

        if (filas > 0) {

            System.out.println(
                    "Empleado actualizado correctamente");

        } else {

            System.out.println(
                    "No se encontro el empleado");
        }

        conexion.close();

    } catch (Exception e) {

        System.out.println(
                "Error al actualizar: "
                        + e.getMessage());
    }
}

/**
 * Elimina un empleado de la base de datos.
 */
    public void eliminarEmpleado(int id) {

    String sql =
            "DELETE FROM RHManager_Empleados WHERE Id = ?";

    try {

        Connection conexion = ConexionBD.conectar();

        PreparedStatement ps =
                conexion.prepareStatement(sql);

        ps.setInt(1, id);

        int filas =
                ps.executeUpdate();

        if (filas > 0) {

            System.out.println(
                    "Empleado eliminado correctamente");

        } else {

            System.out.println(
                    "No se encontro el empleado");
        }

        conexion.close();

    } catch (Exception e) {

        System.out.println(
                "Error al eliminar: "
                        + e.getMessage());
    }
}
}
