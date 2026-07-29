package modelo;

/**
 * Clase que representa la información de un empleado
 * del sistema RHManager.
 */

public class Empleado {


 // Atributos del empleado
    private int id;
    private String nombre;
    private String documento;
    private double salario;
    private int idArea;
    private int idCargo;
    private boolean estado;


    // constructor

    // getters

    // setters

    // Constructor vacío
    public Empleado() {
    }

    // Constructor con parámetros
    public Empleado(int id, String nombre, String documento,
                     double salario, int idArea,
                     int idCargo, boolean estado) {

        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.salario = salario;
        this.idArea = idArea;
        this.idCargo = idCargo;
        this.estado = estado;
    }

    // Métodos Get y Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}