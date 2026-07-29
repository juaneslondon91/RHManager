package main;

import dao.EmpleadoDAO;

/**
 * Clase principal del proyecto RHManager.
 * Permite ejecutar y probar las operaciones del sistema.
 */
public class Main {

    public static void main(String[] args) {

        // Crear una instancia del objeto DAO
        EmpleadoDAO dao = new EmpleadoDAO();

        // Eliminar el empleado con ID 6
        dao.eliminarEmpleado(6);

    }
}