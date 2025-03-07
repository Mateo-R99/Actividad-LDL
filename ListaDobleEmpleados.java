public class ListaDobleEmpleados {
    private Empleado head, tail;

    public void insertarEmpleado(Empleado empleado) {
        if (head == null) {
            head = tail = empleado;
        } else {
            tail.next = empleado;
            empleado.prev = tail;
            tail = empleado;
        }
        mostrarEstadisticas();
    }

    public Empleado buscarEmpleado(int id) {
        Empleado actual = head;
        while (actual != null) {
            if (actual.id == id) return actual;
            actual = actual.next;
        }
        return null;
    }

    public void eliminarEmpleado(int id) {
        Empleado actual = buscarEmpleado(id);
        if (actual == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }
        
        if (actual.prev != null) {
            actual.prev.next = actual.next;
        } else {
            head = actual.next;
        }
        
        if (actual.next != null) {
            actual.next.prev = actual.prev;
        } else {
            tail = actual.prev;
        }
        
        System.out.println("Empleado eliminado correctamente.");
        mostrarEstadisticas();
    }

    public void ordenarPorNombre(boolean ascendente) {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Empleado actual = head;
            while (actual.next != null) {
                if ((ascendente && actual.nombre.compareTo(actual.next.nombre) > 0) ||
                    (!ascendente && actual.nombre.compareTo(actual.next.nombre) < 0)) {
                    intercambiar(actual, actual.next);
                    swapped = true;
                }
                actual = actual.next;
            }
        } while (swapped);
    }

    public void ordenarPorSalario(boolean ascendente) {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Empleado actual = head;
            while (actual.next != null) {
                if ((ascendente && actual.salario > actual.next.salario) ||
                    (!ascendente && actual.salario < actual.next.salario)) {
                    intercambiar(actual, actual.next);
                    swapped = true;
                }
                actual = actual.next;
            }
        } while (swapped);
    }

    private void intercambiar(Empleado a, Empleado b) {
        String tempNombre = a.nombre;
        int tempId = a.id;
        float tempSalario = a.salario;

        a.nombre = b.nombre;
        a.id = b.id;
        a.salario = b.salario;

        b.nombre = tempNombre;
        b.id = tempId;
        b.salario = tempSalario;
    }

    public float calcularPromedioSalario() {
        float suma = 0;
        int count = 0;
        Empleado actual = head;
        while (actual != null) {
            suma += actual.salario;
            count++;
            actual = actual.next;
        }
        return (count == 0) ? 0 : suma / count;
    }

    public Empleado encontrarSalarioMaximo() {
        if (head == null) return null;
        Empleado max = head;
        Empleado actual = head.next;
        while (actual != null) {
            if (actual.salario > max.salario) {
                max = actual;
            }
            actual = actual.next;
        }
        return max;
    }

    public Empleado encontrarSalarioMinimo() {
        if (head == null) return null;
        Empleado min = head;
        Empleado actual = head.next;
        while (actual != null) {
            if (actual.salario < min.salario) {
                min = actual;
            }
            actual = actual.next;
        }
        return min;
    }

    public float obtenerMedianaSalario() {
        ordenarPorSalario(true);
        int n = contarEmpleados();
        if (n == 0) return 0;
        Empleado actual = head;
        for (int i = 0; i < n / 2; i++) actual = actual.next;
        return (n % 2 == 1) ? actual.salario : (actual.salario + actual.prev.salario) / 2;
    }

    public void imprimirLista() {
        Empleado actual = head;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.next;
        }
    }

    public int contarEmpleados() {
        int count = 0;
        Empleado actual = head;
        while (actual != null) {
            count++;
            actual = actual.next;
        }
        return count;
    }

    public void mostrarEstadisticas() {
        int total = contarEmpleados();
        System.out.println("Número total de empleados: " + total);

        if (total == 0) {
            System.out.println("No hay empleados en la lista.");
            return;
        }

        System.out.printf("Salario promedio: %.2f%n", calcularPromedioSalario());
        
        Empleado max = encontrarSalarioMaximo();
        if (max != null) {
            System.out.printf("Salario máximo: ID: %d, Nombre: %s, Salario: %.2f%n", 
                max.id, max.nombre, max.salario);
        }

        Empleado min = encontrarSalarioMinimo();
        if (min != null) {
            System.out.printf("Salario mínimo: ID: %d, Nombre: %s, Salario: %.2f%n", 
                min.id, min.nombre, min.salario);
        }

        if (total > 1) {
            System.out.printf("Mediana de los salarios: %.2f%n", obtenerMedianaSalario());
        } else {
            System.out.println("Mediana de los salarios: No aplicable (solo un empleado).");
        }
    }
}