package com.codingdojo.proyectoclass;

public class ProyectoClassTest {

	public static void main(String[] args) {
		
		//Proyectos - Aplicando sobrecarga de metodos
		ProyectoClass sawPlex = new ProyectoClass();
		
		ProyectoClass santinox = new ProyectoClass("Santinox");
		
		ProyectoClass kikaNails = new ProyectoClass("Kika Nails", "Es un emprendimiento que se dedica "
				+ "al cuidado y embellecimiento de uñas.");
		
		//Aplicando Setters
		sawPlex.setNombre("Saw Plex");
		sawPlex.setDescripcion("Es una empresa que se dedica a la compra y venta de vehiculos.");
		santinox.setDescripcion("Es una empresa contratista que se dedica a prestar servicios de mantencion"
				+ "y trabajos de acero inoxidable.");
		
		//Aplicando Getters
		System.out.println(kikaNails.getDescripcion());
		System.out.println(santinox.getDescripcion());
		System.out.println(sawPlex.getNombre());
		
		//ElevatorPitch para cada proyecto (nombre+descripcion)
		String pitchSawPlex = sawPlex.elevatorPitch();
		String pitchSantinox = santinox.elevatorPitch();
		String pitchKikaNails = kikaNails.elevatorPitch();
		
		//Aplicando elevatorPitch
		System.out.println(pitchKikaNails);
		System.out.println(pitchSantinox);
		System.out.println(pitchSawPlex);
	}
}
