public class Empleado {
    String nombre;
    int id;
    float salario;
    Empleado prev, next;

    public Empleado(String nombre, int id, float salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
        this.prev = this.next = null;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario;
    }
}
