package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Empleado> lstEmpleados = new ArrayList<Empleado>();
	private List<Tarea> lstTareas = new ArrayList<Tarea>();
	
	
	public Sistema() {
	}
	
	public boolean agregarEmpleado(String apellido, String nombre, String nroLegajo, double valorHora) {
		Empleado emp = new Empleado(apellido, nombre, nroLegajo, valorHora);
		return lstEmpleados.add(emp);
	} 
	
	public Empleado traerEmpleado(String nroLegajo) {
		Empleado emp = null;
		int i = 0;
		while(emp == null && lstEmpleados.size()>i) {
			if(nroLegajo.equals(lstEmpleados.get(i).getNroLegajo())) {
				emp = lstEmpleados.get(i);
			}
			i++;
		}
		return emp;
	}
	
	public boolean agregarTarea(String tarea, LocalDate fechaInicio, LocalDate fechaFin, Empleado
			responsable, int cantHorasDiarias, boolean habil) {
		//Tarea tar = new Tarea(tarea, fechaInicio, fechaFin, responsable, cantHorasDiarias, habil);
			//tar.setIdTarea(lstTareas.size()+1);//MAL. Si la lista sufre modificaciones, se rompe todo
		//Mejor solución
		int id = 1;
		if(lstTareas.size()!=0) 
			id = lstTareas.get(lstTareas.size()-1).getIdTarea()+1;
			Tarea tar = new Tarea(id, tarea, fechaInicio, fechaFin, responsable, cantHorasDiarias, habil);
		return lstTareas.add(tar);
	} 
	
	public Tarea traerTarea(int id){
		Tarea tar = null;
		int i = 0;
		while (i < lstTareas.size() && tar == null) {
			if(lstTareas.get(i).getIdTarea()==id) {
				tar = lstTareas.get(i);
			}
			i++;
		}
		return tar;
	}
	
	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}
	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}
	public List<Tarea> getLstTareas() {
		return lstTareas;
	}
	public void setLstTareas(List<Tarea> lstTareas) {
		this.lstTareas = lstTareas;
	}

	
}
