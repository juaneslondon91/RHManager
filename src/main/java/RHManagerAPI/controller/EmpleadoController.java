package RHManagerAPI.controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final String url =
        "jdbc:mysql://localhost:3306/rhmanager";
    private final String usuario = "root";
    private final String clave = "123456";

    @GetMapping
    public List<Map<String, Object>> listarEmpleados()
            throws Exception {

        List<Map<String, Object>> empleados = new ArrayList<>();

        String sql = """
            SELECT Id, Nombre, Documento, Salario,
                   IdArea, IdCargo, Estado
            FROM rhmanager_empleados
            ORDER BY Id
            """;

        try (Connection conexion = DriverManager.getConnection(
                    url, usuario, clave);
             PreparedStatement consulta =
                    conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {

            while (resultado.next()) {
                Map<String, Object> empleado =
                    new LinkedHashMap<>();

                empleado.put("id", resultado.getInt("Id"));
                empleado.put("nombre", resultado.getString("Nombre"));
                empleado.put("documento",
                    resultado.getString("Documento"));
                empleado.put("salario",
                    resultado.getBigDecimal("Salario"));
                empleado.put("idArea", resultado.getInt("IdArea"));
                empleado.put("idCargo", resultado.getInt("IdCargo"));
                empleado.put("estado", resultado.getBoolean("Estado"));

                empleados.add(empleado);
            }
        }

        return empleados;
    }
    
@GetMapping("/{id}")
public Map<String, Object> consultarEmpleado(
        @org.springframework.web.bind.annotation.PathVariable int id)
        throws Exception {

    String sql = """
        SELECT Id, Nombre, Documento, Salario,
               IdArea, IdCargo, Estado
        FROM rhmanager_empleados
        WHERE Id = ?
        """;

    try (Connection conexion =
                DriverManager.getConnection(url, usuario, clave);
         PreparedStatement consulta =
                conexion.prepareStatement(sql)) {

        consulta.setInt(1, id);

        try (ResultSet resultado = consulta.executeQuery()) {
            if (resultado.next()) {
                Map<String, Object> empleado =
                    new LinkedHashMap<>();

                empleado.put("id", resultado.getInt("Id"));
                empleado.put("nombre", resultado.getString("Nombre"));
                empleado.put("documento",
                    resultado.getString("Documento"));
                empleado.put("salario",
                    resultado.getBigDecimal("Salario"));
                empleado.put("idArea", resultado.getInt("IdArea"));
                empleado.put("idCargo", resultado.getInt("IdCargo"));
                empleado.put("estado", resultado.getBoolean("Estado"));

                return empleado;
            }
        }
    }

    throw new org.springframework.web.server.ResponseStatusException(
        org.springframework.http.HttpStatus.NOT_FOUND,
        "Empleado no encontrado"
    );
}

    @org.springframework.web.bind.annotation.PostMapping
    public Map<String, Object> registrarEmpleado(
            @org.springframework.web.bind.annotation.RequestBody
            Map<String, Object> datos) throws Exception {

        String sql = """
            INSERT INTO rhmanager_empleados
            (Nombre, Documento, Salario, IdArea, IdCargo, Estado)
            VALUES (?, ?, ?, ?, ?, 1)
            """;

        try (Connection conexion =
                    DriverManager.getConnection(url, usuario, clave);
             PreparedStatement consulta =
                    conexion.prepareStatement(
                        sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            consulta.setString(1, datos.get("nombre").toString());
            consulta.setString(2, datos.get("documento").toString());
            consulta.setBigDecimal(3,
                new java.math.BigDecimal(datos.get("salario").toString()));
            consulta.setInt(4,
                Integer.parseInt(datos.get("idArea").toString()));
            consulta.setInt(5,
                Integer.parseInt(datos.get("idCargo").toString()));

            consulta.executeUpdate();

            try (ResultSet resultado = consulta.getGeneratedKeys()) {
                if (resultado.next()) {
                    Map<String, Object> respuesta = new LinkedHashMap<>();
                    respuesta.put("mensaje", "Empleado registrado correctamente");
                    respuesta.put("id", resultado.getInt(1));
                    return respuesta;
                }
            }
        }

        throw new Exception("No fue posible registrar el empleado");
    }
    
    @org.springframework.web.bind.annotation.PutMapping("/{id}")
    public Map<String, Object> actualizarEmpleado(
            @org.springframework.web.bind.annotation.PathVariable int id,
            @org.springframework.web.bind.annotation.RequestBody
            Map<String, Object> datos) throws Exception {

        String sql = """
            UPDATE rhmanager_empleados
            SET Nombre = ?, Documento = ?, Salario = ?,
                IdArea = ?, IdCargo = ?
            WHERE Id = ?
            """;

        try (Connection conexion =
                    DriverManager.getConnection(url, usuario, clave);
             PreparedStatement consulta =
                    conexion.prepareStatement(sql)) {

            consulta.setString(1, datos.get("nombre").toString());
            consulta.setString(2, datos.get("documento").toString());
            consulta.setBigDecimal(3,
                new java.math.BigDecimal(datos.get("salario").toString()));
            consulta.setInt(4,
                Integer.parseInt(datos.get("idArea").toString()));
            consulta.setInt(5,
                Integer.parseInt(datos.get("idCargo").toString()));
            consulta.setInt(6, id);

            int filas = consulta.executeUpdate();

            if (filas > 0) {
                Map<String, Object> respuesta = new LinkedHashMap<>();
                respuesta.put("mensaje", "Empleado actualizado correctamente");
                respuesta.put("id", id);
                return respuesta;
            }
        }

        throw new org.springframework.web.server.ResponseStatusException(
            org.springframework.http.HttpStatus.NOT_FOUND,
            "Empleado no encontrado"
        );
    }
    
    @org.springframework.web.bind.annotation.DeleteMapping("/{id}")
    public Map<String, Object> inactivarEmpleado(
            @org.springframework.web.bind.annotation.PathVariable int id)
            throws Exception {

        String sql = """
            UPDATE rhmanager_empleados
            SET Estado = 0
            WHERE Id = ?
            """;

        try (Connection conexion =
                    DriverManager.getConnection(url, usuario, clave);
             PreparedStatement consulta =
                    conexion.prepareStatement(sql)) {

            consulta.setInt(1, id);

            int filas = consulta.executeUpdate();

            if (filas > 0) {
                Map<String, Object> respuesta = new LinkedHashMap<>();
                respuesta.put("mensaje", "Empleado inactivado correctamente");
                respuesta.put("id", id);
                respuesta.put("estado", false);
                return respuesta;
            }
        }

        throw new org.springframework.web.server.ResponseStatusException(
            org.springframework.http.HttpStatus.NOT_FOUND,
            "Empleado no encontrado"
        );
    }
}