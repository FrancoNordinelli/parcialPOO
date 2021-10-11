package test;

import java.time.LocalDate;

import modelo.Sistema;

public class Test {

	public static void main(String[] args) {

		Sistema sistema = new Sistema();

		//System.out.println("1)Agregar empleados");
		sistema.agregarEmpleado("Lopez", "Martin", "3829", 400.0);
		sistema.agregarEmpleado("Rodriguez", "Lucia", "3840", 500.0);
		System.out.println("Se muestran los empleados");
		System.out.println(sistema.getLstEmpleados());

		System.out.println("\n2)Traer empleado 3840");
		System.out.println(sistema.traerEmpleado("3840"));

		//System.out.println("3)Agregar tareas");
		sistema.agregarTarea("Reparación Alsina altura 1500-1600", LocalDate.of(2021, 5, 25), LocalDate.of(2021,6,10), sistema.getLstEmpleados().get(0), 4, true);
		sistema.agregarTarea("Reparación semaforo Alsina y Gallo", LocalDate.of(2021, 6, 21), LocalDate.of(2021,7,11), sistema.getLstEmpleados().get(1), 4, false);

		System.out.println("4)Traer tareas ");
		System.out.println(sistema.traerTarea(1));
		System.out.println(sistema.traerTarea(2));

		System.out.println("5)Calcular Jornal tarea id=1");
		System.out.println(sistema.traerTarea(1).calcularJornal());

		System.out.println("6) Para la tarea id=1, calcular calcular los días trabajados mes=6, anio=2021");
		System.out.println(sistema.traerTarea(2).calcularCantDiasTrabajados(6, 2021));
		
		System.out.println("7) Para la tarea id=1, calcular calcular honorarios mes=6, anio=2021");
		System.out.println(sistema.traerTarea(1).calcularHonorarios(6,2021));
	}

}
