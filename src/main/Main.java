package main;

import dao.EmpleadoDAO;

public class Main {

    public static void main(String[] args) {

        EmpleadoDAO dao = new EmpleadoDAO();

        dao.eliminarEmpleado(6);

    }
}