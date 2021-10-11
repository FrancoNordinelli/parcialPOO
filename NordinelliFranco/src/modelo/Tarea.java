package modelo;

import java.time.LocalDate;

public class Tarea {

	 private int idTarea;
	 private String tarea;
	 private LocalDate fechaInicio;
	 private LocalDate fechaFin;
	 private Empleado empleado;
	 private int cantHorasDiarias;
	 private boolean habil;
	 
	 
	
	public Tarea() {
	}

	public Tarea(String tarea, LocalDate fechaInicio, LocalDate fechaFin, Empleado empleado, int cantHorasDiarias,
			boolean habil) {
		super();
		this.tarea = tarea;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empleado = empleado;
		this.cantHorasDiarias = cantHorasDiarias;
		this.habil = habil;
	}

	public Tarea(int idTarea, String tarea, LocalDate fechaInicio, LocalDate fechaFin, Empleado empleado,
			int cantHorasDiarias, boolean habil) {
		this.idTarea = idTarea;
		this.tarea = tarea;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empleado = empleado;
		this.cantHorasDiarias = cantHorasDiarias;
		this.habil = habil;
	}
	
	
	public double calcularJornal() {
		double resultado;
		if(habil) {
			resultado = cantHorasDiarias*empleado.getValorHora();
		}else {
			resultado = cantHorasDiarias*empleado.getValorHora()*1.5;
		}
		return resultado;
	}
	
	public int calcularCantDiasTrabajados(int mes, int anio) {
		int diasSemana = 0;
		int finSemana = 0;
		int dias = 0;
		LocalDate inicioMes = LocalDate.of(anio, mes, 1);
		LocalDate finMes = LocalDate.of(anio, mes, inicioMes.lengthOfMonth());
		if(inicioMes.isBefore(fechaInicio)) {
			inicioMes = fechaInicio;
		}
		if(finMes.isAfter(fechaFin)) {
			finMes = fechaFin;
		}
		while(!(inicioMes.isAfter(finMes))){
			int diaSemana = inicioMes.getDayOfWeek().getValue();
			if (diaSemana>=1 && diasSemana <=5) {
				diasSemana ++;
			}else {
				finSemana ++;
			}
			inicioMes = inicioMes.plusDays(1);
		}
		if(habil) {
			dias = diasSemana;
		}else {
			dias = finSemana;
		}	
		return dias;
	}
	
	public double calcularHonorarios(int mes, int anio) {
		return calcularCantDiasTrabajados(mes, anio)*calcularJornal();
	}
	
	public int getIdTarea() {
		return idTarea;
	}
	@Override
	public String toString() {
		return "Tarea [idTarea=" + idTarea + ", tarea=" + tarea + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", empleado=" + empleado + ", cantHorasDiarias=" + cantHorasDiarias + ", habil=" + habil
				+ "]";
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getCantHorasDiarias() {
		return cantHorasDiarias;
	}
	public void setCantHorasDiarias(int cantHorasDiarias) {
		this.cantHorasDiarias = cantHorasDiarias;
	}
	public boolean isHabil() {
		return habil;
	}
	public void setHabil(boolean habil) {
		this.habil = habil;
	}
	 
	 
}
