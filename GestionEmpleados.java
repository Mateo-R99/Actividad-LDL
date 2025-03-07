import java.util.Scanner;

public class GestionEmpleados {
    public static void main(String[] args) {
        ListaDobleEmpleados lista = new ListaDobleEmpleados();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Insertar Empleado");
            System.out.println("2. Buscar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Ordenar por Nombre");
            System.out.println("5. Ordenar por Salario");
            System.out.println("6. Mostrar Lista");
            System.out.println("7. Mostrar Estadísticas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    sc.nextLine(); 
                    String nombre = sc.nextLine();  
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Salario: ");
                    float salario = sc.nextFloat();
                    lista.insertarEmpleado(new Empleado(nombre, id, salario));
                    break;

                case 2:
                    System.out.print("ID del empleado a buscar: ");
                    Empleado encontrado = lista.buscarEmpleado(sc.nextInt());
                    System.out.println(encontrado != null ? encontrado : "Empleado no encontrado.");
                    break;
                case 3:
                    System.out.print("ID del empleado a eliminar: ");
                    lista.eliminarEmpleado(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Orden ascendente (true/false): ");
                    lista.ordenarPorNombre(sc.nextBoolean());
                    break;
                case 5:
                    System.out.print("Orden ascendente (true/false): ");
                    lista.ordenarPorSalario(sc.nextBoolean());
                    break;
                case 6:
                    lista.imprimirLista();
                    break;
                case 7:
                    lista.mostrarEstadisticas();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
