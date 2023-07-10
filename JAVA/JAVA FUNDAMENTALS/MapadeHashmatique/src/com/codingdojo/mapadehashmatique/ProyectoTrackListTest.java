package com.codingdojo.mapadehashmatique;

public class ProyectoTrackListTest {

	public static void main(String[] args) {
		
		ProyectoTrackList misFavoritos = new ProyectoTrackList();
		
		//AGREGANDO CANCIONES
		misFavoritos.agregarTrack("Violet Hill", "Was a long and dark December...");
		misFavoritos.agregarTrack("Time", "Ticking away the moments that make up a dull day...");
		misFavoritos.agregarTrack("Puente", "Hoy te busqué\r\n" + "En la rima que duerme\r\n" + "Con todas las palabras...");
		misFavoritos.agregarTrack("Coloratura", "Coloratura\r\n" + "We fell in through the clouds...");
		misFavoritos.agregarTrack("Sweet Child O' Mine", "She's got a smile that it seems to me...");
		misFavoritos.agregarTrack("Let It Be", "Should we do something else for a while...");
		
		//OBTENIENDO LETRAS DE CANCIONES
//		misFavoritos.obtenerTrack("Puente");
//		misFavoritos.obtenerTrack("Coloratura");
		
		//BUSCANDO CANCIONES NO AGREGADAS
//		misFavoritos.obtenerTrack("   coloratura");
//		misFavoritos.obtenerTrack("  LET IT BE  ");
		
		//MOSTRANDO LISTA COMPLETA DE CANCIONES
//		misFavoritos.mostarTrackList();
	}
}
